package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;


public class PasoController extends Controller {

    public Result index() {
        return ok("PasoController Works!");
    }

    public Result crearPaso(){
        return Results.ok("Creamos un paso");
    }

    public Result obtenerPasos(){
        return Results.ok("Obtenemos los Pasos");
    }

    public Result obtenerPaso(){
        return Results.ok("Obtenemos un Paso concreto");
    }

    public Result editarPaso(){
        return Results.ok("editamos un Pasos");
    }

    public Result borrarPaso(){
        return Results.ok("Borramos un Pasos");
    }


}
