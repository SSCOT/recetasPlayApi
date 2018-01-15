package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
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
import utils.SeguridadFunctions;

import javax.inject.Inject;
import java.util.List;

@_esKeyValida
public class TagController extends Controller {

    @Inject
    FormFactory frmFactory;

    @Inject
    private SyncCacheApi cache;

    public Result index() {
        return ok("TagController Works!");
    }

    @_esCocinero
    public Result crearTag() {
        Form<Tag> frm = frmFactory.form(Tag.class).bindFromRequest();

        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Tag nuevoTag = frm.get();

        // Comprobar autor
        String key = request().getQueryString("apikey");
        if (!SeguridadFunctions.esAutorReceta(nuevoTag.t_receta.getId(), key))
            return Results.badRequest();

        // Checkeamos y guardamos
        if (nuevoTag.checkAndCreate()) {
            Cachefunctions.vaciarCacheListas("tags", Tag.numTags(), cache);
            Cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);
            return Results.created();
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

    @_esCocinero
    public Result editarTag(Long id) {
        Tag tag = Tag.findById(id);

        if (id == null) {
            return Results.badRequest();
        } else if (tag == null) {
            return Results.notFound();
        }

        // Comprobar autor
        String key = request().getQueryString("apikey");
        if (!SeguridadFunctions.esAutorReceta(tag.t_receta.getId(), key))
            return Results.badRequest();

        Form<Tag> frm = frmFactory.form(Tag.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Tag tagUpdate = frm.get();
        tagUpdate.setId(id);

        if (tagUpdate.getTexto().isEmpty()) {
            return Results.badRequest();
        }

        tagUpdate.update();
        Cachefunctions.vaciarCacheCompleta("tag" + id, "tags", Tag.numTags(), cache);
        Cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);
        return Results.ok();

    }

    @_esCocinero
    public Result borrarTag(Long id) {
        Tag tag = Tag.findById(id);

        // Comprobar autor
        String key = request().getQueryString("apikey");
        if (!SeguridadFunctions.esAutorReceta(tag.t_receta.getId(), key))
            return Results.badRequest();

        if (tag != null) {
            Ebean.beginTransaction();
            try {
                tag.delete();
                Cachefunctions.vaciarCacheCompleta("tag" + id, "tags", Tag.numTags(), cache);
                Cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);
                Ebean.commitTransaction();
            } finally {
                Ebean.endTransaction();
            }
        }

        return Results.ok();
    }

}
