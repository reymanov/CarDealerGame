package Mechanic;

import Car.Car;
import Car.Parts.Part;
import Player.Player;

public class Mechanic {
    public String name;
    public Double goodLuck;
    public Double badLuck;
    public Double repairPrice;

    public Mechanic(String name, Double goodLuck, Double badLuck, Double repairPrice) {
        this.name = name;
        this.goodLuck = goodLuck;
        this.badLuck = badLuck;
        this.repairPrice = repairPrice;
    }

    public void repairPart(Car car, Part part, Player owner) {

    }
}
