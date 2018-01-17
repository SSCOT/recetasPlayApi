package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.PagedList;
import org.apache.commons.lang3.RandomStringUtils;
import play.libs.Json;
import scala.util.parsing.json.JSONObject;
import scala.util.parsing.json.JSONObject$;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cocinero extends ModeloBase {


    //========================================
    //    VARIABLES
    //========================================

    @NotNull
    private String nombre;
    private String apellido;
    private String tipo;
    private String restaurante;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    public Apikey key;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "r_cocinero")
    public List<Receta> recetas = new ArrayList<>();

    public static final Finder<Long, Cocinero> find = new Finder<>(Cocinero.class);

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

    public Apikey getKey() {
        return key;
    }

    public void setKey(Apikey key) {
        this.key = key;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    //========================================
    //    MÉTODOS DE BÚSQUEDA
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

    public static PagedList<Cocinero> findAll(Integer page) {
        return find.query()
                .setMaxRows(25)
                .setFirstRow(25 * page)
                .findPagedList();
    }

    public static Cocinero findByKey (String key){
        Cocinero cocinero = find.query().where().eq("key.key", key).findOne();
        return cocinero;
    }

    //========================================
    //    MÉTODOS DE CHEQUEO
    //========================================

    public boolean checkAndCreate() {
        // Comprobamos que tiene nombre apellidos y tipo
        if (this.nombre.isEmpty() || this.apellido.isEmpty()) {
            return false;
        }

        if (this.tipo.isEmpty() || (!this.tipo.equals("cocinero") && !this.tipo.equals("estudiante"))) {
            return false;
        }


        // Generamos un token único
        // http://oliviertech.com/java/generate-SHA1-hash-from-a-String/
        Long keyBase = new Long((int) (Math.random() * 1000000) + 1);
        String keyFinal = this.nombre + keyBase + this.apellido;
        String keySha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(keyFinal);


        // Creamos la ApiKey asociada
        Apikey apiKeyAsociada = new Apikey();
        apiKeyAsociada.setKey(keySha1);

        this.setKey(apiKeyAsociada);

        // Una vez hechas las comprobaciones creamos el cocinero
        Ebean.beginTransaction();
        try {
            apiKeyAsociada.save();
            this.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

        return true;
    }

    //========================================
    //    OTROS
    //========================================

    public static Integer numCocineros() {
        return find.query().findCount();
    }

    public JsonNode toJson() {
        return Json.toJson(this);
    }
}
