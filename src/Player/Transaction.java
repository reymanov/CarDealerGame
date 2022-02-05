package Player;

import Car.Car;

public class Transaction {
    public Car car;
    public String seller;
    public String buyer;
    public Double price;

    public Transaction(Car car, String seller, String buyer, Double price) {
        this.car = car;
        this.seller = seller;
        this.buyer = buyer;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "car=" + car.brand +
                ", seller='" + seller + '\'' +
                ", buyer='" + buyer + '\'' +
                ", price=" + price +
                '}';
    }
}
