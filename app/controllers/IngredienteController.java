package controllers;

import models.Ingrediente;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.List;


public class IngredienteController extends Controller {

    @Inject
    FormFactory frmFactory;

    public Result index() {
        return ok("IngredienteController");
    }

    public Result crearIngrediente(String nombre) {

        if (nombre == "")
            return Results.badRequest();

        // Comprobamos si existe ya el ingrediente
        if (Ingrediente.findByNombre(nombre) != null) {
            return Results.badRequest();
        }


        Ingrediente nuevoIngrediente = new Ingrediente();
        nuevoIngrediente.setNombre(nombre);

        // Checkeamos y guardamos
        if (nuevoIngrediente.checkAndSave()) {
            return Results.created();
        } else {
            return Results.badRequest();
        }
    }

    public Result editarIngrediente(Long id, String nuevoNombre) {
        if (id == null || nuevoNombre == "") {
            return Results.badRequest();
        }

        Ingrediente ingredienteUpdate = new Ingrediente();
        ingredienteUpdate.setNombre(nuevoNombre);
        ingredienteUpdate.setId(id);
        ingredienteUpdate.update();

        return Results.ok();
    }

    public Result borrarIngrediente(Long id) {
        Ingrediente ingredienteBorrar = Ingrediente.findById(id);
        if (ingredienteBorrar != null) {
            if (!ingredienteBorrar.delete()) {
                Results.internalServerError();
            }
        }
        return Results.ok();
    }

    public Result obtenerIngredientes() {
        List<Ingrediente> listaIngredientes = Ingrediente.findAll();


        if (listaIngredientes == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listaingredientes.render(listaIngredientes));
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(Json.toJson(listaIngredientes));
        } else {
            return Results
                    .status(415);
        }
    }

    public Result editarIngrediente(Long id) {
        if (Ingrediente.findById(id) == null) {
            return Results.notFound();
        }

        Form<Ingrediente> frm = frmFactory.form(Ingrediente.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Ingrediente ingredienteUpdate = frm.get();
        ingredienteUpdate.setId(id);
        ingredienteUpdate.update();
        return Results.ok();

    }

    public Result obtenerIngrediente(Long id) {
        Ingrediente ingrediente = Ingrediente.findById(id);

        if (ingrediente == null) {
            return Results.notFound();
        }


        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.ingrediente.render(ingrediente));
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(ingrediente.toJson());
        } else {
            return Results
                    .status(415);
        }
    }
}
