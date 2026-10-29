package org.example;

public class Product {

    private String sku;
    private String itemName;
    private float price;
    private String department;

    public Product(String sku, String itemName, float price, String department) {
        this.sku = sku;
        this.itemName = itemName;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

}
