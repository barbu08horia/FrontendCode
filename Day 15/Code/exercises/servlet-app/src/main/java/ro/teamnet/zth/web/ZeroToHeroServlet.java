/**
 * HelloWorldServlet.java
 * <p>
 * Copyright (c) 2014 Teamnet. All Rights Reserved.
 * <p>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 **/

package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Hello World Servlet expose get method to say hello to input user
 */
public class ZeroToHeroServlet extends HttpServlet {

    /**
     * This method is used to map a GET request from the client side
     * @param ?request the HttpServletRequest instance
     * @param ?response the HttpServletResponse instance
     * @throws ServletException
     * @throws IOException
     */



    private String handleRequest(HttpServletRequest req) {
        String response = "Hello <b>"+req.getParameter("firstName")+" "+req.getParameter("lastName")+"</b>! Enjoy Zero To Hero!!!";

        return response;

    }
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
    resp.setContentType("text/html");
    resp.getWriter().write(handleRequest(req));
}


}
