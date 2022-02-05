package Customer;

import java.util.ArrayList;

public class Customer {
    public String name;
    public Double cash;
    public ArrayList<String> favouriteBrands;
    public Boolean acceptDamaged;

    public Customer(String name, Double cash, ArrayList<String> favouriteBrands, Boolean acceptDamaged) {
        this.name = name;
        this.cash = cash;
        this.favouriteBrands = new ArrayList<>(favouriteBrands);
        this.acceptDamaged = acceptDamaged;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", favouriteBrands=" + favouriteBrands +
                ", acceptDamaged=" + acceptDamaged +
                '}';
    }
}
