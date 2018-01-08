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

    public static Tag findByTexto(String texto, Long idReceta) {
        return find
                .query()
                .where()
                .eq("texto", texto)
                .eq("t_receta.id", idReceta)
                .findOne();
    }

    /*public static List<Tag> busquedaTags(String textoParcial){
        return find
                .query()
                .where()
                .like("nombre", "%" + textoParcial + "%")
                .findList();
    }*/

    public static Integer numTags(){
        return find.query().findCount();
    }

    public boolean checkAndCreate() {
        if (this.texto.isEmpty()) {
            return false;
        }

        if (this.t_receta == null){
            return false;
        } else if (Receta.findById(this.t_receta.id) == null){
            return false;
        }

        Tag tagEncontrado = Tag.findByTexto(this.texto, this.t_receta.id);
        if(tagEncontrado != null){
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

    /*public boolean checkAndUpdate() {
        System.out.println("_____________LLEGA => "+this.texto+" "+this.t_receta.id);

        if (this.texto.isEmpty()) {
            return false;
        }

        // Su nuevo nombre no existe
        if(Tag.findByTexto(this.texto, this.t_receta.getId()) != null){
            return false;
        }
        *//*if(Tag.findByTexto(this.texto, this.t_receta.id) != null){
            return false;
        }*//*

        System.out.println("_____________LLEGA");

        Ebean.beginTransaction();
        try {
            // No permitimos que se modifique la receta asociada
            Tag tagUpdate = new Tag();
            tagUpdate.setId(this.id);
            tagUpdate.setTexto(this.texto);
            tagUpdate.update();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
        return true;
    }*/

    //========================================
    //    MÉTODOS DE MUESTREO
    //========================================

    public JsonNode toJson() {
        return Json.toJson(this);
    }
}
