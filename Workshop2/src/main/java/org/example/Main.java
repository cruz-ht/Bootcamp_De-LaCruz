package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[20];

        books[0] = new Book(1001, "9780000000011", "The Hobbit", true, "Liam Carter");
        books[1] = new Book(1002, "9780000000028", "The Lord of the Rings (Omnibus)", false, "");
        books[2] = new Book(1003, "9780000000035", "Harry Potter and the Sorcerer's Stone", true, "Ava Thompson");
        books[3] = new Book(1004, "9780000000042", "Harry Potter and the Chamber of Secrets", false, "");
        books[4] = new Book(1005, "9780000000059", "The Chronicles of Narnia (Complete Collection)", false, "");
        books[5] = new Book(1006, "9780000000066", "A Game of Thrones", true, "Sofia Ramirez");
        books[6] = new Book(1007, "9780000000073", "A Clash of Kings", false, "");
        books[7] = new Book(1008, "9780000000080", "The Name of the Wind", false, "");
        books[8] = new Book(1009, "9780000000097", "The Way of Kings", true, "Ethan Walker");
        books[9] = new Book(1010, "9780000000103", "Mistborn: The Final Empire", false, "");
        books[10] = new Book(1011, "9780000000110", "The Eye of the World", false, "");
        books[11] = new Book(1012, "9780000000127", "American Gods", true, "Isabella Reed");
        books[12] = new Book(1013, "9780000000134", "The Lies of Locke Lamora", false, "");
        books[13] = new Book(1014, "9780000000141", "Eragon", false, "");
        books[14] = new Book(1015, "9780000000158", "A Wizard of Earthsea", true, "Chloe Nguyen");
        books[15] = new Book(1016, "9780000000165", "Assassin's Apprentice", false, "");
        books[16] = new Book(1017, "9780000000172", "Percy Jackson: The Lightning Thief", false, "");
        books[17] = new Book(1018, "9780000000189", "The Golden Compass", true, "Alex Kim");
        books[18] = new Book(1019, "9780000000196", "Throne of Glass", false, "");
        books[19] = new Book(1020, "9780000000202", "Fourth Wing", true, "Caleb Torres");



        int choice = 0;
        while(choice != 3) {
            System.out.println("\n=== BOOK STORE HOME SCREEN ===\n");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice) {
                //check methods below Switch statements
                case 1:
                    showAvailableBooks(books, scanner);
                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("GoodBye, We Hope to See you Again !");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice, Please Try Again.");


            }
        }
    }


    //METHODS REGUARDING THE ARRAY

    public static void showAvailableBooks(Book[] books, Scanner scanner){
        //LIST
        System.out.println("\n=== AVAILABLE BOOKS ===\n");
        for(int i = 0; i < books.length; i++){

            if (books[i].isCheckedOut() == false) {
                System.out.println("TITLE: " + books[i].getTitle());
                System.out.println("ID: " + books[i].getId());
                System.out.println("ISBN: " + books[i].getIsBn());
                System.out.println("");
            }
        }
        //FOLLOW UP Q, OPTIONAL CHECKOUT OR RETURN
        System.out.println("Please Enter the ID of the Book you'd like to Checkout. Otherwise enter 0 to Return back to Home Menu");

        int checkOutId = scanner.nextInt();
        scanner.nextLine();

        if(checkOutId != 0){
            boolean found = false;

            for (int i = 0; i < books.length; i++) {


                if(books[i].getId() == checkOutId) {
                    found = true;

                    if(books[i].isCheckedOut() == false) {
                        System.out.println("Please Enter Your Name: ");
                        String personCheckout = scanner.nextLine();

                        books[i].checkOut(personCheckout);
                        System.out.println("Thank you, " + personCheckout + ". You checked out " + books[i].getTitle());
                    }
                    else {
                        System.out.println("Not Available, Book is Currently Checked Out");
                    }

                }
            }
            if(found == false) {
                System.out.println("Book not Found. Please Enter Valid ID");
            }
        }


    }

}