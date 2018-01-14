package controllers;

import models.Cocinero;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

import static play.mvc.Controller.request;

public class esKeyValidaAction extends Action<esCocinero> {

    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        // Código para crear el primer cocinero
        /*if(Cocinero.numCocineros() == 0)
            return this.delegate.call(ctx);*/

        // Recogemos la key
        String key = request().getQueryString("apikey");
        if (key.equals(null)) {
            return null;
        }
        // Sacamos el tipo de cocinero que tiene esa key
        Cocinero cocinero = Cocinero.findByKey(key);

        if (cocinero == null)
            return null;

        return this.delegate.call(ctx);

    }
}
