package Car;

import Car.Parts.Part;

public class Raport {
    public Part part;
    public String mechanic;
    public Double price;

    public Raport(Part part, String mechanic, Double price) {
        this.part = part;
        this.mechanic = mechanic;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Raport{" +
                "part=" + part.name +
                ", mechanic=" + mechanic +
                ", price=" + price +
                '}';
    }
}
