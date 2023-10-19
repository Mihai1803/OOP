package HW3.problem2and3;

public class Truck extends Vehicle {

    public Truck(double basePrice, String name, String country) {
        super(basePrice, name, country);
    }

    @Override
    public double computeRoadTax() {
        return (5.0 / 100.0) * getBasePrice();
    }

}
