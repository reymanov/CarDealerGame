package Player;

import Car.Car;
import Dealer.Dealer;

import java.util.ArrayList;

public class Player {
    private static final int GARAGE_SIZE = 10;
    public String name;
    public Double cash;
    private ArrayList<Car> garage;

    public Player(String name, Double cash) {
        this.name = name;
        this.cash = cash;
        this.garage = new ArrayList<Car>(GARAGE_SIZE);
    }

    public void buyCar(Dealer seller, Car car) {
        if(this.cash < car.price) {
            System.out.println("Ups! It looks like I can't afford it");
        }else if (!seller.getCars().contains(car)){
            System.out.println("This seller doesn't have that car");
        }else if (garage.size() == GARAGE_SIZE ) {
            System.out.println("That garage place is already taken");
        }else {
            System.out.println("I just bought a new car!");
            this.cash -= car.price;
            seller.clearSpot(car);
            garage.add(car);

        }
    }

//    public void sellCar(Car car, Player buyer, Double price){
//        if(buyer.cash < price) {
//            System.out.println("Buyer don't have enough cash");
//        }else if (!this.garage.contains(car)) {
//            System.out.println("You don't own that car");
//        }else {
//            System.out.println("Transaction successful");
//            this.cash += car.price;
//        }
//    }

   public ArrayList<Car> getGarage() {
       return this.garage;
   }

   public Car getCar(int carNumber) {
        return this.getGarage().get(carNumber);
   }

}
