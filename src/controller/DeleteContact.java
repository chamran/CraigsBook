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
 * Created by Student on 4/20/2016.
 */

@WebServlet(name = "DeleteContact", urlPatterns = { "/deleteContact" }
)
public class DeleteContact extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String contactId = request.getParameter("contactId");


        log.info("removeContact....." + contactId);
        ContactDao dao = new ContactDao();
        dao.deleteContactById(contactId);

        String url = "/getContact";




        response.sendRedirect(url);

    }
}
