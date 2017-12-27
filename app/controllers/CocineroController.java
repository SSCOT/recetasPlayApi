package controllers;

import models.Cocinero;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class CocineroController extends Controller {

    @Inject
    FormFactory frmFactory;

    public Result index() {
        return ok("CocineroController");
    }

    public Result crearCocinero() {
        // Recogemos los datos por formulario
        Form<Cocinero> frm = frmFactory.form(Cocinero.class).bindFromRequest();

        // Comprobación de errores
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        // Ya tenemos el nuevo cocinero
        Cocinero nuevoCocinero = frm.get();

        // Comprobamos que el cocinero no existe con el nombre y los apellidos
        if (Cocinero.findByNombre(nuevoCocinero.getNombre(), nuevoCocinero.getApellido()) != null) {
            return Results.badRequest();
        }

        // Checkeamos y guardamos
        if (nuevoCocinero.checkAndCreate()) {
            return Results.created();
        } else {
            return Results.badRequest();
        }

    }

    public Result editarCocinero(Long id) {
        // Comprobamos que el usuario existe
        if (Cocinero.findById(id) == null) {
            return Results.notFound();
        }

        // Recogemos los datos por formulario
        Form<Cocinero> frm = frmFactory.form(Cocinero.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Cocinero cocineroUpdate = frm.get();
        cocineroUpdate.setId(id);
        cocineroUpdate.update();
        return Results.ok();

    }

    public Result obtenerCocineros() {
        List<Cocinero> listaCocineros = Cocinero.findAll();


        if (listaCocineros == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listacocineros.render(listaCocineros));
            // return Results.ok();
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(Json.toJson(listaCocineros));
            //.ok(Json.toJson(listaCocineros)).as("application/json");
        } else {
            return Results
                    .status(415);
        }
    }

    public Result obtenerCocinero(Long id) {
        Cocinero cocinero = Cocinero.findById(id);

        if (cocinero == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.cocinero.render(cocinero));
            // return Results.ok();
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(cocinero.toJson());
        } else {
            return Results
                    .status(415);
        }
    }

    public Result borrarCocinero(Long id) {
        Cocinero cocinero = Cocinero.findById(id);

        // Si encuentra al cocinero lo elimina
        if(cocinero != null)
            cocinero.delete();

        // Siempre devuelve OK para la idempotencia
        return Results.ok();
    }

}
