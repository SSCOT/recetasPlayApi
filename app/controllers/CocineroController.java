package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;


public class CocineroController extends Controller {

    public Result index() {
        return ok("CocineroController");
    }

    public Result crearCocinero(){
        return Results.ok("Creamos un cocinero");
    }

    public Result obtenerCocineros(){
        return Results.ok("Obtenemos los cocineros");
    }

    public Result obtenerCocinero(){
        return Results.ok("Obtenemos un cocinero concreto");
    }

    public Result editarCocinero(){
        return Results.ok("editamos un cocineros");
    }

    public Result borrarCocinero(){
        return Results.ok("Borramos un cocineros");
    }


}
