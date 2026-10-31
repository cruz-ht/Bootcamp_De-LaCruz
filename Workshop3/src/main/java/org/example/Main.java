package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> storeProducts = FileManager.readProducts();
        List<Product> newCart = new ArrayList<>();


        int option = 0;
        while (option != 3) {

            System.out.println("\nWELCOME, RUNNER.");
            System.out.println("Your next upgrade starts here. Access the marketplace below.");

            System.out.println("\nSELECT YOUR DESTINATION_");
            System.out.println("[1]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Browse the Shop");
            System.out.println("[2]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  View Selected Gear");
            System.out.println("[3]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Disconnect");

            System.out.println("\nEnter Command: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    availableProducts(storeProducts, scanner, newCart);
                    break;

                case 2:
                    cartProducts(newCart, scanner);
                    break;

                case 3:
                    System.out.println("CONNECTION TERMINATED // Until next time, Runner.");
                    System.exit(0);
                default:
                    System.out.println("UNKNOWN COMMAND // Try another input, runner.\n");

            }
        }
    }


    //METHODS
    // 1ST OPTION- AVAILABLE PRODUCTS/SEARCH/ADD TO CART
    public static void availableProducts(List<Product> products, Scanner scanner, List<Product> cart) {
        System.out.println("\nGEAR CATALOG");
        System.out.println("Browse Available Hardware. Find your next Upgrade.\n");

        //prints out list of available items
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("SKU: %s | %s, %.2f, %s %n", product.getSku(), product.getItemName(), product.getPrice(), product.getDepartment());
        }
        //inside menu
        int option = 0;
        while (option != 3) {
            System.out.println("\nAVAILABLE ACTIONS: ");
            System.out.println("[1]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Search");
            System.out.println("[2]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Add Gear to Loadout");
            System.out.println("[3]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Return to Main Menu");
            System.out.println("\nEnter Command: ");
            option = scanner.nextInt();
            scanner.nextLine();


            switch (option) {
                //SEARCHING BY SKU
                case 1:
                    System.out.println("Enter product SKU to begin your scan: ");
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
                        System.out.println("No Matching Gear Detected. Refine your Search and Try Again.\\ ");
                    }
                    break;
                //ADDING GEAR/ITEM
                case 2:
                    System.out.println("Enter the Item SKU you'd like to Add: ");
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
                        System.out.println("No Matching Gear Detected..");
                    }
                    break;
                //RETURN TO MAIN
                case 3:
                    System.out.println("\n Exiting the Catalog. Returning to the Main Menu...\n");
                    break;
                default:
                    System.out.println("\n-- UNKNOWN COMMAND // Try another input, runner. --\n");
            }
        }
    }

    // 2ND OPTION- VIEW CART/TOTAL/REMOVE
    public static void cartProducts(List<Product> cart, Scanner scanner) {
        System.out.println("\nYOUR CURRENT LOADOUT");
        System.out.println("Review your Selected Gear before Checkout.\n");


        int option = 0;
        while (option != 2) {

            float total = 0;
            //prints out list of available items w/ total formula
            for (int i = 0; i < cart.size(); i++) {
                Product product = cart.get(i);
                System.out.printf("SKU: %s | %s, %.2f%n", product.getSku(), product.getItemName(), product.getPrice());
                total += product.getPrice();
            }
            System.out.printf("Total Cost: $ %.2f%n", total);

            //INSIDE MENU
            System.out.println("\nAVAILABLE ACTIONS: ");
            System.out.println("[1]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Remove Gear");
            System.out.println("[2]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Return to Main Menu");
            System.out.println("\nEnter Command: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                //REMOVE ITEM FROM CART
                case 1:
                    System.out.println("\nEnter the Product SKU you wish to Remove: ");
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
                        System.out.println("\nGear not found in your loadout. Verify the product SKU.\n");
                    }
                    break;
                    //RETURN TO MAIN
                case 2:
                    System.out.println("\nLoadout Closed. Returning to the Main Menu...\n");
                    break;
                default:
                    System.out.println("\n-- UNKNOWN COMMAND // Try another input, runner. --\n");
            }
        }
    }
}