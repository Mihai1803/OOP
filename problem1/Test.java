package HW3.problem1;

import java.util.ArrayList;

public class Test {

    private final ArrayList<GeometricalForm> geometricalForms = new ArrayList<>();

    public Test() {}
    public void addGeometricalForm(GeometricalForm geometricalForm) {
        this.geometricalForms.add(geometricalForm);
    }

    public void runTests () {
        
    }
    public static void main (String[] args) {
        Test test = new Test();
        Rectangle rectangle = new Rectangle(10,10, 10, 10);
        Elipse elipse = new Elipse(10, 10, 10,10);

        test.addGeometricalForm(rectangle);
        test.addGeometricalForm(elipse);

        for (GeometricalForm geometricalForm : test.geometricalForms) {
            geometricalForm.changeFormColor("blue");
            geometricalForm.changeInnerColor("red");
        }

        for (GeometricalForm geometricalForm : test.geometricalForms) {
            System.out.println(geometricalForm.getFormColor() + " " + geometricalForm.getInnerColor());
        }
    }
}
