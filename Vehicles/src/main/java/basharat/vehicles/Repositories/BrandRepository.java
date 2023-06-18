/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.vehicles.Repositories;

import basharat.vehicles.Models.Brand;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rehma
 */
public class BrandRepository {

    private final String connectionUrl;
    private final String username;
    private final String password;

    public BrandRepository() {
        String databaseName = "vehicles_db";
        connectionUrl = "jdbc:mariadb://localhost:3315/" + databaseName;
        username = "root";
        password = "admin";
    }

    public Brand getBrand(int brandId) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
            String query = "SELECT id, name FROM brands WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, brandId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return readNextBrand(resultSet);
            }
            return null;
        }
    }

    public ArrayList<Brand> getBrands() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
            String query = "SELECT id, name FROM brands";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Brand> brands = new ArrayList<>();
            while (resultSet.next()) {
                brands.add(readNextBrand(resultSet));
            }
            return brands;
        }
    }

    private Brand readNextBrand(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Brand(id, name);
    }

//    public Brand addBrand(Brand brand) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "INSERT INTO brands (name) VALUES(?)";
//            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, brand.getBrandName());
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected > 0) {
//                return new Brand(getGeneratedId(statement), brand);
//            }
//            throw new SQLException("Failed to Create Brand");
//        }
//
//    }
//
//    private int getGeneratedId(PreparedStatement statement) throws SQLException {
//        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//            if (generatedKeys.next()) {
//                return generatedKeys.getInt(1);
//            }
//            throw new SQLException("Brand Created!! Failed to Generate ID!!");
//        }
//    }
//
//    public boolean updateBrand(Brand brand) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "UPDATE brands SET name = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, brand.getBrandName());
//            statement.setInt(2, brand.getBrandId());
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
//
//    public boolean updateBrandName(Brand brand) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "UPDATE brands SET name = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, brand.getBrandName());
//            statement.setInt(2, brand.getBrandId());
//            
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
//
//    public boolean removeBrand(Brand brand) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "DELETE FROM brands WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, brand.getBrandId());
//            
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
}
