package HW3.problem2and3;

public class Minibus extends Vehicle {

    public Minibus(double basePrice, String name, String country) {
        super(basePrice, name, country);
    }

    @Override
    public double computeRoadTax() {
        return (3.0 / 100.0) * getBasePrice();
    }

}
