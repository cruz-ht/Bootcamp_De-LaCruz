package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//import main palette
import static org.example.Main.*;

public class Ledger {
    public static void showLedger(List<Transaction> transactionList, Scanner scanner){

        //Comparator- A list can sort itself if you give it a rule for comparing two items.In this case,Sort the list by date, then by time for ties, then reverse it so the newest comes first.
        transactionList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime).reversed());

        String option = "";
        while(!option.equals("5")) {

            System.out.println(BOLD + HEADER + "\nACCOUNT LEDGER" + RESET);

            System.out.println("Review your account activity.");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);
            System.out.println(ACCENTS + "[1] " + RESET +"All Transactions");
            System.out.println(ACCENTS + "[2] " + RESET +"Deposits");
            System.out.println(ACCENTS + "[3] " + RESET +"Payments");
            System.out.println(ACCENTS + "[4] " + RESET +"Reports");
            System.out.println(ACCENTS + "[5] " + RESET +"Return to Main Menu");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);

            System.out.println(SUBTEXT + "Please Select an Option: " + RESET);
            option = scanner.nextLine();

            switch(option) {
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
                    }
                    catch (InterruptedException ex) {
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

        System.out.printf("|%s  %s| %-28s %-15s ...... $ %,.2f%n",transaction.getDate(), transaction.getTime().format(timeFormat), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
    }


    //LEDGER METHODS
    //DISPLAY ALL
    public static void displayAll(List<Transaction> transactionList){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "ALL TRANSACTIONS\n" + RESET);

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            printTransaction(transaction);
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }
    //DEPOSIT DISPLAY
     public static void displayDeposits(List<Transaction> transactionList){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "DEPOSIT HISTORY\n" + RESET);

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            if(transaction.getAmount() > 0){
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }
    //PAYMENT DISPLAY
    public static void displayPayments(List<Transaction> transactionList){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "PAYMENT HISTORY\n" + RESET);

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);
            if(transaction.getAmount() < 0){
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
                case "0":
                    System.out.println(HEADER + "\n Returning to Ledger Menu...\n\n" + RESET);
                    try {
                        Thread.sleep(300);
                    }
                    catch (InterruptedException ex) {
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
    public static void monthToDate(List<Transaction> transactionList){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "MONTH-TO-DATE REPORT\n" + RESET);

        LocalDate today = LocalDate.now();

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if(transaction.getDate().getYear() == today.getYear() && transaction.getDate().getMonthValue() == today.getMonthValue()){
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //PREV MONTH
    public static void previousMonth(List<Transaction> transactionList){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "PREVIOUS MONTH REPORT\n" + RESET);

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
    public static void yearToDate(List<Transaction> transactionList){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "YEAR-TO-DATE REPORT\n" + RESET);

        LocalDate today = LocalDate.now();

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if(transaction.getDate().getYear() == today.getYear()){
                printTransaction(transaction);
            }
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }

    //PREVIOUS YEAR
    public static void previousYear(List<Transaction> transactionList){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "PREVIOUS YEAR REPORT\n" + RESET);

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
    public static void vendorSearch(List<Transaction> transactionList, Scanner scanner){
        System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
        System.out.println(BOLD + "VENDOR TRANSACTION SEARCH\n" + RESET);

        System.out.println(SUBTEXT + "Please Enter the Vendor's Name: " + RESET);
        String userVendor = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if(userVendor.equalsIgnoreCase(transaction.getVendor())){
                printTransaction(transaction);
                found = true;
            }
        }
        if( found == false) {
            System.out.println(ERROR + "No account activity found for the selected vendor.\n\n" + RESET);
        }
        System.out.println(ACCENTS + "\n─────────────────────────────────────────────────────────────────\n" + RESET);
    }
}