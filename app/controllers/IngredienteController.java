package controllers;

import models.Cocinero;
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
        return ok("CocineroController");
    }

    public Result crearIngrediente(String nombre) {

        if(nombre == "")
            return Results.badRequest();

        // Comprobamos si existe ya el ingrediente
        if(Ingrediente.findByNombre(nombre) != null){
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
        if(id == null || nuevoNombre == ""){
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
        if (ingredienteBorrar != null){
            if(!ingredienteBorrar.delete()){
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
            // return Results.ok();
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(Json.toJson(listaIngredientes));
            //.ok(Json.toJson(listaCocineros)).as("application/json");
        } else {
            return Results
                    .status(415);
        }
    }

    /*public Result editarCocinero(Long id) {
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
        List<Cocinero> listaCocineros = Cocinero.findAll();


        if(listaCocineros == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listacocineros.render(listaCocineros));
            // return Results.ok();
        } else if (request().accepts("application/json")) {

            return Results.ok();
                    //.ok(Json.toJson(listaCocineros));
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
        Cocinero cocineroBorrar = Cocinero.findById(id);
        if (cocineroBorrar != null){
            if(!cocineroBorrar.delete()){
                Results.internalServerError();
            }
        }
        return Results.ok();
    }*/

}
