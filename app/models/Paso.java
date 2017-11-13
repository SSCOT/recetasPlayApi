package models;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Paso extends Model {
    @Id
    public Long id;

    private String tiempo;
    private String descripcion;

    @ManyToOne
    public Receta p_receta;

    public Long getId() {
        return id;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Receta getP_receta() {
        return p_receta;
    }

    public void setP_receta(Receta p_receta) {
        this.p_receta = p_receta;
    }
}
