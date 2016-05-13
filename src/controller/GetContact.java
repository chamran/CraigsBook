package controller;

import entity.Contact;
import entity.Listing;
import org.apache.log4j.Logger;
import persistence.ContactDao;
import persistence.ListingDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 4/26/2016.
 */

@WebServlet(name = "GetContact", urlPatterns = { "/getContact" }
)
public class GetContact extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getUserPrincipal().getName();
        List<Contact> myContacts = new ArrayList<>();
        log.info("Sending myContacts.....");

        ContactDao dao = new ContactDao();

        myContacts = dao.getMyContacts(userName);

        String url = "/messaging.jsp";

        HttpSession session = request.getSession();

        session.setAttribute("myContacts", myContacts);
        log.info("Sending myContacts....." + myContacts.size());
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
