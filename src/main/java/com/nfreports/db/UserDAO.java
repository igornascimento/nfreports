package com.nfreports.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.validator.constraints.NotEmpty;
import static com.google.common.collect.Iterables.getFirst;

import java.util.List;
import java.util.Optional;

import com.nfreports.db.models.User;

/**
 * UserDAO
 *
 * @author Igor Nascimento {@literal <igornascimento@gmail.com>}
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

    public Optional<User> findByEmailAndPassword(@NotEmpty String email, @NotEmpty String password) {
        Query query = namedQuery("com.nfreports.db.findByUsernameAndPassword")
                .setParameter("email", email)
                .setParameter("password", password);

        return Optional.ofNullable(getFirst(list(query), null));
    }

}
