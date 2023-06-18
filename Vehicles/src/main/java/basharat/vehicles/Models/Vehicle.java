/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.vehicles.Models;

import java.util.Objects;

/**
 *
 * @author rehma
 */
public class Vehicle {

    private final int vehicelId;
    private String vehicleModel;
    private int vehicleYear;
    private Double vehiclePrice;

    public int getVehicelId() {
        return vehicelId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Vehicle(int vehicelId, String vehicleModel, int vehicleYear, Double vehiclePrice) {
        this.vehicelId = vehicelId;
        this.vehicleModel = Objects.requireNonNull(vehicleModel);
        this.vehicleYear = Objects.requireNonNull(vehicleYear);
        this.vehiclePrice = Objects.requireNonNull(vehiclePrice);
    }

    public Vehicle(int vehicleId, Vehicle original) {
        this(vehicleId, original.vehicleModel, original.vehicleYear, original.vehiclePrice);
    }

}
