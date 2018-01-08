package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.UpdatedTimestamp;
import sun.util.resources.cldr.gv.LocaleNames_gv;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

@MappedSuperclass
public class ModeloBase extends Model {
    @Id
    @GeneratedValue

    public Long id;

    @Version
    Long version;

    @CreatedTimestamp
    Timestamp fechaCreacion;

    @UpdatedTimestamp
    Timestamp fechaModificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }
}
