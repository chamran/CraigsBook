package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Book;
import entity.Listing;
import org.apache.log4j.Logger;
import persistence.ListingDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 4/26/2016.
 */

@WebServlet(name = "PostListing", urlPatterns = { "/postListing" }
)
public class PostListing extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String isbn = request.getParameter("isbn");
        String instructorFirstName = request.getParameter("firstName");
        String instructorLastName = request.getParameter("lastName");
        String course = request.getParameter("course");
        String userName = request.getUserPrincipal().getName();
        String price = request.getParameter("price");
        String isbndb = "http://isbndb.com/api/v2/json/0UV2GYEM/book/";

        ObjectMapper mapper = new ObjectMapper();

        Book book = mapper.readValue(new URL(isbndb + isbn), Book.class);

        Listing listing = new Listing(book, instructorFirstName, instructorLastName, course, isbn, userName, price);
        ListingDao dao = new ListingDao();
        dao.addListing(listing);

        String url = "/getMyListing";

        HttpSession session = request.getSession();
        session.setAttribute("listing", listing);
        log.info("Sending listing data....."+listing.getBookTitle());


        response.sendRedirect(url);

    }
}
