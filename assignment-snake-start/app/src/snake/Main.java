package snake;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @version 1.0
 */
public class Main extends Application {
    public final static int DELAY = 200;

    @Override
    public void start(Stage stage) throws Exception {
        World world = new World();
        Pane worldPane = new WorldView(world);
        Pane ui = createUserInterface(world);
        BorderPane root = new BorderPane();

        worldPane.setStyle("-fx-background-color: #30B080;");
        ui.setPadding(new javafx.geometry.Insets(10));

        root.setLeft(worldPane);
        root.setRight(ui);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(DELAY), e -> world.getHead().step()));
        timeline.play();
        world.getRunningProperty().addListener((observableValue, aBoolean, isRunning) -> {
            if (isRunning) timeline.play();
            else timeline.pause();
        });
        timeline.setCycleCount(Timeline.INDEFINITE);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> keyHandler(keyEvent, world));
        scene.setOnMouseClicked(mouseEvent -> mouseHandler(mouseEvent, world));

        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
    }

    private void keyHandler(KeyEvent keyEvent, World world) {
        switch (keyEvent.getCode()) {
            case W:
                world.getHead().setDirection(Direction.NORTH);
                break;
            case D:
                world.getHead().setDirection(Direction.EAST);
                break;
            case S:
                world.getHead().setDirection(Direction.SOUTH);
                break;
            case A:
                world.getHead().setDirection(Direction.WEST);
                break;
            case SPACE:
                if(world.isRunning()) world.setRunning(false);
                else world.setRunning(true);
                break;
            default:
                break;
        }
    }

    private void mouseHandler(MouseEvent mouseEvent, World world) {
        if (MouseEvent.MOUSE_CLICKED.equals(mouseEvent.getEventType())) {
            int mouseX = (int)(mouseEvent.getX() / 20);
            int mouseY = (int)(mouseEvent.getY() / 20);
            if(mouseX >= world.getWidth()) mouseX = world.getWidth() - 1;
            if(mouseY >= world.getHeight()) mouseY = world.getHeight() - 1;
            world.getFood().setLocation(mouseX, mouseY);
        }
    }

    public static Pane createUserInterface(World world) {
        VBox ui = new VBox();

        Label scoreText = new Label();
        Label runningText = new Label("Press 'space' to start");

        scoreText.textProperty().bind(Bindings.convert(world.getScoreProperty()));
        world.getRunningProperty().addListener((observableValue, aBoolean, isRunning) -> {
            if (isRunning) {
                runningText.setVisible(false);
            }
            else runningText.setVisible(true);
        });

        ui.getChildren().addAll(scoreText, runningText);

        return ui;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
