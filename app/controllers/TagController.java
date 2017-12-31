package controllers;

import models.Paso;
import models.Receta;
import models.Tag;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.List;


public class TagController extends Controller {

    @Inject
    FormFactory frmFactory;

    public Result index() {
        return ok("TagController Works!");
    }

    public Result crearTag(String texto, Long idReceta){

        if (texto.isEmpty() || idReceta == null){
            return Results.badRequest();
        }

        // Comprobar existencia de la receta
        Receta receta = Receta.findById(idReceta);
        if (receta == null){
            return Results.notFound();
        }

        Tag nuevoTag = new Tag();
        nuevoTag.setTexto(texto);
        nuevoTag.t_receta = receta;

        nuevoTag.save();
        return Results.created();
    }

    public Result editarTag(Long id, String texto) {

        if(id == null || texto.isEmpty()){
            return Results.badRequest();
        }

        // Comprobamos que el usuario existe
        if (Tag.findById(id) == null) {
            return Results.notFound();
        }

        Tag tagUpdate = new Tag();
        tagUpdate.setId(id);
        tagUpdate.setTexto(texto);
        tagUpdate.update();
        return Results.ok();

    }

    // obtener los tags de una receta
    public Result obtenerTags(Long idReceta) {
        List<Tag> listaTags = Tag.findByReceta(idReceta);

        if (listaTags == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listatags.render(listaTags));
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(Json.toJson(listaTags));
        } else {
            return Results
                    .status(415);
        }

    }

    public Result obtenerTag(Long id) {
        Tag tag = Tag.findById(id);

        if (tag == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.tag.render(tag));
            // return Results.ok();
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(tag.toJson());
        } else {
            return Results
                    .status(415);
        }
    }

    public Result borrarTag(Long id) {
        Tag tag = Tag.findById(id);

        if(tag != null)
            tag.delete();

        // idempotencia
        return Results.ok();
    }

}
