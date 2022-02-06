package Player;

import Car.Car;
import Customer.Customer;
import Database.CarsDatabase;
import Database.CustomersDatabase;

import java.util.ArrayList;

public class Player {
    private static final int GARAGE_SIZE = 10;
    public String name;
    public Double cash;
    private final ArrayList<Car> garage;
    private final ArrayList<Transaction> transactions;

    public Player(String name, Double cash) {
        this.name = name;
        this.cash = cash;
        this.garage = new ArrayList<>(GARAGE_SIZE);
        this.transactions = new ArrayList<>();
    }

    private void washAndPay(Car car) {
        double tax = car.price * 0.02;
        double washPrice = 120.0;
        System.out.printf("%n");
        System.out.println("'Car is now all clean'");
        this.cash -= washPrice;
        car.totalWashCost += washPrice;
        System.out.println("2% Tax has been payed, payed:" + tax + "$");
        this.cash -= tax;
    }

    private Boolean checkIfCustomerIsInterested(Car car, Customer customer){
        boolean isCarFullyRepaired = true;
       for(int i = 0; i < car.parts.size(); i++) {
           if(!car.parts.get(i).isOperational){
               isCarFullyRepaired = false;
               break;
           }
       }
       if(!isCarFullyRepaired && !customer.acceptDamaged) {
           System.out.println(customer.name + " won't buy broken car");
           return false;
       }else if (!customer.favouriteBrands.contains(car.brand)) {
           System.out.println(customer.name + " won't buy " + car.brand + " brand");
           return false;
       }else {
           return true;
       }
    }

    public void buyCar(CarsDatabase seller, Car car) {
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
            this.washAndPay(car);
            this.noteTransaction(car, seller.name, this.name, car.price);
        }
    }

    public void sellCar(Car car, Customer customer, CustomersDatabase customersDatabase, Double price){
        System.out.printf("%n");
        if(!checkIfCustomerIsInterested(car,customer)) {
        }else if(customer.cash < price) {
            System.out.println("Customer doesn't have enough cash");
        }else if (!this.garage.contains(car)) {
            System.out.println("I don't own that car, I cannot sell it");
        }else {
            System.out.println("Transaction successful!");
            System.out.println(car.brand + " has been sold to " + customer.name);
            this.washAndPay(car);
            customer.cash -= price;
            this.cash += price;
            this.garage.remove(car);

            this.noteTransaction(car, this.name, customer.name, price);
            customersDatabase.addCustomers(2);
        }
    }

   public ArrayList<Car> getGarage() {
        if(this.garage.isEmpty()) {
            System.out.println("Garage is empty, nothing to look at ...");
        }else {
            return this.garage;
        }

       return null;
   }

   public void showGarage() {
       if(this.garage.isEmpty()) {
           System.out.println("Garage is empty, nothing to look at ...");

       }else {
           System.out.printf("%n");
           System.out.println("Your garage: ");
           this.garage.forEach((car) -> System.out.println(this.garage.indexOf(car) + "." + car.toString()));
       }
   }

   public Car getCar(int carNumber) {
       if(this.garage.isEmpty()) {
           System.out.println("Garage is empty, nothing to look at ...");
           return null;
       }else {
          return this.garage.get(carNumber);
       }
   }

   public void checkAccount() {
       System.out.println("Available Cash: " + this.cash + "$");
   }

   public void advertiseInNewspaper(CustomersDatabase customersDatabase) {
       System.out.printf("%n");
       System.out.println("Advertisement posted in local newspaper");
        this.cash -= 2000.0;
        customersDatabase.addCustomers((int) ((Math.random() * (3)) + 1));
   }

    public void advertiseOnline(CustomersDatabase customersDatabase) {
        System.out.printf("%n");
        System.out.println("Advertisement posted online");
        this.cash -= 1000.0;
        customersDatabase.addCustomers(1);
    }

    private void noteTransaction(Car car, String seller, String buyer, Double price){
        this.transactions.add(new Transaction(car, seller, buyer,price));
    }

    public void showTransactions() {
        if(this.transactions.isEmpty()){
            System.out.println("No transactions recorded");
        }else {
            System.out.printf("%n");
            System.out.println("Your transactions");
              this.transactions.forEach((t) -> System.out.println(this.transactions.indexOf(t) + "." + t.toString()));
        }
    }

    public void showSpendingsForAllCars() {
        this.getGarage().forEach(car -> car.showRepairAndWashCosts());
    }
}
