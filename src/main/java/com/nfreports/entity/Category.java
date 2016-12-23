package com.nfreports.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="category")
@NamedQueries({
        @NamedQuery(name="com.nfreports.db.getAll",
                    query="select c from Category c")
})
public class Category implements Serializable {
    
}
