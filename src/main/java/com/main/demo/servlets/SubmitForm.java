package com.main.demo.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "submitForm",
        urlPatterns = "/submit-form"
)
public class SubmitForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("submit-form.jsp");
        String submittedColor = req.getParameter("color");
        if (submittedColor == null) {
            submittedColor="No color submitted";
        }

        req.setAttribute("submittedColor",submittedColor);

        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submittedColor = req.getParameter("color");
        req.setAttribute("color", submittedColor);
        doGet(req, resp);

    }
}
