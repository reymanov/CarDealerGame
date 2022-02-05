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

    private void increaseCarValue(Part part){
        double value;
        switch (part.name) {
            case "Breaks" -> value = 1.1;
            case "Suspension" -> value = 1.2;
            case "Engine" -> value = 2.0;
            case "Body", "Transmission" -> value = 1.5;
            default -> value = 1.0;
        }
        this.price *= value;
    }

    public void repairPart(Part part) {
        int partNumber = this.parts.indexOf(part);
        Part modifiedPart = this.parts.get(partNumber);

        modifiedPart.repair();
        this.parts.set(partNumber, modifiedPart);
        this.increaseCarValue(part);
    }
}
