package snake;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Represents the head part of the snake
 */
public class Head extends Mover {
  private Property<Segment> bodyProperty;
  private BooleanProperty isAlive = new SimpleBooleanProperty(true);

  public Head(Segment body, Direction direction, int xPos, int yPos, World world) {
    super(direction, xPos, yPos, world);
    this.bodyProperty = new SimpleObjectProperty<>(body);
  }

  public Segment getBody() {
    return bodyProperty.getValue();
  }

  public Property<Segment> bodyProperty() {
    return bodyProperty;
  }

  public void step() {
    World world = getWorld();
    Food food = world.getFood();
    int x = getXPos();
    int y = getYPos();
    if(sameLocation(food)){
      bodyProperty().setValue(new BodySegment(getBody(), getDirection(), x, y, world));
      world.eatFood();
      tryToMove();
    } else{
      if(!getBody().bitesItself(this)){
        tryToMove();
        if(isAlive.get())
          getBody().follow(getDirection());
      }
    }
  }

  private void tryToMove() {
    if (canMove()){
      move();
    } else {
      isAlive.set(false);
    }
  }

  public BooleanProperty isAliveProperty() {
    return isAlive;
  }

}
