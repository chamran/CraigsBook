package controller;

import entity.Contact;
import entity.Listing;
import org.apache.log4j.Logger;
import persistence.ContactDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "PostContact", urlPatterns = { "/postContact" }
)
public class PostContact extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookTitle = request.getParameter("bookTitle");
        String listingWantedBy = request.getUserPrincipal().getName();
        String listingMadeBy = request.getParameter("userName");
        int listingId = Integer.parseInt(request.getParameter("listingId"));


        log.info("addContact");
        Contact contact = new Contact(bookTitle, listingMadeBy, listingWantedBy, listingId);
        ContactDao dao = new ContactDao();
        dao.addContact(contact);

        String url = "/searchListings.jsp";
        //HttpSession session = request.getSession();
        //session.setAttribute("searchListings", searchListings);
        request.setAttribute("bookTitle", bookTitle);
        log.info("Sending contact data....." + contact.getListingMadeBy());
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        //response.sendRedirect(url);


    }
}
