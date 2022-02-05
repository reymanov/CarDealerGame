package Car.Parts;

public class Part implements Repairable {
    public String name;
    public Boolean isOperational;

    public Part(String name) {
        this.name = name;
        this.isOperational = Math.random() < 0.5;
    }

    @Override
    public void repair() {

    }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", isOperational=" + isOperational +
                '}';
    }
}
