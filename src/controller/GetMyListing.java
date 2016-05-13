package controller;

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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "GetMyListing", urlPatterns = { "/getMyListing" }
)

public class GetMyListing extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userNameColumn = "userName";
        String userName = request.getUserPrincipal().getName();
        List<Listing> myListings = new ArrayList<>();
        log.info("Sending myListings.....");

        ListingDao dao = new ListingDao();

        myListings = dao.getListingsByQuery(userNameColumn, userName);

        String url = "/yourListings.jsp";

        HttpSession session = request.getSession();

        session.setAttribute("myListings", myListings);
        log.info("Sending myListings....." + myListings.size());


        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        //response.sendRedirect(url);

     }
}
