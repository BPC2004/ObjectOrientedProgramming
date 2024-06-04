package geometric;

public class Rectangle implements Geometric {
    private double width, height;
    private Coordinate corner;

    public Rectangle(Coordinate corner, double width, double height) {
        this.corner = corner;
        this.width = width;
        this.height = height;
    }

    public Geometric createRectangle(double x, double y, double width, double height){
        Coordinate corner = new Coordinate(x, y);
        return new Rectangle(corner, width, height);
    }

    public double bottomBorder() {
        return corner.getY();
    }

    public double topBorder() {
        return corner.getY() + height;
    }

    public double leftBorder() {
        return corner.getX();
    }

    public double rightBorder() {
        return corner.getX() + width;
    }

    public double area() {
        return width * height;
    }

    public void move(double dx, double dy) {
        corner.setX(corner.getX() + dx);
        corner.setY(corner.getY() + dy);
    }

    public String toString(){
        return "Corner coordinate: (" + corner.getX() + ", " +  corner.getY() + "); Width: " + width + "; Height: " + height;
    }
}
