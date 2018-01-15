package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.PagedList;
import models.Ingrediente;
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

@_esKeyValida
public class IngredienteController extends Controller {

    @Inject
    FormFactory frmFactory;

    @Inject
    private SyncCacheApi cache;

    public Result index() {
        return ok("IngredienteController");
    }

    @_esCocinero
    public Result crearIngrediente() {

        Form<Ingrediente> frm = frmFactory.form(Ingrediente.class).bindFromRequest();

        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Ingrediente nuevoIngrediente = frm.get();


        // Checkeamos y guardamos
        if (nuevoIngrediente.checkAndCreate()) {
            Cachefunctions.vaciarCacheListas("ingredientes", Ingrediente.numIngredientes(), cache);
            return Results.created();
        } else {
            return Results.badRequest();
        }
    }

    public Result obtenerIngredientes(Integer page) {
        String key = "ingredientes" + page;
        String keyResJson = "ingredientes" + page + "resJson";
        List<Ingrediente> listaIngredientes = cache.get(key);
        if (listaIngredientes == null) {
            PagedList<Ingrediente> listaPaginadaIngredientes = Ingrediente.findAll(page);
            listaIngredientes = listaPaginadaIngredientes.getList();
            cache.set(key, listaIngredientes);
        }

        if (listaIngredientes == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listaingredientes.render(listaIngredientes));
        } else if (request().accepts("application/json")) {
            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = Json.toJson(listaIngredientes);
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
    public Result editarIngrediente(Long id) {

        if (id == null) {
            return Results.badRequest();
        } else if (Ingrediente.findById(id) == null) {
            return Results.notFound();
        }

        Form<Ingrediente> frm = frmFactory.form(Ingrediente.class).bindFromRequest();
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Ingrediente ingredienteUpdate = frm.get();
        ingredienteUpdate.setId(id);

        if (ingredienteUpdate.checkAndUpdate()) {
            Cachefunctions.vaciarCacheCompleta("ingrediente"+id, "ingredientes", Ingrediente.numIngredientes(), cache);
            return Results.ok();
        } else {
            return Results.badRequest();
        }

    }

    @_esCocinero
    public Result borrarIngrediente(Long id) {
        Ingrediente ingredienteBorrar = Ingrediente.findById(id);
        if (ingredienteBorrar != null) {
            if (!ingredienteBorrar.delete()) {
                return Results.internalServerError();
            }
        }
        Cachefunctions.vaciarCacheCompleta("ingrediente"+id, "ingredientes", Ingrediente.numIngredientes(), cache);
        return Results.ok();
    }
}
