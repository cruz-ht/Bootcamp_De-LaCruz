package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public void display() {
    }

    private void init() {
        var fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles){
        System.out.printf("%-7s%-6s%-15s%-13s%-13s%-8s%-9s%s%n", "VIN", "Year", "Make", "Model", "Type", "Color", "Miles", "Price");
        System.out.println("--------------------------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-7d%-6d%-15s%-13s%-13s%-8s%-9d$%.2f%n",vehicle.getVin(),vehicle.getYear(), vehicle.getMake(),vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }

    public void processGetByPriceRequest() {
    }
    public void processGetByMakeModelRequest() {
    }
    public void processGetByYearRequest() {
    }
    public void processGetByColorRequest() {
    }
    public void processGetByMileageRequest() {
    }
    public void processGetByVehicleTypeRequest() {
    }
    public void processGetAllVehiclesRequest() {
    }
    public void processAddVehicleRequest() {
    }
    public void processRemoveVehicleRequest() {
    }

}
