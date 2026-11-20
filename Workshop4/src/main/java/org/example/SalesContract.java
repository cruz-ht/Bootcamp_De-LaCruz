package org.example;
import java.math.BigDecimal;

public class SalesContract extends Contract{
    //CONSTANTS for flat rate's, non changing values/fixed numbers
    private static final BigDecimal SALES_TAX_RATE = new BigDecimal("0.05");
    private static final BigDecimal RECORDING_FEE = new BigDecimal("100.00");
    private static final BigDecimal LOW_PROCESSING_FEE = new BigDecimal("295.00");
    private static final BigDecimal HIGH_PROCESSING_FEE = new BigDecimal("495.00");
    private static final BigDecimal PRICE_THRESHOLD = new BigDecimal("10000.00");

    private BigDecimal salesTax;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
        this.recordingFee = RECORDING_FEE;
        this.salesTax = getVehicleSold().getPrice().multiply(SALES_TAX_RATE);

        //PROCESSING FEE W High & Low Fees
        if(getVehicleSold().getPrice().compareTo(PRICE_THRESHOLD)< 0){
            this.processingFee = LOW_PROCESSING_FEE;
        }
        else{
            this.processingFee = HIGH_PROCESSING_FEE;
        }
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }
    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }
    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getRecordingFee() {
        return recordingFee;
    }
    public void setRecordingFee(BigDecimal recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinance() {
        return finance;
    }
    public void setFinance(boolean finance) {
        this.finance = finance;
    }



    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        return null;
    }
}