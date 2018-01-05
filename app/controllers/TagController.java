package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import models.Paso;
import models.Receta;
import models.Tag;
import play.cache.SyncCacheApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import utils.Cachefunctions;

import javax.inject.Inject;
import java.util.List;


public class TagController extends Controller {

    @Inject
    FormFactory frmFactory;

    @Inject
    private SyncCacheApi cache;

    Cachefunctions cachefunctions;

    public Result index() {
        return ok("TagController Works!");
    }

    public Result crearTag() {
        Form<Tag> frm = frmFactory.form(Tag.class).bindFromRequest();

        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Tag nuevoTag = frm.get();

        // Checkeamos y guardamos
        if (nuevoTag.checkAndCreate()) {
            cachefunctions.vaciarCacheListas("tags",Tag.numTags(), cache);
            return Results.created();
        } else {
            return Results.badRequest();
        }
    }

    public Result editarTag(Long id) {
        if (id == null) {
            return Results.badRequest();
        } else if (Tag.findById(id) == null) {
            return Results.notFound();
        }

        Form<Tag> frm = frmFactory.form(Tag.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Tag tagUpdate = frm.get();
        tagUpdate.setId(id);

        if (tagUpdate.checkAndUpdate()) {
            cachefunctions.vaciarCacheCompleta("tag"+id, "tags", Tag.numTags(), cache);
            return Results.ok();
        } else {
            return Results.badRequest();
        }
    }

    // obtener los tags de una receta
    public Result obtenerTags(Long idReceta) {

        String key = "tags" + idReceta;
        String keyResJson = "tags" + idReceta + "resJson";

        List<Tag> listaTags = cache.get(key);
        if (listaTags == null) {
            listaTags = Tag.findByReceta(idReceta);
            cache.set(key, listaTags);
        }

        if (listaTags == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listatags.render(listaTags));
        } else if (request().accepts("application/json")) {
            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = Json.toJson(listaTags);
                cache.set(keyResJson, resultado);
            }

            return Results
                    .ok(resultado);
        } else {
            return Results
                    .status(415);
        }

    }

    public Result obtenerTag(Long id) {

        String key = "tag" + id;
        String keyResJson = "tag" + id + "resJson";

        Tag tag = cache.get(key);
        if (tag == null) {
            tag = Tag.findById(id);
            cache.set(key, tag);
        }

        if (tag == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.tag.render(tag));
            // return Results.ok();
        } else if (request().accepts("application/json")) {
            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = tag.toJson();
                cache.set(keyResJson, resultado);
            }
            return Results
                    .ok(resultado);
        } else {
            return Results
                    .status(415);
        }
    }

    public Result borrarTag(Long id) {
        Tag tag = Tag.findById(id);

        if (tag != null){
            Ebean.beginTransaction();
            try {
                tag.delete();
                cachefunctions.vaciarCacheCompleta("tag"+id,"tags",Tag.numTags(), cache);
                Ebean.commitTransaction();
            } finally {
                Ebean.endTransaction();
            }
        }

        // idempotencia
        return Results.ok();
    }

}
