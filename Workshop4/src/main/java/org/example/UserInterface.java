package org.example;

import java.math.BigDecimal;
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
        while (!option.equals("0")) {
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

    //LIST FORMAT AKA HELPER
    private void displayVehicles(List<Vehicle> vehicles) {
        System.out.printf("%n%n%-8s%-7s%-15s%-13s%-13s%-8s%-9s%s%n", "VIN", "Year", "Make", "Model", "Type", "Color", "Miles", "Price");
        System.out.println("--------------------------------------------------------------------------------");
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-8d%-7d%-15s%-13s%-13s%-8s%-9d$%.2f%n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }

    //WHILE LOOP HELPER FOR INT VALUES
    private int loopForInt(String question) {
        while (true) {
            System.out.println(question);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please use numbers only and try again.\n");
            }
        }
    }

    //WHILE LOOP HELPER FOR BIGDECIMAL VALUES
    private BigDecimal loopForBigDecimal(String question) {
        while (true) {
            System.out.println(question);
            try {
                return new BigDecimal(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter numbers only.\n");
            }
        }
    }

    public void processGetByPriceRequest() {
        System.out.println("\n\n Find Your Ride by Price");
        System.out.println("Let's find something that fits your budget!\n");

        BigDecimal usersMinPrice = loopForBigDecimal("Minimum price: $ ");
        BigDecimal usersMaxPrice = loopForBigDecimal("Maximum price: $ ");

        var priceResults = dealership.getVehiclesByPrice(usersMinPrice, usersMaxPrice);
        if (priceResults.isEmpty()) {
            System.out.println("No rides found within that price range. Try adjusting your budget!");
        } else {
            displayVehicles(priceResults);
        }
    }

    public void processGetByMakeModelRequest() {
        System.out.println("\n\n Find by Make/Model");
        System.out.println("Looking for something specific? Let's Find it!\n");

        System.out.println("Enter vehicle make: ");
        var usersMake = scanner.nextLine().trim();
        System.out.println("\nEnter vehicle model: ");
        var usersModel = scanner.nextLine().trim();

        var makeModelResult = dealership.getVehiclesByMakeModel(usersMake, usersModel);
        if (makeModelResult.isEmpty()) {
            System.out.println("\nWe couldn't find that make or model in our collection. Try another search!\n");
        } else {
            displayVehicles(makeModelResult);
        }
    }

    public void processGetByYearRequest() {
        System.out.println("\n\n Find Your Ride by Year");
        System.out.println("Let's narrow down the collection by model year!\n");

        int usersMinYear = loopForInt("Enter starting year: ");
        int usersMaxYear = loopForInt("Enter ending year: ");

        var yearResults = dealership.getVehiclesByYear(usersMinYear, usersMaxYear);
        if (yearResults.isEmpty()) {
            System.out.println("\nNo vehicles found within those model years. Try a different year range!\n");
        } else {
            displayVehicles(yearResults);
        }
    }

    public void processGetByColorRequest() {
        System.out.println("\n\n Find Your Perfect Color");
        System.out.println("Every great ride deserves the perfect finish!\n");
        System.out.println("Enter your preferred vehicle color: ");
        var usersColor = scanner.nextLine().trim();

        //searching the color using get and saving it as a var(to reuse in if/els
        var colorResults = dealership.getVehiclesByColor(usersColor);
        //instead of displaying an empty list, it'll show a msg
        if (colorResults.isEmpty()) {
            System.out.println("\nThat color isn't in our collection just yet. Try another shade!\n");
        } else { //shortcut aka print in "displayVehicles method" and what im showing/passing through
            displayVehicles(colorResults);
        }
    }

    public void processGetByMileageRequest() {
        System.out.println("\n\nFind By Mileage");
        System.out.println("Let's find a ride that fits your mileage preference!\n");

        int usersMinMileage = loopForInt("Enter minimum mileage: ");
        int usersMaxMileage = loopForInt("Enter maximum mileage: ");

        var mileageResults = dealership.getVehiclesByMileage(usersMinMileage, usersMaxMileage);
        if (mileageResults.isEmpty()) {
            System.out.println("No rides found within that mileage range. Let's adjust the search!");
        } else {
            displayVehicles(mileageResults);
        }
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("\n\nChoose Your Ride Style");
        System.out.println("What type of vehicle are you looking for?\n");
        System.out.println("Cars, Trucks, SUVs, and More !");
        System.out.println("Enter your preferred vehicle type: ");
        var usersType = scanner.nextLine().trim();

        var typeResults = dealership.getVehiclesByType(usersType);
        if (typeResults.isEmpty()) {
            System.out.println("\nWe couldn't find any vehicles of that type. Try another category!\n");
        } else {
            displayVehicles(typeResults);
        }
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
    }

    public void processRemoveVehicleRequest() {
    }

}
