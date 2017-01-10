package com.nfreports.db.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User entity
 *
 * @author Igor Nascimento {@literal <igornascimento@gmail.com>}
 * @version 1.0
 */
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "com.nfreports.db.getAll",
                    query = "select u from User u"),

        @NamedQuery(name = "com.nfreports.db.findByUsernameAndPassword",
                    query = "select u from User u where u.email = :email and u.password = :password")
})
public class User implements Serializable {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "rule", nullable = false)
    private Integer rule;

    @Column(name = "creation_time", nullable = false)
    private DateTime creationTime;


    @JsonProperty
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty
    public Integer getRule() {
        return rule;
    }

    public void setRule(Integer rule) {
        this.rule = rule;
    }

    @JsonProperty
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }
}
