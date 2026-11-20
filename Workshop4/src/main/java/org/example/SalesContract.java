package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {
    //CONSTANTS for flat rate's, non changing values/fixed numbers
    private static final BigDecimal SALES_TAX_RATE = new BigDecimal("0.05");
    private static final BigDecimal RECORDING_FEE = new BigDecimal("100.00");
    private static final BigDecimal LOW_PROCESSING_FEE = new BigDecimal("295.00");
    private static final BigDecimal HIGH_PROCESSING_FEE = new BigDecimal("495.00");
    private static final BigDecimal PRICE_THRESHOLD = new BigDecimal("10000.00");


    //CONSTS FOR getMonthlyPayment()
    private static final BigDecimal HIGH_RATE = new BigDecimal("0.0425");
    private static final BigDecimal LOW_RATE = new BigDecimal("0.0525");
    private static final int HIGH_LOAN_MONTHS = 48;
    private static final int LOW_LOAN_MONTHS = 24;


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
        if (getVehicleSold().getPrice().compareTo(PRICE_THRESHOLD) < 0) {
            this.processingFee = LOW_PROCESSING_FEE;
        } else {
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
        return getVehicleSold().getPrice().add(salesTax).add(recordingFee).add(processingFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        int months;
        BigDecimal yearlyRate;

        if (!finance) {
            return BigDecimal.ZERO; //Built in 0 AKA no neew for "new Decimal..."
        }

        //ASSIGNING rate and months
        if (getVehicleSold().getPrice().compareTo(PRICE_THRESHOLD) < 0) {
            months = LOW_LOAN_MONTHS;
            yearlyRate = LOW_RATE;
        } else {
            months = HIGH_LOAN_MONTHS;
            yearlyRate = HIGH_RATE;
        }

        // 2 scale is best for dollar amount but 10 is best while calculating aka leave 2 for final results if used
        var monthlyRate = yearlyRate.divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);
        var growth = BigDecimal.ONE.add(monthlyRate).pow(months);
        //Full Equation
        var payment = getTotalPrice().multiply(monthlyRate).multiply(growth).divide(growth.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

        return payment;
    }
}