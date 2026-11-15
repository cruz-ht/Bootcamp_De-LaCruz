package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        return null;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        var makeModelMatch = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                makeModelMatch.add(vehicle);
            }
        }
        return makeModelMatch;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        var yearMatch = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            //the if statement is making sure the range stays between the two numbers
            if (vehicle.getYear() <= max && vehicle.getYear() >= min) {
                yearMatch.add(vehicle);
            }
        }
        return yearMatch;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        var colorMatch = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                colorMatch.add(vehicle);
            }
        }
        return colorMatch;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        var mileageMatch = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() <= max && vehicle.getOdometer() >= min) {
                mileageMatch.add(vehicle);
            }
        }
        return mileageMatch;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        var typeMatch = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                typeMatch.add(vehicle);
            }
        }
        return typeMatch;
    }


    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

}