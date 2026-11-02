package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Transaction> readItems(){
        List<Transaction> transactionList = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("src/main/resources/Transaction.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();   // skips header

            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] brokenUpRow = line.split("\\|");

                LocalDate date = LocalDate.parse(brokenUpRow[0]);
                LocalTime time = LocalTime.parse(brokenUpRow[1]);
                String description = brokenUpRow[2];
                String vendor = brokenUpRow[3];
                double amount = Double.parseDouble(brokenUpRow[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);

                transactionList.add(transaction);
            }
        }
        catch(IOException ex){
            System.out.println("Could not read the file. check the file try again.");
        }
        catch(Exception ex){
            System.out.println("Could not read data from the file. Check the format");
        }
        return transactionList;
    }

    public static void writeTransaction(Transaction transaction) {
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/Transaction.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

            String line = String.format("%s|%s|%s|%s|%.2f", transaction.getDate(), transaction.getTime().format(timeFormat), transaction.getDescription(), transaction.getVendor(),transaction.getAmount());

            bufferedWriter.newLine();
            bufferedWriter.write(line);
            bufferedWriter.close();

        }
        catch(IOException ex){
            System.out.println("Could not write to the file.");
        }
        catch(Exception ex){
            System.out.println("Error when handling the data.");
        }
    }
}

