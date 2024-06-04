package snake;

import java.util.Random;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * World keeps track of the state of a game of snake
 */
public class World {
  private static final int WIDTH = 20, HEIGHT = 15;

  private final Food food;
  private final Head head;

  private final Random numberGenerator = new Random();

  private final BooleanProperty running = new SimpleBooleanProperty(false);

  private final IntegerProperty score = new SimpleIntegerProperty(0);

  public World() {
    food = new Food(numberGenerator.nextInt(WIDTH), numberGenerator.nextInt(HEIGHT), this);
    head = randomSnake();
  }

  public void setRunning(boolean running) {
    this.running.set(running);
  }

  public void setScore(int score) {
    this.score.set(score);
  }

  public int getScore() {
    return score.get();
  }

  public boolean isRunning() {
    return running.get();
  }

  public Food getFood() {
    return food;
  }

  public Head getHead() {
    return head;
  }

  public int getWidth() {
    return WIDTH;
  }

  public int getHeight() {
    return HEIGHT;
  }

  public BooleanProperty getRunningProperty() {
    return running;
  }

  public IntegerProperty getScoreProperty() {
    return score;
  }

  private Head randomSnake() {
    Direction randomDir = Direction.values()[numberGenerator.nextInt(Direction.values().length)];
    int ranX = numberGenerator.nextInt(WIDTH - 4) + 2;
    int ranY = numberGenerator.nextInt(HEIGHT - 4) + 2;
    Segment tail = new TailSegment(randomDir, ranX, ranY, this);
    return new Head(tail, randomDir, ranX + randomDir.getDX(), ranY + randomDir.getDY(), this);
  }

  public void eatFood() {
    food.setLocation(numberGenerator.nextInt(WIDTH), numberGenerator.nextInt(HEIGHT));
    setScore(getScore() + 1);
  }

}
