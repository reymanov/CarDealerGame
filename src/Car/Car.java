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
    private final ArrayList<Raport> repairHistory;
    public Double totalWashCost;


    public Car(String brand, String segment, String color, int mileage, Double price, ArrayList<Part> parts) {
        this.brand = brand;
        this.segment = segment;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.parts = parts;
        this.repairHistory = new ArrayList<>();
        this.totalWashCost = 0.0;
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

    public void addRepairReport(Part part, String mechanic, Double price) {
        this.repairHistory.add(new Raport(part,mechanic,price));
    }

    public void showParts() {
            System.out.printf("%n");
            System.out.println("Parts: ");
            this.parts.forEach((part) -> System.out.println(this.parts.indexOf(part) + "." + part.toString()));
    }

    public void showRepairHistory() {
        if(this.repairHistory.isEmpty()){
            System.out.println("No repairs recorded");
        }else {
            System.out.printf("%n");
            System.out.println(this.brand + " - Recorded repairs");
            this.repairHistory.forEach((r) -> System.out.println(this.repairHistory.indexOf(r) + "." + r.toString()));
        }
    }

    public void showRepairAndWashCosts() {
       Double totalRepairPrice = 0.0;
       for(int i = 0; i < this.repairHistory.size(); i++) {
           totalRepairPrice += this.repairHistory.get(i).price;
       }
        System.out.printf("%n");
        System.out.println("Total repair & wash cost for " + this.brand + ": " + Double.sum(totalRepairPrice ,this.totalWashCost) + "$");
    }

}
