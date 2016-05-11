package controller;

import entity.Book;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Listing;
import org.apache.log4j.Logger;
import persistence.ListingDao;
import persistence.ListingDao_;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Student on 4/26/2016.
 */

@WebServlet(name = "VerifyListing", urlPatterns = { "/verifyListing" }
)
public class VerifyListing extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String isbn = request.getParameter("isbn");
        String instructorFirstName = request.getParameter("firstName");
        String instructorLastName = request.getParameter("lastName");
        String instructorFullName = instructorFirstName + " " + instructorLastName;
        String course = request.getParameter("course");
        String userName = request.getUserPrincipal().getName();
        String price = request.getParameter("price");

        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(new URL("http://isbndb.com/api/v2/json/0UV2GYEM/book/" + isbn), Book.class);

        Listing listing = new Listing(book, instructorFullName, course, isbn, userName, price);

        String url = "/index.jsp";

        request.setAttribute("listingData", listing);
        log.info("Sending listing data.....");


        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
