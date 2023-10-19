package HW3.problem2and3;

import java.util.*;

public class Test {

    public void printTest(Vehicle vehicle) {
        String type = (vehicle instanceof Truck) ? "Truck" :
                      (vehicle instanceof Bus) ? "Bus" :
                      "Minibus";

        System.out.println(type);
        System.out.println(vehicle.getName());
        System.out.println(vehicle.getCountry());
        System.out.println(vehicle.getBasePrice());
        System.out.println(vehicle.computeTotalTax());
        System.out.println();
    }

    public static void main(String[] args) {

        Test test = new Test();

        Truck truck = new Truck(100,"truckName", "romania");
        Bus bus = new Bus(200, "busName", "france");
        Minibus minibus = new Minibus(300, "minibusName", "germany");

        test.printTest(truck);
        test.printTest(bus);
        test.printTest(minibus);


        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(truck);
        vehicles.add(bus);
        vehicles.add(minibus);

        Collections.sort(vehicles);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getName());
        }

    }
}
