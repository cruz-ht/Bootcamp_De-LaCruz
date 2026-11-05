package org.example;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//import main palette
import static org.example.Main.*;

public class Ledger {
    public static void showLedger(List<Transaction> transactionList, Scanner scanner) {

        //Comparator- A list can sort itself if you give it a rule for comparing two items.In this case,Sort the list by date, then by time for ties, then reverse it so the newest comes first.
        transactionList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime).reversed());

        String option = "";
        while (!option.equals("5")) {

            System.out.println(BOLD + HEADER + "\nACCOUNT LEDGER" + RESET);

            System.out.println("Review your Account Activity");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);
            System.out.println(ACCENTS + "[1] " + RESET + "All Transactions");
            System.out.println(ACCENTS + "[2] " + RESET + "Deposits");
            System.out.println(ACCENTS + "[3] " + RESET + "Payments");
            System.out.println(ACCENTS + "[4] " + RESET + "Reports");
            System.out.println(ACCENTS + "[5] " + RESET + "Return to Main Menu");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);

            System.out.println(SUBTEXT + "Please Select an Option to Continue: " + RESET);
            option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    displayAll(transactionList);
                    break;
                case "2":
                    displayDeposits(transactionList);
                    break;
                case "3":
                    displayPayments(transactionList);
                    break;
                case "4":
                    showReports(transactionList, scanner);
                    break;
                case "5":
                    System.out.println(HEADER + "\n Returning to Main Menu...\n\n" + RESET);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        System.out.println("Loading interrupted.");
                    }
                    break;

                default:
                    System.out.println(ERROR + "INVALID SELECTION" + RESET);
                    System.out.println(ERROR + "Please enter a Valid Menu Option.\n\n" + RESET);
            }
        }
    }

    //MINI METHOD-FORMATTING LINES
    public static void printTransaction(Transaction transaction) {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.printf("|%s  %s| %-28s %-15s ...... $ %,.2f%n", transaction.getDate(), transaction.getTime().format(timeFormat), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
    }


    //LEDGER METHODS
    //DISPLAY ALL
    public static void displayAll(List<Transaction> transactionList) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "ALL TRANSACTIONS\n" + RESET);
        System.out.println(SUBTEXT + "Account Activity • Newest to Oldest\n" + RESET);


        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            printTransaction(transaction);
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //DEPOSIT DISPLAY
    public static void displayDeposits(List<Transaction> transactionList) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "DEPOSIT HISTORY\n" + RESET);
        System.out.println(SUBTEXT + "Deposit Activity • Newest to Oldest\n" + RESET);


        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            if (transaction.getAmount() > 0) {
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //PAYMENT DISPLAY
    public static void displayPayments(List<Transaction> transactionList) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "PAYMENT HISTORY\n" + RESET);
        System.out.println(SUBTEXT + "Payment Activity • Newest to Oldest\n" + RESET);


        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            if (transaction.getAmount() < 0) {
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }


    //REPORT METHODS + MINI WHILE MENU
    public static void showReports(List<Transaction> transactionList, Scanner scanner) {

        String option = "";
        while (!option.equals("0")) {

            System.out.println(BOLD + HEADER + "\nACCOUNT REPORTS" + RESET);

            System.out.println("Select a reporting period");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);
            System.out.println(ACCENTS + "[1] " + RESET + "Month to Date");
            System.out.println(ACCENTS + "[2] " + RESET + "Previous Month");
            System.out.println(ACCENTS + "[3] " + RESET + "Year to Date");
            System.out.println(ACCENTS + "[4] " + RESET + "Previous Year");
            System.out.println(ACCENTS + "[5] " + RESET + "Search by Vendor");
            System.out.println(ACCENTS + "[6] " + RESET + "Custom Search");

            System.out.println(ACCENTS + "[0] " + RESET + "Return to Ledger Menu");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);

            System.out.println(SUBTEXT + "Please Select an Option: " + RESET);
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    monthToDate(transactionList);
                    break;
                case "2":
                    previousMonth(transactionList);
                    break;
                case "3":
                    yearToDate(transactionList);
                    break;
                case "4":
                    previousYear(transactionList);
                    break;
                case "5":
                    vendorSearch(transactionList, scanner);
                    break;
                case "6":
                    customSearch(transactionList, scanner);
                    break;
                case "0":
                    System.out.println(HEADER + "\n Returning to Ledger Menu...\n\n" + RESET);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        System.out.println("Loading interrupted.");
                    }
                    break;
                default:
                    System.out.println(ERROR + "INVALID SELECTION" + RESET);
                    System.out.println(ERROR + "Please enter a Valid Menu Option.\n\n" + RESET);
            }
        }
    }

    //MONTH TO DATE
    public static void monthToDate(List<Transaction> transactionList) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "MONTH-TO-DATE REPORT\n" + RESET);
        System.out.println(SUBTEXT + "Month-to-Date Activity • Newest to Oldest\n" + RESET);

        LocalDate today = LocalDate.now();

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if (transaction.getDate().getYear() == today.getYear() && transaction.getDate().getMonthValue() == today.getMonthValue()) {
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //PREV MONTH
    public static void previousMonth(List<Transaction> transactionList) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "PREVIOUS MONTH REPORT\n" + RESET);
        System.out.println(SUBTEXT + "Previous Month Activity • Newest to Oldest\n" + RESET);

        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if (transaction.getDate().getYear() == lastMonth.getYear() && transaction.getDate().getMonthValue() == lastMonth.getMonthValue()) {
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //YEAR TO DATE
    public static void yearToDate(List<Transaction> transactionList) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "YEAR-TO-DATE REPORT\n" + RESET);
        System.out.println(SUBTEXT + "Year-to-Date Activity • Newest to Oldest\n" + RESET);

        LocalDate today = LocalDate.now();

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if (transaction.getDate().getYear() == today.getYear()) {
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //PREVIOUS YEAR
    public static void previousYear(List<Transaction> transactionList) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "PREVIOUS YEAR REPORT\n" + RESET);
        System.out.println(SUBTEXT + "Previous Year Activity • Newest to Oldest\n" + RESET);

        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.minusYears(1);

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if (transaction.getDate().getYear() == lastYear.getYear()) {
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //SEARCH BY VENDOR
    public static void vendorSearch(List<Transaction> transactionList, Scanner scanner) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "VENDOR TRANSACTION SEARCH\n" + RESET);
        System.out.println(SUBTEXT + "Vendor Activity • Newest to Oldest\n" + RESET);

        String userVendor = getValidInput(scanner, "Please Enter the Vendor's Name: ", 2);

        boolean found = false;

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if (userVendor.equalsIgnoreCase(transaction.getVendor())) {
                printTransaction(transaction);
                found = true;
            }
        }
        if (found == false) {
            System.out.println(ERROR + "No account activity found for the selected vendor.\n\n" + RESET);
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //CUSTOM SEARCH
    public static void customSearch(List<Transaction> transactionList, Scanner scanner) {
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "CUSTOM SEARCH" + RESET);
        System.out.println(SUBTEXT + "Account Activity • Newest to Oldest\n" + RESET);
        System.out.println("Press Enter to skip any field." + RESET);

        //HELPERS-INIT VAR
        LocalDate startDate = getOptionalDate(scanner, "Start Date (YYYY-MM-DD): ");
        LocalDate endDate = getOptionalDate(scanner, "End Date (YYYY-MM-DD): ");

        System.out.println(SUBTEXT + "Description: " + RESET);
        String description = scanner.nextLine().trim();

        System.out.println(SUBTEXT + "Vendor: " + RESET);
        String vendor = scanner.nextLine().trim();

        Double amount = getOptionalAmount(scanner, "Amount (Excluding $): ");

        boolean found = false;

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            boolean matches = true;

            // START DATE FILTER
            if (startDate != null && transaction.getDate().isBefore(startDate)) {
                matches = false;
            }
            // END DATE
            if (endDate != null && transaction.getDate().isAfter(endDate)) {
                matches = false;
            }
            // DESCRIPTION
            if (!description.isEmpty() && !transaction.getDescription().toLowerCase().contains(description.toLowerCase())) {
                matches = false;
            }
            // VENDOR
            if (!vendor.isEmpty() && !vendor.equalsIgnoreCase(transaction.getVendor())) {
                matches = false;
            }
            // AMOUNT
            if (amount != null && Math.abs(Math.abs(transaction.getAmount()) - amount) > 0.001) {
                matches = false;
            }
            if (matches) {
                printTransaction(transaction);
                found = true;
            }
        }
        if (found == false) {
            System.out.println(ERROR + "\nNo Transactions match your Search Criteria\n\n" + RESET);
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //HELPER - optional date (returns null if skipped)
    public static LocalDate getOptionalDate(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(SUBTEXT + prompt + RESET);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return null;
            }
            try {
                return LocalDate.parse(input);
            }
            catch (DateTimeParseException ex) {
                System.out.println(ERROR + "INVALID DATE" + RESET);
                System.out.println(ERROR + "Reason: Please use the format YYYY-MM-DD, or press Enter to skip.\n" + RESET);
            }
        }
    }

    //HELPER - optional amount (returns null if skipped)
    public static Double getOptionalAmount(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(SUBTEXT + prompt + RESET);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return null;
            }
            try {
                return Math.abs(Double.parseDouble(input));
            }
            catch (NumberFormatException ex) {
                System.out.println(ERROR + "INVALID AMOUNT" + RESET);
                System.out.println(ERROR + "Reason: Please enter a number, or press Enter to skip.\n" + RESET);
            }
        }
    }
}