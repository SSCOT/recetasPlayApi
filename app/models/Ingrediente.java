package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Ingrediente extends Model {
    @Id
    public Long id;

    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Receta> recetas;

    public static final Finder<Long, Ingrediente> find = new Finder<>(Ingrediente.class);

    public Long getId() {
        return id;
    }

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

    public boolean checkAndSave() {


        // Comprobamos que tiene nombre apellidos y tipo
        if (this.nombre.isEmpty()) {
            return false;
        }

        // Comprobamos que no existe ningún otro ingrediente con el mismo nombre


        this.save();
        return true;
    }
}
