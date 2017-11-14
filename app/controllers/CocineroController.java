package controllers;

import models.Cocinero;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;


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

        // Checkeamos y guardamos
        if (nuevoCocinero.checkAndSave()) {
            return Results.created();
        } else {
            return Results.badRequest();
        }
    }

    public Result editarCocinero(Long id) {
        // Comprobamos que el usuario existe
        if(Cocinero.findById(id) == null){
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
        return Results.ok("Obtenemos los cocineros");
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
        Cocinero cocineroBorrar = Cocinero.findById(id);
        if (cocineroBorrar != null){
            if(!cocineroBorrar.delete()){
                Results.internalServerError();
            }
        }
        return Results.ok();
    }

}
