package models;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Finder;
import io.ebean.Model;
import play.libs.Json;

import javax.persistence.*;
import java.util.List;

@Entity
public class Receta extends Model {

    @Id
    public Long id;

    private String titulo;

    @ManyToOne
    public Cocinero r_cocinero;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "p_receta")
    public List<Paso> pasos;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "recetas")
    public List<Ingrediente> ingredientes;

    public static final Finder<Long, Receta> find = new Finder<>(Receta.class);
    public static final Finder<Long, Cocinero> findCocinero = new Finder<>(Cocinero.class);

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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


    public boolean checkAndSave() {

        // No nos ha llegado título
        if (this.titulo.isEmpty()) {
            return false;
        }

        // Existe la receta
        if (Receta.findByTitulo(this.titulo) != null) {
            return false;
        }

        // El cocinero es obligatorio para que se pueda crear la receta
        if (this.r_cocinero == null) {
            return false;
        }

        long idCocinero = this.r_cocinero.getId();

        // Si el cocinero no exite se crea
        if (Cocinero.findById(idCocinero) == null) {
            if (!this.r_cocinero.checkAndSave())
                return false;
        }

        // Asociamos la receta al cocinero
        this.r_cocinero.recetas.add(this);


        this.save();
        return true;
    }


    public JsonNode toJson() {
        return Json.toJson(this);
    }

}
