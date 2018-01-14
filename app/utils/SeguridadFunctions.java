package utils;

import models.Cocinero;
import models.Receta;

public class SeguridadFunctions {
    public static boolean esAutorReceta(Long idReceta, String key) {
        Cocinero cocinero = Cocinero.findByKey(key);
        Receta receta = Receta.findById(idReceta);
        //boolean resultado = (cocinero == receta.r_cocinero) ? true : false;
        if (cocinero.id.equals(receta.r_cocinero.getId())) {
            return true;
        } else {
            return false;
        }
    }
}
