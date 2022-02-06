package Factory;

import Customer.Customer;

import java.util.ArrayList;


public class CustomersFactory {
    public CustomersFactory(){}

    private int getRandomNumber(int max) {
        return (int) ((Math.random() * (max)) + 1);
    }

    private String generateName() {
        String name;
        int value = this.getRandomNumber(8);
        switch (value) {
            case 1 -> name = "Steve";
            case 2 -> name = "Kate";
            case 3 -> name = "Mike";
            case 4 -> name = "John";
            case 5 -> name = "Sasha";
            case 6 -> name = "Tom";
            case 7 -> name = "Yoko";
            case 8 -> name = "James";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return name;
    }

    private Double generateCash() {
        double cash;
        int value = this.getRandomNumber(4);
        switch (value) {
            case 1 -> cash = 40000.0;
            case 2 -> cash = 50000.0;
            case 3 -> cash = 100000.0;
            case 4 -> cash = 200000.0;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return cash;
    }
    private ArrayList<String> generateFavouriteBrands() {
        ArrayList<String> favBrands = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            String brand;
            int value = this.getRandomNumber(4);
            switch (value) {
                case 1 -> brand = "BMW";
                case 2 -> brand = "Mercedes-Benz";
                case 3 -> brand = "Audi";
                case 4 -> brand = "Porsche";
                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
            if(!favBrands.contains(brand)) {
                favBrands.add(brand);
            }else {
                i -= 1 ;
            }
        }
        return favBrands;
    }

    private Boolean generateAcceptDamaged() {
        boolean acceptDamaged;
        int value = this.getRandomNumber(2);
        switch (value) {
            case 1 -> acceptDamaged = true;
            case 2 -> acceptDamaged = false;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return acceptDamaged;
    }

    public Customer generateCustomer() {
        String name = this.generateName();
        Double cash = this.generateCash();
        ArrayList<String> favBrands = this.generateFavouriteBrands();
        Boolean acceptDamaged = this.generateAcceptDamaged();
        return new Customer(name, cash, favBrands, acceptDamaged);
    }
}
