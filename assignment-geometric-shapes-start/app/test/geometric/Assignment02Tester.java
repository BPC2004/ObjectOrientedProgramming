package geometric;

public class Assignment02Tester {
	Setup listShapes = new Setup(10);
	public Assignment02Tester() {
	}

	public void createCircle(double x, double y, double r) {
		Coordinate centre = new Coordinate(x, y);
		Geometric circle = new Circle(centre , r);
		listShapes.addShape(circle);
	}

	public void createRectangle(double x, double y, double width, double height) {
		Coordinate corner = new Coordinate(x, y);
		Geometric rectangle = new Rectangle(corner , width, height);
		listShapes.addShape(rectangle);
	}

	public double topBorder(int index) {
		return listShapes.getShape(index).topBorder();
	}

	public double rightBorder(int index) {
		return listShapes.getShape(index).rightBorder();
	}

	public double bottomBorder(int index) {
		return listShapes.getShape(index).bottomBorder();
	}

	public double leftBorder(int index) {
		return listShapes.getShape(index).leftBorder();
	}

	public double area(int index) {
		return listShapes.getShape(index).area();
	}

	public void move(int index, double dx, double dy) {
		listShapes.getShape(index).move(dx, dy);
	}

	public void sortByArea() {
		listShapes.sortByArea();
	}

	public void sortByX() {
		listShapes.sortByX();
	}

	public void sortByY() {
		listShapes.sortByY();
	}

	public void filterByArea(double threshold) {
		listShapes.removeByR(threshold);
	}

	public void filterByX(double threshold) {
		listShapes.removeByX(threshold);
	}

	public void filterByY(double threshold) {
		listShapes.removeByY(threshold);
	}

	public int getShapeCount() {
		int counter = 0;
		for(int i = 0; i < listShapes.getShapes().length; i++){
			if(listShapes.getShape(i) != null){
				counter++;
			}
		}
		return counter;
	}
}
