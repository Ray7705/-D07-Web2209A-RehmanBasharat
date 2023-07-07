package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.repositories.RecipeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LikeRecipeController", urlPatterns = {"/like"})
public class LikeRecipeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int recipeId = Integer.parseInt(request.getParameter("id"));
        String username = (String) request.getSession().getAttribute("username");

        RecipeRepository recipeRepository = new RecipeRepository();
        boolean isLikeSuccessful;

        try {
            isLikeSuccessful = recipeRepository.addLike(username, recipeId);
        } catch (ClassNotFoundException | SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to like the recipe.");
            return;
        }

        if (isLikeSuccessful) {
            response.sendRedirect("recipes.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to like the recipe.");
        }

    }
}
