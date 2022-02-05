package Database;

import Car.Car;
import Factory.CarsFactory;

import java.util.ArrayList;

public class CarsDatabase {
    private static CarsDatabase instance;
    private final CarsFactory carsFactory;
    private final ArrayList<Car> cars;

    private CarsDatabase() {
        this.cars = new ArrayList<>(10);
        this.carsFactory = new CarsFactory();
    }

    public static CarsDatabase getInstance() {
        if(instance == null) {
            instance = new CarsDatabase();
        }
        return instance;
    }

    public ArrayList<Car> getCars() {
        return this.cars;
    }

    public void showCars() {
        if(this.cars.isEmpty()) {
            System.out.println("Dealer: Car database is empty.");

        }else {
            System.out.printf("%n");
            System.out.println("Available cars: ");
            this.cars.forEach((car) -> System.out.println(this.cars.indexOf(car) + "." + car.toString()));
        }

    }

    public void restockDatabase(int numberOfCars){
        for(int i = 0; i < numberOfCars; i++){
            this.cars.add(this.carsFactory.generateCar());
        }
    }

    public void clearSpot(Car car){
        this.cars.remove(car);
        this.restockDatabase(1);
    }
}
