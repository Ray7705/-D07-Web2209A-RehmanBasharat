package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.User;
import ca.collegeuniversel.recipes.exceptions.UserException;
import ca.collegeuniversel.recipes.exceptions.ValidationException;
import ca.collegeuniversel.recipes.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogInController", urlPatterns = {"/login"})
public class LogInController extends HttpServlet {

    private final UserService userService;

    public LogInController() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.logIn(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("recipes.jsp");
        } catch (ValidationException e) {
            request.setAttribute("error-message", e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (UserException e) {
            request.setAttribute("error-message", e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("login.jsp");
        }
    }
}
