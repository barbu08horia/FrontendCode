package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.swing.text.Position.Bias.Forward;

/**
 * Created by Lion King on 13-Jul-16.
 */
public class HelloWorldServletForward extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "";

        // Set the response type
        resp.setContentType("text/html");

        // Obtain the user from the request instance
//        user = req.getParameter("user");

        //Write the response content
        /*resp.getWriter().write("Hello <b>" + user + "</b>");*/
//        req.getAttribute("someAttribute");
        resp.getWriter().write("Hello <b>"+req.getParameter("user")+""+"</b> HelloWorldServlet " + req.getAttribute("someAtribute"));
    }
}
