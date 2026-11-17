package org.example;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Asset> assets = new ArrayList<>();

        assets.add((new House("my house", "2015-09-12", new BigDecimal("250000"), "45 Maple Rd", 1, 2000, 8000)));
        assets.add((new House("Vacay house", "2020-03-01", new BigDecimal("180000"), "12 Beach Ave", 3, 1200, 5000)));

        assets.add(new Vehicle("Chev", "2012-05-10", new BigDecimal("15000"),
                "Chevy Malibu", 2012, 160000));
        assets.add(new Vehicle("Van", "2020-02-02", new BigDecimal("28000"),
                "Dodge Caravan", 2020, 110000));


    }
}