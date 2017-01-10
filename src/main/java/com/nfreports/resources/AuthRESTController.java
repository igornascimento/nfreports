package com.nfreports.resources;

import com.nfreports.db.Session;
import com.nfreports.db.UserDAO;
import com.nfreports.db.models.Session;
import com.nfreports.db.SessionDAO;

import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Main class
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class AuthRESTController {

    private final Validator validator;

    public AuthRESTController(Validator validator) {
        this.validator = validator;
    }

    @POST
    public Response doLogin(
            @FormParam("email") String email,
            @FormParam("password") String password) throws Exception {

        UserDAO userdao = new UserDAO(sessionFactory);
        if (userdao.findByEmailAndPassword(email, password).isEmpty()){
            throw new Exception("Login incorrect.");
        }

        Session session = new Session(username);
        sessionDAO.insert(session.getAccessToken(), session.getIdentity(), new java.util.Date());

        return session;
    }

}
