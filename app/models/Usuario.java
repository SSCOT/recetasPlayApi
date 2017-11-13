package models;

import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.Timestamp;


@Entity
public class Usuario  extends Model {
    @Id
    public Long id;

    public Long getId() {
        return id;
    }

}
