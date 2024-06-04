package geometric;

public class Circle implements Geometric {
    private double radius;
    private Coordinate center;

    public Circle(Coordinate center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public void createCircle(double x, double y, double radius) {
        this.center = new Coordinate(x, y);
        this.radius = radius;
    }    

    public double bottomBorder() {
        return center.getY() - radius;
    }
    
    public double topBorder() {
        return center.getY() + radius;
    }

    public double leftBorder() {
        return center.getX() - radius;
    }

    public double rightBorder() {
        return center.getX() + radius;
    }

    public double area() {
        return Math.PI * (radius * radius);
    }

    public void move(double dx, double dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }

    public String toString(){
        return "Center coordinate: (" + center.getX() + ", " +  center.getY() + "); Radius: " + radius;
    }
}
