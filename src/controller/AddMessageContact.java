package controller;

import entity.*;
import org.apache.log4j.Logger;
import persistence.MessageContactDao;
import persistence.MessageDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "AddMessageContact", urlPatterns = { "/AddMessageContact" } )


public class AddMessageContact extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MessageContact messageContact = new MessageContact();
        messageContact.setBookTitle(request.getParameter("title"));
        messageContact.setListingWantedBy(request.getUserPrincipal().getName());

        MessageContactDao dao = new MessageContactDao();
        int id = dao.addMessageContact(messageContact);

        request.setAttribute("messageContact", dao.getMessageContactById(id));
        log.debug("Sending messageContact");


        String url = "/messaging.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        /*BookDao bookDao = new BookDao();

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
