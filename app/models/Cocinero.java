package models;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Finder;
import io.ebean.Model;
import play.libs.Json;
import scala.util.parsing.json.JSONObject;
import scala.util.parsing.json.JSONObject$;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cocinero extends Model {


    //========================================
    //    VARIABLES
    //========================================

    @Id
    @GeneratedValue
    public Long id;

    private String nombre;
    private String apellido;
    private String tipo;
    private String restaurante;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "r_cocinero")
    public List<Receta> recetas;

    public static final Finder<Long, Cocinero> find = new Finder<>(Cocinero.class);
    public static final Finder<Long, Receta> findReceta = new Finder<>(Receta.class);


    public Cocinero() {
        super();
    }

    public Cocinero(String restaurante, String nombre, String apellido, String tipo) {
        this.restaurante = restaurante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
    }

    //========================================
    //    GETTERS Y SETTERS
    //========================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
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

    public static Cocinero findById(Long id) {
        return find.byId(id);
    }

    public static Cocinero findByNombre(String nombre, String apellido) {
        return find
                .query()
                .where()
                .eq("nombre", nombre)
                .eq("apellido", apellido)
                .findOne();
    }

    public static List<Cocinero> findAll() {
        // Falta el paginado
        return find.all();
    }

    public List<Receta> findRecetas() {
        return findReceta
                .query()
                .where()
                .eq("r_cocinero", this.id)
                .findList();
    }

    public boolean checkAndSave() {


        // Comprobamos que tiene nombre apellidos y tipo
        if (this.nombre.isEmpty() || this.apellido.isEmpty()) {
            return false;
        }

        if (this.tipo.isEmpty() || (!this.tipo.equals("cocinero") && !this.tipo.equals("estudiante"))) {
            return false;
        }

        this.save();
        return true;
    }

    public void checkAndDelete() {
        // Si el usuario existe lo eliminamos. Por la idempotencia devolvemos siempre ok.
        if (findById(this.getId()) != null) {
            this.delete();
        }
    }


    //========================================
    //    MÉTODOS DE MUESTREO
    //========================================

    public JsonNode toJson() {
        return Json.toJson(this);
    }

    @Override
    public String toString() {
        return "Cocinero{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }


}
