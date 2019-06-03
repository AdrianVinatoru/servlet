package com.main.demo.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "helloJsp",
        urlPatterns = "/hello-jsp"
)
public class HelloJsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("helloAttribute", "Value from Servlet passed in JSP !!!");
        RequestDispatcher view = req.getRequestDispatcher("hello-jsp.jsp");
        view.forward(req, resp);
    }
}
