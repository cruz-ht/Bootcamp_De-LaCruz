package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public void display() {
        init();

        //main menu
        String option = "";
        while(!option.equals("0")){
            System.out.println("\n\nSugar Rush Motors");
            System.out.println("─────────────────");

            System.out.println("1 ᰔ ");
            System.out.println("2 ᰔ ");
            System.out.println("3 ᰔ ");
            System.out.println("4 ᰔ ");
            System.out.println("5 ᰔ ");
            System.out.println("6 ᰔ ");
            System.out.println("7 ᰔ ");
            System.out.println("8 ᰔ ");
            System.out.println("9 ᰔ ");
            System.out.println("0 ᰔ ");
            System.out.println("Select a showroom option: ");
            option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    System.out.println("coming soon...");
                    break;
                case "2":
                    System.out.println("coming soon...");
                    break;
                case "3":
                    System.out.println("coming soon...");
                    break;
                case "4":
                    System.out.println("coming soon...");
                    break;
                case "5":
                    System.out.println("coming soon...");
                    break;
                case "6":
                    System.out.println("coming soon...");
                    break;
                case "7":
                    System.out.println("coming soon...");
                    break;
                case "8":
                    System.out.println("coming soon...");
                    break;
                case "9":
                    System.out.println("coming soon...");
                    break;
                case "0":
                    System.out.println("thank you for choosing..");
                    break;
                default:
            }
        }
    }

    //loads the file to read and sets it in dealership to call when searching
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
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest() {
    }
    public void processRemoveVehicleRequest() {
    }

}
