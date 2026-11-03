package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    //COLOR LIST
    public static final String RESET = "\u001B[0m";
    public static final String HEADER = "\u001B[95m";
    public static final String USERINPUT = "\u001B[96m";
    public static final String ERROR = "\033[31m";





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> storeProducts = FileManager.readProducts();
        List<Product> newCart = new ArrayList<>();


        String option = "";

        // while(option !=3)
        while (!option.equals("3")) {

            System.out.println(HEADER + "\nWELCOME, RUNNER." + RESET);
            System.out.println("Your next upgrade starts here. Access the marketplace below.");

            System.out.println("\nSELECT YOUR DESTINATION_");
            System.out.println(USERINPUT + "[1]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Browse the Shop");
            System.out.println(USERINPUT + "[2]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  View Selected Gear");
            System.out.println(USERINPUT + "[3]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Disconnect");

            System.out.println(USERINPUT + "\nEnter Command: " + RESET);

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    availableProducts(storeProducts, scanner, newCart);
                    break;

                case "2":
                    cartProducts(newCart, scanner);
                    break;

                case "3":
                    System.out.println(HEADER + "CONNECTION TERMINATED // Until next time, Runner." + RESET);
                    break;
                default:
                    System.out.println(ERROR + "\nUNKNOWN COMMAND // Try another input, runner.\n" + RESET);

            }
        }
    }


    //METHODS
    // 1ST OPTION- AVAILABLE PRODUCTS/SEARCH/ADD TO CART
    public static void availableProducts(List<Product> products, Scanner scanner, List<Product> cart) {
        System.out.println(HEADER + "\nGEAR CATALOG" + RESET);
        System.out.println("Browse Available Hardware. Find your next Upgrade.\n");

        //prints out list of available items
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("SKU: %s | %s, %.2f, %s %n", product.getSku(), product.getItemName(), product.getPrice(), product.getDepartment());
        }
        //inside menu
        String option = "";
        while (!option.equals("3")) {
            System.out.println("\nAVAILABLE ACTIONS: ");
            System.out.println(USERINPUT + "[1]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Search");
            System.out.println(USERINPUT + "[2]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Add Gear to Loadout");
            System.out.println(USERINPUT + "[3]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Return to Main Menu");
            System.out.println(USERINPUT + "\nEnter Command: " + RESET);
            option = scanner.nextLine();


            switch (option) {
                //SEARCHING BY SKU
                case "1":
                    System.out.println(USERINPUT + "Enter product SKU to begin your scan: " + RESET);
                    String userSku = scanner.nextLine();

                    boolean found = false;
                    for (int i = 0; i < products.size(); i++) {
                        Product product = products.get(i);
                        if (userSku.equalsIgnoreCase(product.getSku())) {
                            found = true;
                            System.out.printf("SKU: %s | %s, %.2f, %s %n", product.getSku(), product.getItemName(), product.getPrice(), product.getDepartment());
                        }
                    }
                    if (found == false) {
                        System.out.println(ERROR + "No Matching Gear Detected. Refine your Search and Try Again. " + RESET);
                    }
                    break;
                //ADDING GEAR/ITEM
                case "2":
                    System.out.println(USERINPUT + "Enter the Item SKU you'd like to Add: " + RESET);
                    String addSku = scanner.nextLine();

                    boolean added = false;
                    for (int i = 0; i < products.size(); i++) {
                        Product product = products.get(i);
                        if (addSku.equalsIgnoreCase(product.getSku())) {
                            cart.add(product);
                            added = true;
                            System.out.println("\nTransfer complete. " + product.getItemName() + " added to your loadout.\n");
                        }
                    }
                    if (added == false) {
                        System.out.println(ERROR + "No Matching Gear Detected.." + RESET);
                    }
                    break;
                //RETURN TO MAIN
                case "3":
                    System.out.println("\n Exiting the Catalog. Returning to the Main Menu...\n");
                    break;
                default:
                    System.out.println(ERROR + "\n-- UNKNOWN COMMAND // Try another input, runner. --\n" + RESET);
            }
        }
    }

    // 2ND OPTION- VIEW CART/TOTAL/REMOVE
    public static void cartProducts(List<Product> cart, Scanner scanner) {
        System.out.println(HEADER + "\nYOUR CURRENT LOADOUT" + RESET);
        System.out.println("Review your Selected Gear before Checkout.\n");


        String option = "";
        while (!option.equals("2")) {

            float total = 0;
            //prints out list of available items w/ total formula
            for (int i = 0; i < cart.size(); i++) {
                Product product = cart.get(i);
                System.out.printf("SKU: %s | %s, %.2f%n", product.getSku(), product.getItemName(), product.getPrice());
                total += product.getPrice();
            }
            System.out.printf("Total Cost: €$ %.2f%n", total);

            //INSIDE MENU
            System.out.println("\nAVAILABLE ACTIONS: ");
            System.out.println(USERINPUT + "[1]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Remove Gear");
            System.out.println(USERINPUT + "[2]"+ RESET+ "  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Return to Main Menu");
            System.out.println(USERINPUT + "\nEnter Command: " + RESET);
            option = scanner.nextLine();

            switch (option) {
                //REMOVE ITEM FROM CART
                case "1":
                    System.out.println(USERINPUT + "\nEnter the Product SKU you wish to Remove: " + RESET);
                    String returnSku = scanner.nextLine();

                    boolean removed= false;

                    for( int i = 0; i < cart.size(); i++) {
                        Product product = cart.get(i);
                        if(returnSku.equalsIgnoreCase(product.getSku())) {
                            cart.remove(product);
                            removed = true;

                            System.out.printf("%s removed from your loadout. Inventory updated.%n", product.getItemName());
                            break;// breaks it from removing multiple of the same item
                        }
                    }
                    if(removed == false){
                        System.out.println(ERROR + "\nGear not found in your loadout. Verify the product SKU.\n" + RESET);
                    }
                    break;
                    //RETURN TO MAIN
                case "2":
                    System.out.println("\nLoadout Closed. Returning to the Main Menu...\n");
                    break;
                default:
                    System.out.println(ERROR + "\n-- UNKNOWN COMMAND // Try another input, runner. --\n" + RESET);
            }
        }
    }
}