package Dealer;

import Car.Car;
import Factory.CarsFactory;


import java.util.ArrayList;

public class Dealer {
    private static Dealer instance;
    private final CarsFactory carsFactory;
    private final ArrayList<Car> cars;

    private Dealer() {
        this.cars = new ArrayList<>(10);
        this.carsFactory = new CarsFactory();
    }

    public static Dealer getInstance() {
        if(instance == null) {
            instance = new Dealer();
        }
        return instance;
    }

    public ArrayList<Car> getCars() {
        return this.cars;
    }

    public void displayCars() {
        if(this.cars.isEmpty()) {
            System.out.println("Dealer: Car database is empty.");
        }
        this.cars.forEach((car) -> System.out.println(car.toString()));
    }

    public void restockDatabase(int numberOfCars){
        for(int i = 0; i < numberOfCars; i++){
            this.cars.add(this.carsFactory.generateCar());
        }
    }

    public void clearSpot(Car car){
        this.cars.remove(car);
    }
}
