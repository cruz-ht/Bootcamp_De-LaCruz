package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/contracts.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Could not save the file.");
        }
    }
}
