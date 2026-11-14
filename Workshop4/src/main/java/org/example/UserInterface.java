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

        String option = "";
        while(!option.equals("0")){
            System.out.println("\n\nSugar Rush Motors");
            System.out.println("─────────────────");

            System.out.println("THE SHOWROOM");
            System.out.println("Find your next ride or manage the collection.\n");
            System.out.println("1 ᰔ Find Vehicles by Price");
            System.out.println("2 ᰔ Find by Make/Model");
            System.out.println("3 ᰔ Find Vehicles by Year");
            System.out.println("4 ᰔ Find Vehicles by Color");
            System.out.println("5 ᰔ Find Vehicles by Mileage");
            System.out.println("6 ᰔ Find Vehicles by Type");
            System.out.println("7 ᰔ View All Vehicles");
            System.out.println("8 ᰔ Add a Vehicle");
            System.out.println("9 ᰔ Remove a Vehicle");
            System.out.println("0 ᰔ Exit Showroom\n");
            System.out.println("Select a showroom option: ");
            option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "0":
                    System.out.println("Thanks for visiting Sugar Rush Motors. Until next time!");
                    break;
                default:
                    System.out.println("That choice isn't in our lineup. Please select another option!");
            }
        }
    }

    //loads the file to read and sets it in dealership to call when searching
    private void init() {
        var fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    //LIST FORMAT
    private void displayVehicles(List<Vehicle> vehicles){
        System.out.printf("%n%n%-7s%-6s%-15s%-13s%-13s%-8s%-9s%s%n", "VIN", "Year", "Make", "Model", "Type", "Color", "Miles", "Price");
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
