package controllers;

import models.Cocinero;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Controller.request;

public class _esKeyValidaAction extends Action<_esCocinero> {
    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        // Código para crear el primer cocinero
        if (Cocinero.numCocineros() == 0)
            return this.delegate.call(ctx);

        // Comprobamos que nos llega key
        if(!request().queryString().containsKey("apikey"))
            return CompletableFuture.completedFuture(Results.unauthorized());

        // Comprobamos que es válida
        String key = request().getQueryString("apikey");
        if (key.equals(null))
            return CompletableFuture.completedFuture(Results.unauthorized());

        // Sacamos el tipo de cocinero que tiene esa key
        Cocinero cocinero = Cocinero.findByKey(key);

        if (cocinero == null)
            return CompletableFuture.completedFuture(Results.unauthorized());

        CompletionStage<Result> result = null;

        return this.delegate.call(ctx);
    }
}
