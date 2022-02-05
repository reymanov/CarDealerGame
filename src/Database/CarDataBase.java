package Database;

import Car.Car;
import Factory.CarsFactory;
import Player.Player;

import java.util.ArrayList;

public class CarDataBase {
    private static CarDataBase instance;
    private final CarsFactory carsFactory;
    private final ArrayList<Car> cars;

    private CarDataBase() {
        this.cars = new ArrayList<>(10);
        this.carsFactory = new CarsFactory();
    }

    public static CarDataBase getInstance() {
        if(instance == null) {
            instance = new CarDataBase();
        }
        return instance;
    }

    public ArrayList<Car> getCars() {
        return this.cars;
    }

    public Car buyCar(int carNumber, Player buyer) {
        Car carToBuy = cars.get(carNumber);
        if(buyer.getAccountStatus() >= cars.get(carNumber).price) {
            System.out.println("Dealer: We can sell you this car");
            cars.remove(carNumber);
        }
        else {
            System.out.println("Dealer: Come back when You will have more money");
            return null;
        }
        return carToBuy;
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

    public void clearDatabase(){
        this.cars.clear();
    }
}
