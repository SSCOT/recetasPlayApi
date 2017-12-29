package controllers;

import models.Paso;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.List;


public class PasoController extends Controller {

    @Inject
    FormFactory frmFactory;

    public Result index() {
        return ok("PasoController Works!");
    }

    public Result crearPaso(){

        // Recogemos los datos por formulario
        Form<Paso> frm = frmFactory.form(Paso.class).bindFromRequest();

        // Comprobación de errores
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Paso nuevoPaso = frm.get();

        // Checkeamos y guardamos
        if (nuevoPaso.checkAndCreate()) {
            return Results.created();
        } else {
            return Results.badRequest();
        }

    }

    public Result editarPaso(Long id) {
        // Comprobamos que el usuario existe
        if (Paso.findById(id) == null) {
            return Results.notFound();
        }

        // Recogemos los datos por formulario
        Form<Paso> frm = frmFactory.form(Paso.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        // El indice de ordenación no se puede editar. Lo controlamos
        Paso pasoInicial = frm.get();
        Paso pasoUpdate = new Paso();
        pasoUpdate.setId(id);
        pasoUpdate.setDescripcion(pasoInicial.getDescripcion());
        pasoUpdate.setTiempo(pasoInicial.getTiempo());
        pasoUpdate.update();

        return Results.ok();

    }

    // El listado de pasos solo tiene sentido cuando es de una determinada receta
    public Result obtenerPasos(Long idReceta) {
        List<Paso> listaPasos = Paso.findByReceta(idReceta);

        if (listaPasos == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listapasos.render(listaPasos));
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(Json.toJson(listaPasos));
        } else {
            return Results
                    .status(415);
        }

    }

    public Result obtenerPaso(Long id) {
        Paso paso = Paso.findById(id);

        if (paso == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.paso.render(paso));
            // return Results.ok();
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(paso.toJson());
        } else {
            return Results
                    .status(415);
        }
    }

    public Result borrarPaso(Long id) {
        Paso paso = Paso.findById(id);

        if(paso != null)
            paso.checkAndDelete();

        return Results.ok();
    }

}
