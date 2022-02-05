package Factory;

import Car.Car;
import Car.Parts.Part;

import java.util.ArrayList;

public class CarsFactory {

    public CarsFactory() {
    }

    private int getRandomNumber(int max) {
        return (int) ((Math.random() * (max)) + 1);
    }

    private String generateBrand() {
        String brand;
        int value = this.getRandomNumber(4);
        switch (value) {
            case 1 -> brand = "BMW";
            case 2 -> brand = "Mercedes-Benz";
            case 3 -> brand = "Audi";
            case 4 -> brand = "Porsche";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return brand;
    }

    private String generateSegment() {
        String segment;
        int value = this.getRandomNumber(3);
        switch (value) {
            case 1 -> segment = "Budget";
            case 2 -> segment = "Standard";
            case 3 -> segment = "Premium";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return segment;
    }

    private String generateColor() {
        String color;
        int value = this.getRandomNumber(4);
        switch (value) {
            case 1 -> color = "Black";
            case 2 -> color = "Red";
            case 3 -> color = "White";
            case 4 -> color = "Grey";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return color;
    }

    private Integer generateMileage() {
        int mileage;
        int value = this.getRandomNumber(4);
        switch (value) {
            case 1 -> mileage = 0;
            case 2 -> mileage = 10000;
            case 3 -> mileage = 20000;
            case 4 -> mileage = 50000;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return mileage;
    }

    private Double generatePrice() {
        double price;
        int value = this.getRandomNumber(4);
        switch (value) {
            case 1 -> price = 50000.0;
            case 2 -> price = 75000.0;
            case 3 -> price = 100000.0;
            case 4 -> price = 250000.0;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return price;
    }

    private String generatePartName() {
        String partName;
        int value = this.getRandomNumber(5);
        switch (value) {
            case 1 -> partName = "Breaks";
            case 2 -> partName = "Suspension";
            case 3 -> partName = "Engine";
            case 4 -> partName = "Body";
            case 5 -> partName = "Transmission";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return partName;
    }

    private ArrayList<Part> generateParts(){
        int capacity = 5;
        ArrayList<Part> parts = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++){
            parts.add(new Part(this.generatePartName()));
        }
        return parts;
    }

    public Car generateCar(){
        String brand = this.generateBrand();
        String segment = this.generateSegment();
        String color = this.generateColor();
        Integer mileage = this.generateMileage();
        Double price = this.generatePrice();
        ArrayList<Part> parts = this.generateParts();

        return new Car(brand,segment,color,mileage,price,parts);
    }
}
