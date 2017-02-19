package com.nfreports.model;

import javafx.beans.property.*;

import java.time.LocalDateTime;

/**
 * User model
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class User {

    private final IntegerProperty id;
    private final StringProperty email;
    private final StringProperty name;
    private final StringProperty password;
    private final IntegerProperty role;
    private final ObjectProperty<LocalDateTime> creation;

    /**
     * Default constructor
     */
    public User() {
        this(null, null, null, null, null);
    }

    /**
     * Constructor with some initial data
     */
    public User(Integer id, String name, String email, String password, Integer role) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleIntegerProperty(role);
        LocalDateTime now = LocalDateTime.now();
        this.creation = new SimpleObjectProperty<>(LocalDateTime.of(2017, 2, 18, 00, 00, 00));
    }

    public Integer getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public int getRole() {
        return role.get();
    }

    public IntegerProperty roleProperty() {
        return role;
    }

    public void setRole(int role) {
        this.role.set(role);
    }

    public LocalDateTime getCreation() {
        return creation.get();
    }

    public ObjectProperty<LocalDateTime> creationProperty() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation.set(creation);
    }
}
