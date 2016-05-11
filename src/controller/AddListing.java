package controller;



import entity.Book;
import entity.Listing;
import org.apache.log4j.Logger;
import persistence.ListingDao_;
import persistence.ListingDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Student on 5/3/2016.
 */


@WebServlet(name = "AddListing", urlPatterns = { "/addListing" } )


public class AddListing extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


       /* Listing listing = new Listing();
        //Book book = new Book(req.getParameter("book"), req.getParameter("instructor"), req.getParameter("course"), req.getParameter("isbn"));
        log.debug("Adding Listing: " + listing);
        ListingDao dao = new ListingDao();
        dao.addListing(listing);
        BookDao bookDao = new BookDao();

        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book myBook = new Book();
        myBook.setAuthor(author);
        myBook.setTitle(title);

        bookDao.addBook(myBook);

        String url = "/member/addBook.jsp";
        response.sendRedirect(url);*/
    }
}
