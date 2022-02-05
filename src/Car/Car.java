package Car;

import Car.Parts.Part;

import java.util.ArrayList;

public class Car {
    public String brand;
    public String segment;
    public String color;
    public int mileage;
    public Double price;
    public ArrayList<Part> parts;


    public Car(String brand, String segment, String color, int mileage, Double price, ArrayList<Part> parts) {
        this.brand = brand;
        this.segment = segment;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.parts = parts;

    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", segment='" + segment + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", parts=" + parts +
                '}';
    }
}
