package com.main.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.demo.servlets.model.User;
import com.main.demo.servlets.service.UserService;
import com.main.demo.servlets.service.impl.UserServiceImpl;

@WebServlet(
        name = "helloServlet",
        urlPatterns = "/demo"
)
public class HelloServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Save a user with the next available id
        saveNextUser();

        //Set the content type
        resp.setContentType("text/html");
        //Get the stream for writing data
        PrintWriter pw = resp.getWriter();

        pw.println("<html><body>");
        pw.println("\nUsers in database: " + userService.totalUsers());
        pw.println("<br><br>");

        // Find all users by id
        printAllUsers(pw);

        pw.println("</body></html>");

        // Delete the previous user
        // deleteThePreviousUser();

        //Close the stream
        pw.close();
    }

    private void saveNextUser() {
        int totalUsers = userService.totalUsers();
        User saveUser = new User(++totalUsers, "Adrian " + totalUsers, "00" + totalUsers + "00");

        userService.saveUser(saveUser);
    }

    private void printAllUsers(PrintWriter pw) {
        for (int i = 1; i <= userService.totalUsers(); i++) {
            User user = userService.findUserById(i);
            pw.println("\n First user: " + user.getName());
            pw.println("<br>");
        }
    }

    private void deleteThePreviousUser() {
        if (userService.totalUsers() > 1)
            userService.deleteUser(userService.findUserById(userService.totalUsers() - 1));
    }
}
