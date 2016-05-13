package controller;

import entity.Listing;
import entity.Message;
import org.apache.log4j.Logger;
import persistence.ListingDao;
import persistence.MessageDao;

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
@WebServlet("/GetMessage")
public class GetMessage extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contactId;
        HttpSession session;
        List<Message> messages;// = new ArrayList<>();
        String url = "/messaging.jsp";
        MessageDao dao = new MessageDao();

        contactId = request.getParameter("contactId");

        if(contactId == null) {
            session = request.getSession();
            contactId = (String)session.getAttribute("contactId");
        }

        log.info("Sending contactId....."  + contactId.getClass());

        messages = dao.getMessagesByContactId(contactId);
        log.info("Sending messages....." + messages.size());

        //contactId = session.getAttribute("contactId").toString();
        request.setAttribute("messages", messages);
        //session.setAttribute("contactId", contactId);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

        //request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}

