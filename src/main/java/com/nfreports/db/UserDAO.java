package com.nfreports.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;
import com.nfreports.db.models.User;

/**
 * UserDAO
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class UserDAO extends AbstractDAO<User> {

    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    public User getById(Long id) {
        return get(id);
    }

    public Integer createUser(User user) {
        return persist(user).getId();
    }

    public List<User> getAll() {
        return list(namedQuery("com.nfreports.db.getAll"));
    }

}
