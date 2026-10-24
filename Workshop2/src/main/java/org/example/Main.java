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
        while (choice != 3) {
            System.out.println("\nWELCOME TO WAN SHI TONG'S LIBRARY ᓀ ᵥ ᓂ\n");
            System.out.println("Greetings, Seeker of Knowledge.");
            System.out.println("The Keeper of Ten Thousand things Welcomes You\n");
            System.out.println("Choose your Path and Discover what Knowledge awaits.\n");
            System.out.println("⋆☽ (1) Show Available Books");
            System.out.println("⋆☽ (2) Show Checked Out Books");
            System.out.println("⋆☽ (3) Depart the Library\n");
            System.out.print("Your Path: ");

            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                //check methods below Switch statements
                case 1:
                    showAvailableBooks(books, scanner);
                    break;

                case 2:
                    checkedOutList(books, scanner);
                    break;

                case 3:
                    System.out.println("Wan Shi Tong bids you farewell. Return when you seek wisdom again.");
                    System.exit(0);

                default:
                    System.out.println("This Path is Unknown, Please Try Again.");

            }
        }
    }


    //METHODS OUTSIDE OF BOOK CLASS AKA CASE1 AND 2.
    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        //LIST
        System.out.println("\nTHESE BOOKS AWAIT A WORTHY READER");
        System.out.println("⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔\n");
        for (int i = 0; i < books.length; i++) {

            if (books[i].isCheckedOut() == false) {
                System.out.println("TITLE: " + books[i].getTitle());
                System.out.println("ID: " + books[i].getId());
                System.out.println("ISBN: " + books[i].getIsBn());
                System.out.println("");
            }
        }
        //FOLLOW UP Q, OPTIONAL CHECKOUT OR RETURN
        System.out.println("What Knowledge do you Seek? Enter the ID of The Book you Wish to Borrow,\n or Enter (0) to Return to the Library Entrance: ");

        int checkOutId = scanner.nextInt();
        scanner.nextLine();

        if (checkOutId != 0) {

            for (int i = 0; i < books.length; i++) {

                if (books[i].getId() == checkOutId) {

                    if (books[i].isCheckedOut() == false) {
                        System.out.println("Please Provide Your Name for the Library's Borrowing Records: ");
                        String personCheckout = scanner.nextLine();

                        books[i].checkOut(personCheckout);
                        System.out.println("Knowledge awaits you, " + personCheckout + ". You have Borrowed: " + books[i].getTitle() + ". Treat this Book with Care.");
                    }
                    else {
                        System.out.println("This Book is Already in Another Seeker's Possession. Please Choose Another.");
                    }
                }
            }
        }
    }

    public static void checkedOutList(Book[] books, Scanner scanner) {
        //LIST
        System.out.println("\nTHESE SCROLLS ARE CURRENTLY IN THE HANDS OF OTHER SEEKERS");
        System.out.println("⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔\n");

        for (int i = 0; i < books.length; i++) {
            //shows only those marked as checked out
            if (books[i].isCheckedOut() == true) {
                System.out.println("Current seeker holding this Book: " + books[i].getCheckedOutTo());
                System.out.println("TITLE: " + books[i].getTitle());
                System.out.println("ID: " + books[i].getId());
                System.out.println("ISBN: " + books[i].getIsBn());
                System.out.println("");
            }
        }

        //PROMPT(C OR X)
        System.out.println("\nTHE KEEPER'S ARCHIVES");
        System.out.println("⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔⏔");
        System.out.println("What would you like to do next, seeker?\n");

        System.out.println("⋆☽ (C) Return a Book to the Library");
        System.out.println("⋆☽ (X) Return to the Library Entrance");
        System.out.print("\nChoose Your Path: ");

        String checkedOutAnswer= scanner.nextLine();

        if (checkedOutAnswer.equals("C")) {
            System.out.println("Enter the ID of the Book you Wish to Return to the Library, Seeker: ");
            int returnId = scanner.nextInt();
            scanner.nextLine();


            for (int i = 0; i < books.length; i++) {
                if (books[i].getId() == returnId) {
                    books[i].checkIn();
                    System.out.println("The Book has been returned to the Library. The keeper thanks you !\n");
                    System.out.println("Press Enter to return to the Library Entrance...");
                    scanner.nextLine();
                }
            }
        }
    }
}