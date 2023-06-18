
package basharat.vehicles.Repositories;

import basharat.vehicles.Models.Vehicle;
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
public class VehicleRepository {

    private final String connectionUrl;
    private final String username;
    private final String password;

    public VehicleRepository() {
        String databaseName = "students_db";
        connectionUrl = "jdbc:mariadb://localhost:3315/" + databaseName;
        username = "root";
        password = "admin";
    }

    public Vehicle getVehicle(int vehicleId) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
            String query = "SELECT id, model, year, price FROM vehicles WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, vehicleId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return readNextVehicle(resultSet);
            }
            return null;

        }
    }

    public ArrayList<Vehicle> getVehicles() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
            String query = "SELECT id, model, year, price FROM vehicles";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            while (resultSet.next()) {
                vehicles.add(readNextVehicle(resultSet));
            }
            return vehicles;
        }
    }

    private Vehicle readNextVehicle(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String model = resultSet.getString("model");
        int year = resultSet.getInt("year");
        double price = resultSet.getDouble("price");
        return new Vehicle(id, model, year, price);
    }

//    public Vehicle addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "INSERT INTO vehicles (model, year, price) VALUES(? , ? , ?)";
//            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, vehicle.getVehicleModel());
//            statement.setInt(2, vehicle.getVehicleYear());
//            statement.setDouble(3, vehicle.getVehiclePrice());
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected > 0) {
//                return new Vehicle(getGeneratedId(statement), vehicle);
//            }
//            throw new SQLException("Failed to Create Vehicle");
//        }
//    }
//
//    private int getGeneratedId(PreparedStatement statement) throws SQLException {
//        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//            if (generatedKeys.next()) {
//                return generatedKeys.getInt(1);
//            }
//            throw new SQLException("Vehicle Created!! Failed to Generate ID!!");
//        }
//    }
//
//    public boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "UPDATE vehicles SET model = ?, year = ?, price = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, vehicle.getVehicleModel());
//            statement.setInt(2, vehicle.getVehicleYear());
//            statement.setDouble(3, vehicle.getVehicleYear());
//            statement.setInt(4, vehicle.getVehicelId());
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
//
//    public boolean updateVehicleModel(Vehicle vehicle) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "UPDATE vehicles SET model = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, vehicle.getVehicleModel());
//            statement.setInt(2, vehicle.getVehicelId());
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
//
//    public boolean updateVehicleYear(Vehicle vehicle) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "UPDATE vehicles SET year = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, vehicle.getVehicleYear());
//            statement.setInt(2, vehicle.getVehicelId());
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
//
//    public boolean updateVehiclePrice(Vehicle vehicle) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "UPDATE vehicles SET price = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setDouble(1, vehicle.getVehiclePrice());
//            statement.setInt(2, vehicle.getVehicelId());
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
//
//    public boolean removeVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
//        Class.forName("org.mariadb.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
//            String query = "DELETE FROM vehicles WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, vehicle.getVehicelId());
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        }
//    }
}
