package ca.collegeuniversel.recipes.repositories;

import ca.collegeuniversel.recipes.entities.RecipeCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeCategoryRepository
{
    private final String connectionUrl;
    private final String connectionUsername;
    private final String connectionPassword;

    public RecipeCategoryRepository()
    {
        String databaseName = "recipes_db";
        connectionUrl = "jdbc:mariadb://localhost:3315/" + databaseName;
        connectionUsername = "root";
        connectionPassword = "admin";
    }
    
    public RecipeCategory getCategory(int id) throws ClassNotFoundException, SQLException
    {
        // TODO
        return null;
    }

    public ArrayList<RecipeCategory> getCategories() throws ClassNotFoundException, SQLException
    {
        // TODO
        return null;
    }

    private static RecipeCategory readNextCategory(ResultSet resultSet) throws SQLException
    {
        // TODO
        return null;
    }
}
