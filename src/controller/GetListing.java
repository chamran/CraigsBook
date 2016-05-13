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

@WebServlet(name = "GetListing", urlPatterns = { "/getListing" }
)
public class GetListing extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");
        List<Listing> searchListings = new ArrayList<>();
        log.info("Sending searchListings....." + searchTerm + searchType);

        ListingDao dao = new ListingDao();

        searchListings = dao.getListingsByQuery(searchType, searchTerm);

        String url = "/searchListings.jsp";

        HttpSession session = request.getSession();

        session.setAttribute("searchListings", searchListings);
        //request.setAttribute("searchListings", searchListings);
        log.info("Sending searchListings....." + searchListings.size());


        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
