package controllers;

import models.Paso;
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

    public Result crearTag(){

        // Recogemos los datos por formulario
        Form<Tag> frm = frmFactory.form(Tag.class).bindFromRequest();

        // Comprobación de errores
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Tag nuevoTag = frm.get();

        // Checkeamos y guardamos
        if (nuevoTag.checkAndCreate()) {
            return Results.created();
        } else {
            return Results.badRequest();
        }

    }

    public Result editarTag(Long id) {
        // Comprobamos que el usuario existe
        if (Tag.findById(id) == null) {
            return Results.notFound();
        }

        Form<Tag> frm = frmFactory.form(Tag.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Tag tagUpdate = frm.get();
        tagUpdate.setId(id);
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
