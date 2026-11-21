package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/contracts.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            var vehicle = contract.getVehicleSold();

            String sharedLine = String.format("%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f", contract.getDate(), contract.getCustomerName(), contract.getCustomerEmail(), vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());





            if(contract instanceof SalesContract sales){

                //revised format for boolean, displays Yes/No
                String financeRevised;
                if(sales.isFinance()){
                    financeRevised = "Yes";

                    String salesLine = "SALE |" + sharedLine + "|" + String.format("%.2f|%.2f|%.2f|%.2f|%s|%.2f", sales.getSalesTax(), sales.getRecordingFee(), sales.getProcessingFee(),sales.getTotalPrice(), financeRevised, sales.getMonthlyPayment());

                    bufferedWriter.newLine();
                    bufferedWriter.write(salesLine);
                }
                else{
                    financeRevised = "No";
                }



                
            }
            else if (contract instanceof LeaseContract lease) {
                
            }


            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Could not save the file.");
        }
    }
}
