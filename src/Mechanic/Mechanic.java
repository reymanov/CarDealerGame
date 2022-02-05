package Mechanic;

import Car.Car;
import Car.Parts.Part;
import Player.Player;

public class Mechanic {
    public String name;
    public Double luck;
    public Double costMultiplier;

    public Mechanic(String name, Double luck, Double costMultiplier) {
        this.name = name;
        this.luck = luck;
        this.costMultiplier = costMultiplier;
    }

    public Double calculateRepairCost(String carBrand, Part part) {
        double cost;
        double brandMultiplier;
        switch (part.name){
            case "Breaks" -> cost = 200.0;
            case "Suspension" -> cost = 1000.0;
            case "Engine" -> cost = 2000.0;
            case "Body" -> cost = 500.0;
            case "Transmission" -> cost = 800.0;
            default -> throw new IllegalStateException("Part not recognized");
        }
        switch (carBrand) {
            case "BMW" -> brandMultiplier = 1.4;
            case "Mercedes-Benz" -> brandMultiplier = 1.2;
            case "Audi" -> brandMultiplier = 1.3;
            case "Porsche" -> brandMultiplier = 1.5;
            default -> throw new IllegalStateException("Car brand not recognized");
        }
        return cost * brandMultiplier * this.costMultiplier;
    }

    private Boolean isLuckyEnough() {
        int randomNumber = (int) ((Math.random() * (10)) + 1);
        return randomNumber <= this.luck * 10;

    }

    private Boolean checkIfCanBeRepaired(Car car, Part part, Player owner, Double repairCost) {
        if(part.isOperational) {
            System.out.println("This part is operational, nothing to fix here");
            return false;
        }else if(!owner.getGarage().contains(car)){
            System.out.println("Mechanic " + this.name + ": You don't own that car");
            return false;
        }else if (!car.parts.contains(part)){
            System.out.println("Mechanic " + this.name + ": This car doesn't have such a part");
            return false;
        }else if (owner.cash < repairCost) {
            System.out.println("Mechanic " + this.name + ": You cannot afford this repair");
            return false;
        }else if(!this.isLuckyEnough()) {
            System.out.println("Mechanic " + this.name + ": I have a bad day, I can't repair it");
            return false;
        }else {
            return true;
        }
    }

    public void repairPart(Car car, Part part, Player owner) {
        Double repairCost = this.calculateRepairCost(car.brand, part);
        if(this.checkIfCanBeRepaired(car, part, owner, repairCost)) {
            System.out.println("Part repaired");
            car.repairPart(part);
            owner.cash -= repairCost;
        }
    }
}
