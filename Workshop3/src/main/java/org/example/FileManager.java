package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Product> readProducts(){

        List<Product> productList = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            bufferedReader.readLine(); // reads the first line aka ignores the header when parsing data

            while((line = bufferedReader.readLine()) != null) {
                String[] brokenUpRow = line.split("\\|");

                String sku = brokenUpRow[0];
                String itemName = brokenUpRow[1];
                float price = Float.parseFloat(brokenUpRow[2]);
                String department = brokenUpRow[3];

                Product product = new Product(sku, itemName, price, department);

                productList.add(product);
            }
        } catch(IOException ex) {
            System.out.println("Could not read the file. check the file try again.");
        }
        catch (Exception ex) {
            System.out.println("Could not read data from the file. Check the format");
        }
        return productList;
    }
}
