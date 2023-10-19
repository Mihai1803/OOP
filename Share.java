package HW2;

public class Share {

    private final double value;
    private final Company company;

    public Share (double value, Company company) {
        this.value = value;
        this.company = company;
    }

    public double getValue () {
        return this.value;
    }


}
