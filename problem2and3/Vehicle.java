package HW3.problem2and3;

public abstract class Vehicle implements Taxable, Comparable<Vehicle> {

    private final double basePrice;
    private final String name;
    private final String country;

    public Vehicle(double basePrice, String name, String country) {
        this.basePrice = basePrice;
        this.name = name;
        this.country = country;
    }

    @Override
    public double computeVAT() {
        return (19.0 / 100.0) * this.basePrice;
    }
    @Override
    public double computeCustomTax() {
        return !this.country.equals("romania") ? (10.0 / 100.0) * this.basePrice : 0.0;
    }
    @Override
    public abstract double computeRoadTax();
    @Override
    public double computeTotalTax() {
        double totalTax;
        totalTax = computeVAT() + computeRoadTax()+ computeCustomTax();
        return  totalTax;
    }

    @Override
    public int compareTo(Vehicle o) {
        if (this.computeTotalTax() == o.computeTotalTax()) {
            return  Double.compare(this.basePrice, o.getBasePrice());
        } else {
            return Double.compare(this.computeTotalTax(), o.computeTotalTax());
        }
    }

    public double getBasePrice() {
        return basePrice;
    }
    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
}
