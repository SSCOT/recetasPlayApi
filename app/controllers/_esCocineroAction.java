package controllers;

import models.Cocinero;
import play.mvc.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Controller.request;

public class _esCocineroAction extends Action<_esCocinero> {

    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        // Solución bug primer cocinero
        if(Cocinero.numCocineros() == 0)
            return this.delegate.call(ctx);

        // Recogemos la key
        String key = request().getQueryString("apikey");
        if(key.equals(null)){
            return CompletableFuture.completedFuture(Results.unauthorized());
        }
        // Sacamos el tipo de cocinero que tiene esa key
        Cocinero cocinero = Cocinero.findByKey(key);
        String cocineroTipo = cocinero.getTipo();

        CompletionStage<Result> result;

        if (!cocineroTipo.equals("cocinero"))
            return CompletableFuture.completedFuture(Results.unauthorized());

        return this.delegate.call(ctx);
    }
}
