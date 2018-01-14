package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.PagedList;
import models.Paso;
import models.Receta;
import play.cache.SyncCacheApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import utils.Cachefunctions;
import utils.SeguridadFunctions;

import javax.inject.Inject;
import java.util.List;


public class PasoController extends Controller {

    @Inject
    FormFactory frmFactory;

    @Inject
    private SyncCacheApi cache;

    private Cachefunctions cachefunctions;

    public Result index() {
        return ok("PasoController Works!");
    }

    @esCocinero
    public Result crearPaso() {
        // Recogemos los datos por formulario
        Form<Paso> frm = frmFactory.form(Paso.class).bindFromRequest();

        // Comprobación de errores
        if (frm.hasErrors()) {
            return status(409, frm.errorsAsJson());
        }

        Paso nuevoPaso = frm.get();

        // Comprobar autor
        String key = request().getQueryString("apikey");
        if (SeguridadFunctions.esAutorReceta(nuevoPaso.p_receta.getId(), key) == false)
            return Results.badRequest();

        // Checkeamos y guardamos
        if (nuevoPaso.checkAndCreate()) {
            cachefunctions.vaciarCacheListas("pasos", Paso.numPasos(), cache);
            cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);
            return Results.created();
        } else {
            return Results.badRequest();
        }

    }

    @esCocinero
    public Result editarPaso(Long id) {

        Paso paso = Paso.findById(id);

        // Comprobamos que el paso existe
        if (paso == null) {
            return Results.notFound();
        }

        // Comprobar autor
        String key = request().getQueryString("apikey");
        if (SeguridadFunctions.esAutorReceta(paso.p_receta.getId(), key) == false)
            return Results.badRequest();

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
        cachefunctions.vaciarCacheCompleta("paso"+id, "pasos", Paso.numPasos(), cache);
        cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);

        return Results.ok();

    }

    // El listado de pasos solo tiene sentido cuando es de una determinada receta
    public Result obtenerPasos(Long idReceta, Integer page) {
        String key = "pasos" + page + "receta" + idReceta;
        String keyResJson = "pasos" + page + "receta" + idReceta + "resJson";

        List<Paso> listaPasos = cache.get(key);
        if (listaPasos == null) {
            PagedList<Paso> listaPaginadaPasos = Paso.findByReceta(idReceta, page);
            listaPasos = listaPaginadaPasos.getList();
            cache.set(key, listaPasos);
        }

        if (listaPasos == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listapasos.render(listaPasos));
        } else if (request().accepts("application/json")) {

            JsonNode resJson = cache.get(keyResJson);
            if (resJson == null) {
                resJson = Json.toJson(listaPasos);
                cache.set(keyResJson, resJson);
            }

            return Results
                    .ok(resJson);
        } else {
            return Results
                    .status(415);
        }

    }

    public Result obtenerPaso(Long id) {
        String key = "paso" + id;
        String keyResJson = "paso" + id + "resJson";
        Paso paso = cache.get(key);
        if (paso == null) {
            paso = Paso.findById(id);
            cache.set(key, paso);
        }

        if (paso == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.paso.render(paso));
            // return Results.ok();
        } else if (request().accepts("application/json")) {

            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = paso.toJson();
                cache.set(keyResJson, resultado);
            }

            return Results
                    .ok(paso.toJson());
        } else {
            return Results
                    .status(415);
        }
    }

    @esCocinero
    public Result borrarPaso(Long id) {
        Paso paso = Paso.findById(id);

        // Comprobar autor
        String key = request().getQueryString("apikey");
        if (SeguridadFunctions.esAutorReceta(paso.p_receta.getId(), key) == false)
            return Results.badRequest();

        if (paso != null){
            Ebean.beginTransaction();
            try{
                paso.checkAndDelete();
                cachefunctions.vaciarCacheCompleta("paso"+id, "pasos", Paso.numPasos(), cache);
                cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);
                Ebean.commitTransaction();
            } finally {
                Ebean.endTransaction();
            }
        }
        return Results.ok();
    }

}
