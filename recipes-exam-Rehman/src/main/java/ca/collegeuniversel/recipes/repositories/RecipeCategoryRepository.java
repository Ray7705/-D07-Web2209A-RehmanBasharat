package ca.collegeuniversel.recipes.repositories;

import ca.collegeuniversel.recipes.entities.RecipeCategory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeCategoryRepository {

    private final String connectionUrl;
    private final String connectionUsername;
    private final String connectionPassword;

    public RecipeCategoryRepository() {
        String databaseName = "recipes_db";
        connectionUrl = "jdbc:mariadb://localhost:3315/" + databaseName;
        connectionUsername = "root";
        connectionPassword = "admin";
    }

    public RecipeCategory getCategory(int id) throws ClassNotFoundException, SQLException {
        // TODO
        return null;
    }

    public ArrayList<RecipeCategory> getCategories() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword)) {
            String query = "SELECT id, name, image_path FROM categories";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<RecipeCategory> categories = new ArrayList<>();
            while (resultSet.next()) {
                categories.add(readNextCategory(resultSet));
            }
            return categories;
        }

    }

    private static RecipeCategory readNextCategory(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String plural_name = resultSet.getString("image_path");

        return new RecipeCategory(id, name, plural_name);
    }
}
