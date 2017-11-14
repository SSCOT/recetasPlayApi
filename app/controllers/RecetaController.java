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

    public Result obtenerRecetas(){
        return Results.ok("Obtenemos las Recetas");
    }

    public Result obtenerReceta(){
        return Results.ok("Obtenemos una Receta concreto");
    }

    public Result editarReceta(){
        return Results.ok("editamos un Recetas");
    }

    public Result borrarReceta(){
        return Results.ok("Borramos un Recetas");
    }

}
