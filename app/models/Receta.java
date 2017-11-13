package models;

import io.ebean.Model;

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

}
