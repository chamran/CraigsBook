package controller;

import entity.Message;
import org.apache.log4j.Logger;
import persistence.MessageDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 5/10/2016.
 */
@WebServlet(name = "PostMessage", urlPatterns = { "/postMessage" }
)
public class PostMessage extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        log.info("contactId:....." + request.getParameter("contactId"));
        String contactId = request.getParameter("contactId");
        String userName = request.getUserPrincipal().getName();
        String userMessage = request.getParameter("message");

        Message message = new Message(contactId, userName, userMessage);
        MessageDao dao = new MessageDao();
        dao.addMessage(message);

        HttpSession session = request.getSession();

        String url = "/GetMessage";
        session.setAttribute("contactId", contactId);
        //request.setAttribute("message", message);
        log.info("type of object....." + contactId.getClass());
        log.info("contactId:....." + request.getParameter("contactId"));


        //RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        //dispatcher.forward(request, response);
        response.sendRedirect(url);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}