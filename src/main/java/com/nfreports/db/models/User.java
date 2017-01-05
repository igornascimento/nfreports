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
                query = "select u from User u")
})
public class User implements Serializable {

    @Id
    @JsonProperty("id_user")
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("email")
    @Column(name = "email", nullable = false)
    private String email;

    @JsonProperty("password")
    @Column(name = "password", nullable = false)
    private String password;

    @JsonProperty("role")
    @Column(name = "role", nullable = false)
    private Integer role;

    @JsonProperty("creation_time")
    @Column(name = "creation_time", nullable = false)
    private DateTime creationTime;


    @JsonProperty("id_user")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id_user")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("role")
    public Integer getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(Integer role) {
        this.role = role;
    }

    @JsonProperty("creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    @JsonProperty("creation_time")
    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }
}
