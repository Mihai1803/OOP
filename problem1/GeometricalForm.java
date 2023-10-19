package HW3.problem1;

public class GeometricalForm implements FormOperations {

    private int xCoord;
    private int yCoord;
    private String iColor;
    private String fColor;

    public GeometricalForm(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    @Override
    public void move (int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }
    @Override
    public void changeInnerColor (String color) {
        this.iColor = color;
    }
    @Override
    public void changeFormColor (String color) {
        this.fColor = color;
    }
    @Override
    public void shrink () {}
    @Override
    public void enlarge () {}

    public int getXCoordinate () {
        return this.xCoord;
    }
    public int getYCoordinate() {
        return this.yCoord;
    }
    public String getInnerColor() {
        return this.iColor;
    }
    public String getFormColor() {
        return this.fColor;
    }

}
