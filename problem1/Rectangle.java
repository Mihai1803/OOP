package HW3.problem1;

public class Rectangle extends GeometricalForm {
    private final int width;
    private final int height;

    public Rectangle (int xCoord, int yCoord, int width, int height) {
        super(xCoord, yCoord);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
}
