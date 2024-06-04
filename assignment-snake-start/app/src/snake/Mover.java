package snake;

/**
 *
 * Represents a game element that can move, i.e., the parts of the snake
 */
public abstract class Mover extends Actor {
  private Direction direction;

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public Mover(Direction direction, int xPos, int yPos, World world) {
    super(xPos, yPos, world);
    this.direction = direction;
  }

  public void move() {
    setLocation(getXPos() + direction.getDX(), getYPos() + direction.getDY());
    
  }

  private boolean checkRange(int val, int minVal, int maxVal) {
    return val >= minVal && val < maxVal;
  }

  public boolean canMove() {
    return (
      checkRange(getXPos(), 0, getWorld().getWidth()) &&
      checkRange(getYPos(), 0, getWorld().getHeight())
    );
  }
}
