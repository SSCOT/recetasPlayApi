package controllers;

import io.ebean.Ebean;
import io.ebean.PagedList;
import models.Cocinero;
import models.Ingrediente;
import models.Receta;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.List;


public class RecetaController extends Controller {

    @Inject
    FormFactory frmFactory;

    public Result index() {
        return ok("RecetaController works!");
    }

    public Result crearReceta() {

        Form<Receta> frm = frmFactory.form(Receta.class).bindFromRequest();

        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }
        Receta nuevaReceta = frm.get();

        // Checkeamos y guardamos
        if (nuevaReceta.checkAndCreate()) {
            return Results.created();
        } else {
            return Results.badRequest();
        }
    }

    public Result anadirIngrediente(Long idReceta, Long idIngrediente) {

        // No puede llegar nada nulo
        if (idIngrediente == null || idReceta == null) {
            return Results.badRequest();
        }

        // Tienen que existir tanto la receta como el ingrediente
        Receta receta = Receta.findById(idReceta);
        Ingrediente ingrediente = Ingrediente.findById(idIngrediente);

        if (receta == null || ingrediente == null) {
            return Results.notFound();
        }

        if (Receta.asignarIngrediente(receta, ingrediente)) {
            return Results.created();
        }

        return Results.badRequest();
    }

    public Result quitarIngrediente(Long idReceta, Long idIngrediente) {
        // No puede llegar nada nulo
        if (idIngrediente == null || idReceta == null) {
            return Results.badRequest();
        }

        // Tienen que existir tanto la receta como el ingrediente
        Receta receta = Receta.findById(idReceta);
        Ingrediente ingrediente = Ingrediente.findById(idIngrediente);

        if (receta == null || ingrediente == null) {
            return Results.notFound();
        }

        Receta.quitarIngrediente(receta, ingrediente);

        // Idempotencia
        return Results.ok();
    }

    public Result anadirPaso(Long idReceta, Long idIngrediente, Long indice) {
        return Results.ok("Añadimos un paso determinado en el lugar que queremos");
    }

    public Result obtenerRecetas(Integer page) {
        PagedList<Receta> listaPaginadaRecetas = Receta.findAll(page);
        List<Receta> listaRecetas = listaPaginadaRecetas.getList();

        if (listaRecetas == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok();
                    // .ok(views.xml.listarecetas.render(listaRecetas));
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(Json.toJson(listaRecetas));
        } else {
            return Results
                    .status(415);
        }
    }

    public Result obtenerRecetasCocinero(Long idCocinero) {

        return Results.ok("Obtenemos las Recetas");
    }

    public Result obtenerReceta(Long id) {
        Receta receta = Receta.findById(id);

        if (receta == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.receta.render(receta));
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(receta.toJson());
        } else {
            return Results
                    .status(415);
        }
    }

    public Result obtenerIngredientes(Long id) {
        return Results.ok();
    }

    public Result editarReceta(Long id) {
        Form<Receta> frm = frmFactory.form(Receta.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        if (Receta.findById(id) == null) {
            return Results.notFound();
        }

        Receta recetaUpdate = frm.get();
        recetaUpdate.setId(id);
        recetaUpdate.update();
        return Results.ok();
    }

    public Result borrarReceta(Long id) {
        Receta receta = Receta.findById(id);

        if (receta != null)
            receta.delete();

        // Idempotencia
        return Results.ok();
    }

}
