package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.PagedList;
import models.Ingrediente;
import models.Receta;

import play.cache.SyncCacheApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import utils.Cachefunctions;

import javax.inject.Inject;

import java.util.*;


public class RecetaController extends Controller {

    @Inject
    FormFactory frmFactory;

    @Inject
    private SyncCacheApi cache;

    private Cachefunctions cachefunctions;

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
            cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);
            return Results.created();
        } else {
            return Results.badRequest();
        }
    }

    public Result obtenerReceta(Long id) {

        String key = "receta" + id;
        String keyResJson = "receta" + id + "resJson";
        Receta receta = cache.get(key);

        if (receta == null) {
            receta = Receta.findById(id);
            cache.set(key, receta);
        }

        if (receta == null) {
            return Results.notFound();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.receta.render(receta));
        } else if (request().accepts("application/json")) {
            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = receta.toJson();
                cache.set(keyResJson, resultado);
            }
            return Results
                    .ok(resultado);
        } else {
            return Results
                    .status(415);
        }
    }

    public Result obtenerRecetas(Integer page) {
        //Long start = System.currentTimeMillis();
        String key = "recetas" + page;
        String keyResJson = "recetas" + page + "resJson";
        List<Receta> listaRecetas = cache.get(key);
        if (listaRecetas == null) {
            PagedList<Receta> listaPaginadaRecetas = Receta.findAll(page);
            listaRecetas = listaPaginadaRecetas.getList();
            cache.set(key, listaRecetas);
        }
        //Long end = System.currentTimeMillis();
        //System.out.println("-----------> TIME = " + (end - start));

        if (listaRecetas == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listarecetas.render(listaRecetas));
        } else if (request().accepts("application/json")) {
            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = Json.toJson(listaRecetas);
                cache.set(keyResJson, resultado);
            }
            return Results
                    .ok(resultado);
        } else {
            return Results
                    .status(415);
        }
    }

    public Result obtenerRecetasCocinero(Long idCocinero, Integer page) {
        //Long start = System.currentTimeMillis();
        String key = "recetasAutor" + page + "cocinero" + idCocinero;
        String keyResJson = "recetasAutor" + page + "cocinero" + idCocinero + "resJson";
        List<Receta> listaRecetas = cache.get(key);
        if (listaRecetas == null) {
            PagedList<Receta> listaPaginadaRecetas = Receta.findByCodineroPaged(page, idCocinero);
            listaRecetas = listaPaginadaRecetas.getList();
            cache.set(key, listaRecetas);
        }
        //Long end = System.currentTimeMillis();
        //System.out.println("-----------> TIME = " + (end - start));

        if (listaRecetas == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listarecetas.render(listaRecetas));
        } else if (request().accepts("application/json")) {
            JsonNode resultado = cache.get(keyResJson);
            if (resultado == null) {
                resultado = Json.toJson(listaRecetas);
                cache.set(keyResJson, resultado);
            }
            return Results
                    .ok(resultado);
        } else {
            return Results
                    .status(415);
        }
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
        cachefunctions.vaciarCacheCompleta("receta" + id, "recetas", Receta.numRecetas(), cache);
        return Results.ok();
    }

    public Result borrarReceta(Long id) {
        Receta receta = Receta.findById(id);

        if (receta != null) {
            Ebean.beginTransaction();
            try {
                receta.delete();
                cachefunctions.vaciarCacheCompleta("receta" + id, "recetas", Receta.numRecetas(), cache);
                Ebean.commitTransaction();
            } finally {
                Ebean.endTransaction();
            }
        }


        // Idempotencia
        return Results.ok();
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
            cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);
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
        cachefunctions.vaciarCacheListas("recetas", Receta.numRecetas(), cache);

        // Idempotencia
        return Results.ok();
    }

    // Búsqueda completa por diferentes parámetros
    public Result busqueda() {

        String[] listaTags = new String[0];
        String[] listaCocineros = new String[0];
        String[] listaIngredientes = new String[0];
        String[] listaTitulos = new String[0];

        List<Receta> listaRecetas = new ArrayList<>();
        List<Receta> listaRecetasTags = new ArrayList<>();
        List<Receta> listaRecetasCocineros = new ArrayList<>();
        List<Receta> listaRecetasIngredientes = new ArrayList<>();
        List<Receta> listaRecetasTitulos = new ArrayList<>();

        final Set<Map.Entry<String, String[]>> entries = request().queryString().entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            if (Objects.equals(entry.getKey(), "tag")) {
                // Guardamos los tags en un array de cadenas
                listaTags = entry.getValue();
            } else if (Objects.equals(entry.getKey(), "cocinero")) {
                listaCocineros = entry.getValue();
            } else if (Objects.equals(entry.getKey(), "ingrediente")) {
                listaIngredientes = entry.getValue();
            } else if (Objects.equals(entry.getKey(), "titulo")) {
                listaTitulos = entry.getValue();
            }
        }

        listaRecetasTags = Receta.findByTags(listaTags);
        listaRecetasCocineros = Receta.findByCocineros(listaCocineros);
        listaRecetasIngredientes = Receta.findByIngredientes(listaIngredientes);
        listaRecetasTitulos = Receta.findByTitulos(listaTitulos);

        listaRecetas.addAll(listaRecetasTags);
        listaRecetas.addAll(listaRecetasCocineros);
        listaRecetas.addAll(listaRecetasIngredientes);
        listaRecetas.addAll(listaRecetasTitulos);

        // Docu: https://stackoverflow.com/questions/15907996/how-to-get-query-string-parameters-in-java-play-framework
        // Eliminamos duplicados
        List<Receta> listaRecetasFinal = new ArrayList<>();
        Iterator<Receta> iterator = listaRecetas.iterator();
        while (iterator.hasNext()) {
            Receta recetaTemp = iterator.next();
            if(!listaRecetasFinal.contains(recetaTemp)){
                listaRecetasFinal.add(recetaTemp);
            }
        }

        if (listaRecetas == null) {
            return Results.badRequest();
        }

        if (request().accepts("application/xml")) {
            return Results
                    .ok(views.xml.listarecetas.render(listaRecetasFinal));
        } else if (request().accepts("application/json")) {
            return Results
                    .ok(Json.toJson(listaRecetasFinal));
        } else {
            return Results
                    .status(415);
        }
    }
}
