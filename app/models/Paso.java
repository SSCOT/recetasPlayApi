package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.Finder;
import play.libs.Json;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Paso extends ModeloBase {

    private Long tiempo;
    private String descripcion;
    private int indice;

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

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
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

    public static List<Paso> findByReceta(Long idReceta){

        return find
                .query()
                .where()
                .eq("p_receta.id", idReceta)
                .findList();
    }

    public boolean checkAndCreate() {
        // Comprobamos que exista una descripción, dado que es el único aspecto obligatorio
        if (this.descripcion.isEmpty()) {
            return false;
        }

        // Una vez hechas las comprobaciones creamos el paso
        Ebean.beginTransaction();
        try {
            this.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

        return true;
    }

    //========================================
    //    MÉTODOS DE MUESTREO
    //========================================

    public JsonNode toJson() {
        return Json.toJson(this);
    }
}
