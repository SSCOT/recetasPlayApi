package utils;

import models.Cocinero;
import play.cache.SyncCacheApi;
import javax.inject.Inject;

public class Cachefunctions {

    private static Integer REGISTROS_PAGINA = 25;

    /*@Inject
    private static SyncCacheApi cache;*/

    public static void vaciarCacheListas(String key, Integer numRegistros,  SyncCacheApi cache) {
        // Vaciamos caché de las listas (y su resultado json)
        int numPaginas, resto;
        numPaginas = numRegistros / REGISTROS_PAGINA;
        resto = numRegistros % REGISTROS_PAGINA;
        if (resto > 0)
            numPaginas++;

        for (int page = 0; page < numPaginas; page++) {
            cache.remove(key + page);
            cache.remove(key + page + "resJson");
        }
    }

    public static void vaciarCacheUnica(String key,  SyncCacheApi cache) {
        // Vaciamos caché del elemento (y su resultado json)
        cache.remove(key);
        cache.remove(key + "resJson");
    }

    public static void vaciarCacheCompleta(String keyUnica, String keyListas, Integer numRegistros, SyncCacheApi cache) {
        vaciarCacheUnica(keyUnica, cache);
        vaciarCacheListas(keyListas, numRegistros, cache);
    }
}
