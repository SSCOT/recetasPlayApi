package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Finder;
import io.ebean.Model;
import play.libs.Json;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Ingrediente extends ModeloBase {

    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    public List<Receta> recetas;

    public static final Finder<Long, Ingrediente> find = new Finder<>(Ingrediente.class);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }


    //========================================
    //    MÉTODOS DE BASE DE DATOS
    //========================================

    public static Ingrediente findById(Long id) {
        return find.byId(id);
    }

    public static Ingrediente findByNombre(String nombre) {
        return find
                .query()
                .where()
                .eq("nombre", nombre)
                .findOne();
    }

    public static List<Ingrediente> busquedaIngrediente(String nombreParcial) {
        return find
                .query()
                .where()
                .like("nombre", "%" + nombreParcial + "%")
                .findList();
    }

    public static List<Ingrediente> findAll() {
        // Falta el paginado
        return find.all();
    }

    public boolean checkAndSave() {

        // Comprobamos que tiene nombre
        if (this.nombre.isEmpty()) {
            return false;
        }

        this.save();
        return true;
    }

    //========================================
    //    MÉTODOS DE MUESTREO
    //========================================

    public JsonNode toJson() {
        return Json.toJson(this);
    }

}
