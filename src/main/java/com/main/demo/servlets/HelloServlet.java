package com.main.demo.servlets;

import com.main.demo.servlets.model.User;
import com.main.demo.servlets.service.UserService;
import com.main.demo.servlets.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "helloServlet",
        urlPatterns = "/demo"
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        UserService userService = new UserServiceImpl();

        User saveUser = new User(2, "mihai.stefan", "0722274813");
        userService.saveUser(saveUser);

        List<User> users = userService.findAllUsers();



        //Set the content type
        resp.setContentType("text/html");

        //Get the stream for writing data
        PrintWriter pw = resp.getWriter();

        pw.println("<html><body>");
        pw.println("Users in database"+users.size());
        pw.println("</body></html>");

        //Close the stream
        pw.close();
    }
}
