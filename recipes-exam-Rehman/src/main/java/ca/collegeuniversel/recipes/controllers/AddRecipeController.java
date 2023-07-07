package ca.collegeuniversel.recipes.controllers;

import ca.collegeuniversel.recipes.entities.Recipe;
import ca.collegeuniversel.recipes.repositories.RecipeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddRecipeController", urlPatterns = {"/add"})
public class AddRecipeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the form data from the request
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String imagePath = request.getParameter("image_path");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));

        Recipe recipe = new Recipe(name, description, imagePath, categoryId);

        RecipeRepository recipeRepository = new RecipeRepository();

        try {
            recipeRepository.addRecipe(recipe);
        } catch (ClassNotFoundException | SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add the recipe.");
            return;
        }
        response.sendRedirect("recipe.jsp");
    }

}
