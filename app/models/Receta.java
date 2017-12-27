package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.Finder;
import io.ebean.Model;
import play.libs.Json;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receta extends ModeloBase {

    private String titulo;
    private String tipo;

    @ManyToOne
    @JsonBackReference
    public Cocinero r_cocinero;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "p_receta")
    @JsonManagedReference
    public List<Paso> pasos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "recetas")
    @JsonManagedReference
    public List<Ingrediente> ingredientes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t_receta")
    @JsonManagedReference
    public List<Tag> tags = new ArrayList<>();

    public static final Finder<Long, Receta> find = new Finder<>(Receta.class);
    public static final Finder<Long, Cocinero> findCocinero = new Finder<>(Cocinero.class);

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cocinero getR_cocinero() {
        return r_cocinero;
    }

    public void setR_cocinero(Cocinero r_cocinero) {
        this.r_cocinero = r_cocinero;
    }

    public List<Paso> getPasos() {
        return pasos;
    }

    public void setPasos(List<Paso> pasos) {
        this.pasos = pasos;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }


    //========================================
    //    MÉTODOS DE BASE DE DATOS
    //========================================

    public static Receta findById(long id) {
        return find.byId(id);
    }

    public static Receta findByTitulo(String titulo) {
        return find.query().where().eq("titulo", titulo).findOne();
    }

    public static List<Receta> findAll() {
        // Falta el paginado
        return find.all();
    }

    public boolean checkAndCreate() {
        // Comprobación de título y cocinero
        if (this.titulo.isEmpty() || this.r_cocinero == null) {
            return false;
        }

        // Comprobamos que el cocinero no existe con el nombre y los apellidos
        Cocinero autor = Cocinero.findById(this.r_cocinero.id);


        // Si existe esa receta hecha por el mismo cocinero
        Receta nuevaReceta = Receta.findByTitulo(this.titulo);
        if (nuevaReceta != null) {
            if (Cocinero.findById(nuevaReceta.r_cocinero.getId()) != null) {
                return false;
            }
        }

        // El cocinero es obligatorio para que se pueda crear la receta y además debe existir
        if (this.r_cocinero.getId() == null) {
            return false;
        }

        // El tipo ha de ser "privada" o "publica". Por defecto asignamos que es pública
        if ((this.tipo != "publica" && this.tipo != "privada") || this.tipo == null) {
            this.tipo = "publica";
        }

        Ebean.beginTransaction();
        try {
            this.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

        // long idCocinero = this.r_cocinero.getId();


        return true;
    }

    public static boolean asignarIngrediente(Receta receta, Ingrediente ingrediente) {
        // Comprobamos que no exista ya la relación
        if (receta.ingredientes.contains(ingrediente) || ingrediente.recetas.contains(receta)) {
            return false;
        }

        Ebean.beginTransaction();
        try {
            receta.ingredientes.add(ingrediente);
            ingrediente.recetas.add(receta);
            receta.save();
            ingrediente.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

        return true;
    }

    public static boolean quitarIngrediente(Receta receta, Ingrediente ingrediente) {
        // Comprobamos que la relación existe
        if (receta.ingredientes.contains(ingrediente) && ingrediente.recetas.contains(receta)) {
            Ebean.beginTransaction();
            try {
                receta.ingredientes.remove(ingrediente);
                ingrediente.recetas.remove(receta);
                receta.save();
                ingrediente.save();
                Ebean.commitTransaction();
            } finally {
                Ebean.endTransaction();
            }
            return true;
        } else {
            return false;
        }
    }

    public JsonNode toJson() {
        return Json.toJson(this);
    }

}
