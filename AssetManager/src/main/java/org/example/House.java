package org.example;

import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;


    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }


    @Override
    public BigDecimal getValue(){

        BigDecimal lotPrice = new BigDecimal("0.25");
        BigDecimal pricePerSqFt;

        switch(condition) {
            case 1:
                pricePerSqFt = new BigDecimal("180.00");

                break;
            case 2:
                pricePerSqFt = new BigDecimal("130.00");
                break;
            case 3:
                pricePerSqFt = new BigDecimal("90.00");
                break;
            case 4:
                pricePerSqFt = new BigDecimal("80.00");
                break;
            default:
                throw new IllegalArgumentException("Invalid condition: " + condition);
        }

        var houseValue = pricePerSqFt.multiply(BigDecimal.valueOf(squareFoot));
        var lotValue = lotPrice.multiply(BigDecimal.valueOf(lotSize));

        var currentCost = houseValue.add(lotValue);
        return currentCost;
    }
}