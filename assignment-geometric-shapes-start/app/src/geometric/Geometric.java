package geometric;

public interface Geometric {
    public double bottomBorder();

    public double topBorder();

    public double leftBorder();

    public double rightBorder();

    public double area();

    public void move(double dx, double dy);

    @Override
    public String toString();
}
