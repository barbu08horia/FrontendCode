package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Lion King on 13-Jul-16.
 */
public class InfoHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder response = new StringBuilder();
        response.append("<html><body><table>");
        Enumeration headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = headers.nextElement().toString();
            response.append("<tr><th>" + name + "</th><th>" + req.getHeader(name) + "</th></tr>");
        }
        response.append("</table></body></html>");
        resp.getWriter().write(response.toString());
    }
}