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

    public static boolean tengoPermisoCocinero(Long idCocinero, String key) {
        System.out.println("id cocinero: " + idCocinero + " key:" + key);

        Cocinero yo = Cocinero.findByKey(key);

        // Si es el mismo id es que intenta hacer acciones sobre su propio usuario
        if (idCocinero.equals(yo.getId()))
            return true;

        // Sacamos el tipo de ambos cocineros
        Cocinero cocinero = Cocinero.findById(idCocinero);
        // Si soy Cocinero y pretendo modificar a un estudiante, y solo en ese caso, se permite
        if (cocinero.getTipo().equals("estudiante") && yo.getTipo().equals("cocinero"))
            return true;

        return false;
    }
}
