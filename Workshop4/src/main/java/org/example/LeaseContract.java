package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract {

    private static final BigDecimal ENDING_VALUE_RATE = new BigDecimal("0.50");
    private static final BigDecimal LEASE_FEE_RATE = new BigDecimal("0.07");
    private static final BigDecimal LEASE_INTEREST_RATE = new BigDecimal("0.04");
    private static final int LEASE_MONTHS = 36;

    private BigDecimal expectedEndingVal;
    private BigDecimal leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);

        this.expectedEndingVal = getVehicleSold().getPrice().multiply(ENDING_VALUE_RATE);
        this.leaseFee = getVehicleSold().getPrice().multiply(LEASE_FEE_RATE);
    }

    public BigDecimal getExpectedEndingVal() {
        return expectedEndingVal;
    }

    public void setExpectedEndingVal(BigDecimal expectedEndingVal) {
        this.expectedEndingVal = expectedEndingVal;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }


    @Override
    public BigDecimal getTotalPrice() {

        return getExpectedEndingVal().add(leaseFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        var monthlyRate = LEASE_INTEREST_RATE.divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);
        var growth = BigDecimal.ONE.add(monthlyRate).pow(LEASE_MONTHS);

        var payment = getTotalPrice().multiply(monthlyRate).multiply(growth).divide(growth.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
        return payment;
    }
}