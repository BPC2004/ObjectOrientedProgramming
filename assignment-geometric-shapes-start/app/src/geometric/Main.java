package geometric;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		terminal();
	}

	public static void terminal() {
		Scanner scan = new Scanner(System.in);
		Setup listShapes = new Setup(10);
		while (true) {
			System.out.println("What command do you want to execute?");
			String command = scan.next();
			switch (command) {
				case "quit":
					scan.close();
					return;
				case "show":
					System.out.println(listShapes.toString());
					break;
				case "circle":
					int cx = scan.nextInt();
					int cy = scan.nextInt();
					int cr = scan.nextInt();
					Geometric circle = new Circle(new Coordinate(cx, cy), cr);
					listShapes.addShape(circle);
					break;
				case "rectangle":
					int rx = scan.nextInt();
					int ry = scan.nextInt();
					int rw = scan.nextInt();
					int rh = scan.nextInt();
					Geometric rectangle = new Rectangle(new Coordinate(rx, ry), rw, rh);
					listShapes.addShape(rectangle);
					break;
				case "move":
					int mi = scan.nextInt();
					int dx = scan.nextInt();
					int dy = scan.nextInt();
					listShapes.move(mi, dx, dy);
					break;
				case "remove":
					int ri = scan.nextInt();
					listShapes.removeShape(ri);
					break;
				case "filter":
					String operation = scan.next();
					int filter = scan.nextInt();
					if(operation.equals("x")){ // Use .equals() for string comparison
						listShapes.removeByX(filter);
					}
					else if(operation.equals("y")){
						listShapes.removeByY(filter);
					}
					else if(operation.equals("r")){
						listShapes.removeByR(filter);
					}
					else{
						System.out.println("Wrong filter type name.");
						return;
					}
					break;
				case "sort":
					String operator = scan.next();
					if(operator.equals("x")) // Use .equals() for string comparison
						listShapes.sortByX();
					else if(operator.equals("y"))
						listShapes.sortByY();
					else
						listShapes.sortByArea();
					break;
				default:
					System.out.println("Command not found.");
					break;
			}
		}
	}	
}
