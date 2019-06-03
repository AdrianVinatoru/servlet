package com.main.demo.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "helloServlet",
        urlPatterns = "/demo"
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Set the content type
        resp.setContentType("text/html");

        //Get the stream for writing data
        PrintWriter pw=resp.getWriter();

        pw.println("<html><body>");
        pw.println("Hello first servlet !!!");
        pw.println("</body></html>");

        //Close the stream
        pw.close();
    }
}
