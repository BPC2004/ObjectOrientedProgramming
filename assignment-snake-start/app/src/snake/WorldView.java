package snake;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * A JavaFX Pane that displays the snake game represented by the given world
 */
public class WorldView extends Pane {
  protected static final double UNIT = 20;

  public WorldView(World world) {
    // TODO: implement snake game graphics using addMoverView and bindLocation

    Food food = world.getFood();
    Rectangle foodView = new Rectangle(UNIT, UNIT, Color.BLUE);

    bindLocation(food, foodView);
    getChildren().add(foodView);

    Head head = world.getHead();

    addMoverView(head, UNIT / 2, Color.RED);
    addMoverView(head.getBody(), UNIT / 4, Color.GREEN);

    head.bodyProperty().addListener((obs, ov, nv) -> addMoverView(nv, UNIT / 2, Color.GREEN));

    // End

    setPrefSize(world.getWidth() * UNIT, world.getHeight() * UNIT);
  }

  private Circle addMoverView(Mover mover, double radius, Color color) {
    Circle circle = new Circle(UNIT / 2, UNIT / 2, radius, color);
    bindLocation(mover, circle);
    getChildren().add(circle);
    return circle;
  }

  private void bindLocation(Actor actor, Shape actorView) {
    actorView.translateXProperty().bind(actor.xPosProperty().multiply(UNIT));
    actorView.translateYProperty().bind(actor.yPosProperty().multiply(UNIT));
  }

}
