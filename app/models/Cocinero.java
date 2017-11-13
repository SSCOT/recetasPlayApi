package models;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class Cocinero extends Usuario {
    private String restaurante;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "r_cocinero")
    public List<Receta> recetas;

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
}
