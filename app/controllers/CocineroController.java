package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.PagedList;
import models.Cocinero;
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

@esKeyValida
public class CocineroController extends Controller {

    @Inject
    FormFactory frmFactory;

    @Inject
    private SyncCacheApi cache;

    Cachefunctions cachefunctions;

    public Result index() {
        return ok("CocineroController");
    }

    @esCocinero
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
            cachefunctions.vaciarCacheListas("cocineros", Cocinero.numCocineros(), cache);
            return Results.created();
        } else {
            return Results.badRequest();
        }

    }

    @esCocinero
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

        Ebean.beginTransaction();
        try {
            // vaciamos caché
            cachefunctions.vaciarCacheCompleta("cocinero" + id, "cocineros", Cocinero.numCocineros(), cache);
            cocineroUpdate.update();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

        return Results.ok();
    }

    public Result obtenerCocineros(Integer page) {
        String key = "cocineros" + page;
        String keyResJson = "cocineros" + page + "resJson";

        List<Cocinero> listaCocineros = cache.get(key);
        if (listaCocineros == null) {
            PagedList<Cocinero> listaPaginadaCocineros = Cocinero.findAll(page);
            listaCocineros = listaPaginadaCocineros.getList();
            cache.set(key, listaCocineros);
        }

        if (listaCocineros == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listacocineros.render(listaCocineros));
            // return Results.ok();
        } else if (request().accepts("application/json")) {

            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = Json.toJson(listaCocineros);
                cache.set(keyResJson, resultado);
            }
            return Results
                    .ok(resultado);
        } else {
            return Results
                    .status(415);
        }
    }

    public Result obtenerCocinero(Long id) {

        String key = "cocinero" + id;
        String keyResJson = "cocinero" + id + "resJson";

        Cocinero cocinero = cache.get(key);
        if (cocinero == null) {
            cocinero = Cocinero.findById(id);
            cache.set(key, cocinero);
        }

        if (cocinero == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.cocinero.render(cocinero));
            // return Results.ok();
        } else if (request().accepts("application/json")) {

            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = cocinero.toJson();
                cache.set(keyResJson, resultado);
            }

            return Results
                    .ok(resultado);
        } else {
            return Results
                    .status(415);
        }
    }

    @esCocinero
    public Result borrarCocinero(Long id) {
        Cocinero cocinero = Cocinero.findById(id);
        // Si encuentra al cocinero lo elimina
        if (cocinero != null) {
            Ebean.beginTransaction();
            try {
                cachefunctions.vaciarCacheCompleta("cocinero" + id, "cocineros", Cocinero.numCocineros(), cache);
                cocinero.delete();
                Ebean.commitTransaction();
            } finally {
                Ebean.endTransaction();
            }
        }

        // Siempre devuelve OK para la idempotencia
        return Results.ok();
    }

}
