package Player;

import Car.Car;

import java.util.ArrayList;

public class Player {
    private static final int GARAGE_SIZE = 10;
    public String name;
    private Double cash;
    private ArrayList<Car> garage;

    public Player(String name, Double cash) {
        this.name = name;
        this.cash = cash;
        this.garage = new ArrayList<Car>(GARAGE_SIZE);
    }

    public void buyCar(Car car, Integer garagePlace) {
        if(car == null || this.cash < car.price) {
            System.out.println("Ups! It looks like I can't afford it");
        }
        else if (garage.size() == GARAGE_SIZE) {
            System.out.println("That garage place is already taken");
        }else {
            System.out.println("I just bought a new car!");
            this.cash -= car.price;
            garage.add(car);

        }
    }

    public void sellCar(Car car, Player buyer, Double price){
        if(buyer.cash < price) {
            System.out.println("Buyer don't have enough cash");
        }else if (!this.garage.contains(car)) {
            System.out.println("You don't own that car");
        }else {
            System.out.println("Transaction successful");
            this.cash += car.price;
        }
    }

    public Double getAccountStatus() {
        return this.cash;
    }
}
