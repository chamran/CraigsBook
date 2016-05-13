package controller;

import entity.Book;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Listing;
import org.apache.log4j.Logger;
import persistence.ListingDao;


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
@WebServlet(name = "DeleteListing", urlPatterns = { "/deleteListing" }
)
public class DeleteListing extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String listingId = request.getParameter("listingId");

        ListingDao dao = new ListingDao();
        dao.deleteListingById(listingId);

        String url = "/getMyListing";

        //request.setAttribute("listing", listing);
        log.info("Sending listing data....." +listingId);


        response.sendRedirect(url);

    }
}
