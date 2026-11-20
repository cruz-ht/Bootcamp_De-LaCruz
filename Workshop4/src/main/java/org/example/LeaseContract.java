package org.example;

import java.math.BigDecimal;

public class LeaseContract extends Contract {

    private static final BigDecimal ENDING_VALUE_RATE = new BigDecimal("0.50");
    private static final BigDecimal LEASE_FEE_RATE = new BigDecimal("0.07");
    private static final BigDecimal LEASE_INTEREST_RATE = new BigDecimal("0.04");
    private static final int LEASE_MONTHS = 36;

    private BigDecimal expectedEndingVal;
    private BigDecimal leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);




    }

}