package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.*;
import play.libs.Json;

import javax.persistence.*;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.Iterator;
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
    @OrderBy("indice")
    public List<Paso> pasos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "recetas")
    @JsonManagedReference
    public List<Ingrediente> ingredientes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t_receta")
    @JsonManagedReference
    public List<Tag> tags = new ArrayList<>();

    public static final Finder<Long, Receta> find = new Finder<>(Receta.class);
    public static final Finder<Long, Cocinero> findCocinero = new Finder<>(Cocinero.class);
    public static final Finder<Long, Tag> findTag = new Finder<>(Tag.class);
    public static final Finder<Long, Ingrediente> findIngrediente = new Finder<>(Ingrediente.class);

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

    public static List<Receta> findByTituloAprox(String titulo) {
        System.out.println("SEC ** TITAPROX");
        return find.query().where().like("titulo", "%" + titulo + "%").findList();
    }

    public static Receta findByTituloAndAutor(String titulo, Cocinero cocinero) {
        return find.query().where().eq("titulo", titulo).eq("r_cocinero", cocinero).findOne();
    }

    public static PagedList<Receta> findAll(Integer page) {
        return find.query()
                .setMaxRows(25)
                .setFirstRow(25 * page)
                .findPagedList();
    }

    public static PagedList<Receta> findByCodineroPaged(Integer page, Long idAutor) {

        if (idAutor == null)
            return null;

        return find.query()
                .setMaxRows(25)
                .setFirstRow(25 * page)
                .where()
                .eq("r_cocinero.id", idAutor)
                .findPagedList();
    }

    public static List<Receta> findByCocinero(Long idCocinero) {
        if (idCocinero == null)
            return null;

        return find.query()
                .where()
                .eq("r_cocinero.id", idCocinero)
                .findList();
    }

    // BUSQUEDA
    public static List<Receta> findByCocineros(String[] idsCocineros) {
        List<Receta> listaRecetas = new ArrayList<Receta>();
        for (int i = 0; i < idsCocineros.length; i++) {
            listaRecetas.addAll(Receta.findByCocinero(new Long(idsCocineros[i])));
        }

        return listaRecetas;
    }

    public static List<Receta> findByTags(String[] tags) {
        List<Receta> listaRecetas = new ArrayList<Receta>();

        for (int i = 0; i < tags.length; i++) {
            // Sacamos la lista de tags que tienen ese mismo texto
            List<Tag> listaTags = findTag.query().where().eq("texto", tags[i]).findList();

            // Iteramos cada uno de los tags para sacar la receta a la que pertenece
            Iterator<Tag> iterator = listaTags.iterator();
            while (iterator.hasNext()) {
                Tag tagTemp = iterator.next();
                listaRecetas.add(tagTemp.t_receta);
            }
        }

        return listaRecetas;
    }

    public static List<Receta> findByIngredientes(String[] ingredientes) {
        List<Receta> listaRecetas = new ArrayList<Receta>();

        for (int i = 0; i < ingredientes.length; i++) {
            // Sacamos la lista de tags que tienen ese mismo texto
            List<Ingrediente> listaIngredientes = findIngrediente.query().where().eq("nombre", ingredientes[i]).findList();

            // Iteramos cada uno de los tags para sacar la receta a la que pertenece
            Iterator<Ingrediente> iterator = listaIngredientes.iterator();
            while (iterator.hasNext()) {
                Ingrediente ingredienteTemp = iterator.next();
                listaRecetas.addAll(ingredienteTemp.recetas);
            }
        }

        return listaRecetas;
    }

    // Búsqueda aproximada por titulo
    public static List<Receta> findByTitulos(String[] titulos) {
        List<Receta> listaRecetas = new ArrayList<Receta>();
        for (int i = 0; i < titulos.length; i++) {
            System.out.println("entra en titulos aprox");
            listaRecetas.addAll(Receta.findByTituloAprox(titulos[i]));
        }

        return listaRecetas;
    }


    public static Integer numRecetas() {
        return find.query().findCount();
    }

    public boolean checkAndCreate() {
        // Comprobación de título y cocinero
        if (this.titulo.isEmpty() || this.r_cocinero == null) {
            return false;
        }

        // El id de cocinero es obligatorio para que se pueda crear la receta y además debe existir
        if (this.r_cocinero.getId() == null) {
            return false;
        }

        // Comprobamos que el cocinero existe
        Cocinero autor = Cocinero.findById(this.r_cocinero.id);
        if (autor == null) {
            return false;
        }

        // Comprobamos si existe una receta con ese cocinero
        Receta recetaExistente = Receta.findByTituloAndAutor(this.titulo, autor);
        if (recetaExistente != null) {
            return false;
        }

        // El tipo ha de ser "privada" o "publica". Por defecto asignamos que es pública
        if ((this.tipo != "publica" && this.tipo != "privada") || this.tipo == null) {
            this.tipo = "publica";
        }

        this.tipo = "publica";

        Ebean.beginTransaction();
        try {
            // No guardamos en bruto lo que nos llega para controlar un poco lo que se mete en la base de datos
            // Los ingredientes, tags y pasos se asignas con llamadas a la api independientes

            Receta recetaFinal = new Receta();
            recetaFinal.titulo = this.titulo;
            recetaFinal.tipo = this.tipo;
            recetaFinal.r_cocinero = this.r_cocinero;

            recetaFinal.save();
            // this.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }

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
