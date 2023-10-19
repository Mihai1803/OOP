package HW3.problem2and3;

public class Bus  extends  Vehicle {

    public Bus(double basePrice, String name, String country) {
        super(basePrice, name, country);
    }

    @Override
    public double computeRoadTax() {
        return (4.0 / 100.0) * getBasePrice();
    }

}
