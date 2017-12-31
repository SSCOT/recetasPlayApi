package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.Finder;
import play.libs.Json;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Paso extends ModeloBase {

    private Long tiempo;
    private String descripcion;
    private Long indice;

    @ManyToOne
    @JsonBackReference
    public Receta p_receta;

    public static final Finder<Long, Paso> find = new Finder<>(Paso.class);

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIndice() {
        return indice;
    }

    public void setIndice(Long indice) {
        this.indice = indice;
    }

    public Receta getP_receta() {
        return p_receta;
    }

    public void setP_receta(Receta p_receta) {
        this.p_receta = p_receta;
    }


    //========================================
    //    MÉTODOS DE BASE DE DATOS
    //========================================

    public static Paso findById(Long id) {
        return find.byId(id);
    }

    public static List<Paso> findByReceta(Long idReceta) {

        return find
                .query()
                .where()
                .eq("p_receta.id", idReceta)
                .findList();
    }

    public static Paso findByIndice(Long indice, Receta receta) {
        return find
                .query()
                .where()
                .eq("indice", indice)
                .eq("p_receta", receta)
                .findOne();
    }

    public boolean checkAndCreate() {
        // Comprobamos que exista una descripción, dado que es el único aspecto obligatorio
        if (this.descripcion.isEmpty()) {
            return false;
        }

        // Comprobamos que hay una receta asociada y esta existe
        if (this.p_receta.id == null) {
            return false;
        }

        Receta recetaAsociada = Receta.findById(this.p_receta.id);
        if (recetaAsociada == null) {
            return false;
        }

        // Sacamos la lista de pasos de la receta determinada
        List<Paso> listaPasos = find.query().where().eq("p_receta.id", this.p_receta.id).orderBy("indice").findList();

        boolean recolocacion = false;
        // Si se indica un indice
        if (this.indice != null) {
            // Existe un paso con el mismo indice. Hay que recolocar los pasos (reasignación de indices)
            if (Paso.findByIndice(this.indice, this.p_receta) != null) {
                // Hay que recolocar, pero lo realizamos en el TRY por seguridad
                recolocacion = true;
            } else {
                // El índice no está asignado a nadie, pero debemos vigilar que sea exactamente el indice siguiente
                if (indice != listaPasos.size() + 1) {
                    return false;
                }
            }
        } else {
            // Asignamos el indice siguiente en nuestra lista de pasos
            this.indice = new Long(listaPasos.size() + 1);
        }

        // Una vez hechas las comprobaciones creamos el paso
        Ebean.beginTransaction();
        try {

            if (recolocacion) {

                Long indiceTemp = this.indice;

                Iterator<Paso> iterator = listaPasos.iterator();
                while (iterator.hasNext()) {
                    Paso pasoTemp = iterator.next();
                    if (pasoTemp.indice == indiceTemp) {
                        Paso pasoUpdate = Paso.findById(pasoTemp.id);
                        indiceTemp++;
                        pasoUpdate.setIndice(indiceTemp);
                        pasoUpdate.save();
                    }
                }
            }

            this.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

        return true;
    }

    public void checkAndDelete() {

        // Reordenamos los indices de los pasos
        List<Paso> listaPasos = find.query().where().eq("p_receta.id", this.p_receta.id).orderBy("indice").findList();

        Long indiceTemp = this.indice + 1;

        Ebean.beginTransaction();
        try {
            Iterator<Paso> iterator = listaPasos.iterator();
            while (iterator.hasNext()) {
                Paso pasoTemp = iterator.next();
                if (pasoTemp.indice == indiceTemp) {
                    Paso pasoUpdate = Paso.findById(pasoTemp.id);
                    pasoUpdate.setIndice(indiceTemp - 1);
                    indiceTemp++;
                    pasoUpdate.save();
                }
            }
            this.delete();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

    }

    //========================================
    //    MÉTODOS DE MUESTREO
    //========================================

    public JsonNode toJson() {
        return Json.toJson(this);
    }
}
