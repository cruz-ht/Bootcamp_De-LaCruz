package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public BigDecimal getValue() {
        int currentYear = LocalDate.now().getYear();
        var age = currentYear - year;

        BigDecimal priceBasedOffAge;
        BigDecimal originalCost = getOriginalCost();
        BigDecimal currentValue;

        if (age > 10) {
            currentValue = new BigDecimal("1000.00");

        } else {
            if (age <= 3) {
                priceBasedOffAge = new BigDecimal("0.03");
            } else if (age <= 6) {
                priceBasedOffAge = new BigDecimal("0.06");

            } else {
                priceBasedOffAge = new BigDecimal("0.08");

            }
            var percentLost = priceBasedOffAge.multiply(BigDecimal.valueOf(age));
            var percentToDollars = percentLost.multiply(originalCost);
            currentValue = originalCost.subtract(percentToDollars);
        }

        var milesRequired = 100000;

        if(odometer > milesRequired && !(makeModel.contains("Honda") || makeModel.contains("Toyota"))){

            var reductPercentage = 0.25;
            var reduction = currentValue.multiply(BigDecimal.valueOf(reductPercentage));
            currentValue = currentValue.subtract(reduction);
        }
        return currentValue;

    }
}