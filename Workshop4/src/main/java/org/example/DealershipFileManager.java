package org.example;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String dealersInfo = bufferedReader.readLine();
            String[] dealerParts = dealersInfo.split("\\|");

            String name = dealerParts[0];
            String address = dealerParts[1];
            String phone = dealerParts[2];

            dealership = new Dealership(name, address, phone);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] vehicleParts = line.split("\\|");

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String vehicleType = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                BigDecimal price = new BigDecimal(vehicleParts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Could not read the file.");
        }
        return dealership;
    }


    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //first line aka the dealership info
            String line = String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            bufferedWriter.write(line);

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String vehicleLine = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

                bufferedWriter.newLine();
                bufferedWriter.write(vehicleLine);
            }
            bufferedWriter.close();

        } catch (IOException ex) {
            System.out.println("Could not save the dealership.");
        }
    }
}
