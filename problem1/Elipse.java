package HW3.problem1;

public class Elipse  extends GeometricalForm{

    private final int hRadius;
    private final int vRadius;

    public Elipse (int xCoord, int yCoord, int hRadius, int vRadius) {
        super(xCoord, yCoord);
        this.hRadius = hRadius;
        this.vRadius = vRadius;
    }

    public int getHorizRadius () {
        return this.hRadius;
    }
    public int getVertRadius () {
        return this.vRadius;
    }
}
