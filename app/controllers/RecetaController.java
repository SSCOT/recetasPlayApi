package controllers;

import models.Receta;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;


public class RecetaController extends Controller {

    public Result index() {
        return ok("RecetaController works!");
    }

    public Result crearReceta(){

        return Results.ok("Creamos un receta");
    }

    public Result obtenerRecetas(Long idCocinero){
        return Results.ok("Obtenemos las Recetas");
    }

    public Result obtenerReceta(Long id){
        return Results.ok("Obtenemos una Receta concreto");
    }

    public Result editarReceta(Long id){
        return Results.ok("editamos un Recetas");
    }

    public Result borrarReceta(Long id){
        return Results.ok("Borramos un Recetas");
    }

}
