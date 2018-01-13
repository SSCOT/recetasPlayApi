package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Apikey extends ModeloBase {

    String key;

    @OneToOne(mappedBy = "key")
    public Cocinero cocinero;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }
}
