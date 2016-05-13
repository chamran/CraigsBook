package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import entity.*;
import persistence.*;
import org.apache.log4j.Logger;


/**
 * The type Sign up user.
 */
@WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )


public class SignUpUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("name"), req.getParameter("password"));
        log.debug("Adding User: " + user);
        UserDao dao = new UserDao();
        dao.addUser(user);
    }
}