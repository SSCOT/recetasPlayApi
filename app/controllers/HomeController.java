package controllers;

import play.mvc.*;

import views.html.*;


public class HomeController extends Controller {

    public Result index() {
        return ok("App práctica PLAY works!");
    }

}
