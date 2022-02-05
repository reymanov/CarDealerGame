package Database;

import Customer.Customer;
import Factory.CustomersFactory;

import java.util.ArrayList;

public class CustomersDatabase {
    private static CustomersDatabase instance;
    private final CustomersFactory customersFactory;
    private final ArrayList<Customer> customers;

    private CustomersDatabase() {
        this.customers = new ArrayList<Customer>(10);
        this.customersFactory = new CustomersFactory();
    }

    public static CustomersDatabase getInstance() {
        if(instance == null) {
            instance = new CustomersDatabase();
        }
        return instance;
    }

    public void addCustomers(int numberOfCustomers) {
        for(int i = 0; i < numberOfCustomers; i++){
            this.customers.add(this.customersFactory.generateCustomer());
        }
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    };

    public void showCustomers() {
        if(this.customers.isEmpty()) {
            System.out.println("Customers database is empty.");

        }else {
            System.out.printf("%n");
            System.out.println("List of customers: ");
            this.customers.forEach((customer) -> System.out.println(this.customers.indexOf(customer) + "." + customer.toString()));
        }
    }
}
