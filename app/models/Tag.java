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
public class Tag extends ModeloBase {

    private String texto;

    @ManyToOne
    @JsonBackReference
    public Receta t_receta;

    public static final Finder<Long, Tag> find = new Finder<>(Tag.class);

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Receta getT_receta() {
        return t_receta;
    }

    public void setT_receta(Receta t_receta) {
        this.t_receta = t_receta;
    }


    //========================================
    //    MÉTODOS DE BASE DE DATOS
    //========================================

    public static Tag findById(Long id) {
        return find.byId(id);
    }

    public static List<Tag> findByReceta(Long idReceta) {
        return find
                .query()
                .where()
                .eq("t_receta.id", idReceta)
                .findList();
    }

    public static List<Tag> busquedaTags(String textoParcial){
        return find
                .query()
                .where()
                .like("nombre", "%" + textoParcial + "%")
                .findList();
    }

    public boolean checkAndCreate() {
        if (this.texto.isEmpty()) {
            return false;
        }

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
