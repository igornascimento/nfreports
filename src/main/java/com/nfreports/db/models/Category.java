package com.nfreports.db.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Category entity
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
@Entity
@Table(name = "category")
@NamedQueries({
        @NamedQuery(name = "com.nfreports.db.getAll",
                query = "select c from Category c")
})
public class Category implements Serializable {

    @Id
    @JsonProperty("id_category")
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("name")
    @Column(name = "name", nullable = false)
    private String name;


    @JsonProperty("id_category")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id_category")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}
