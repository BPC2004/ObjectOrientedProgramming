package properties;

import javafx.beans.value.ChangeListener;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.beans.binding.Bindings;

public class WarmUp extends Application {
	private GridPane root = new GridPane();
	private TextField[] textList = new TextField[4];
	private IntegerProperty[] intList = new IntegerProperty[4];
	private Label[] labelList = new Label[4];
	private DoubleProperty[] doubleList = new DoubleProperty[4];

	@Override
	public void start(Stage primaryStage) {
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(10);

		text_fields();

		Scene scene = new Scene(root, 500, 300);
		primaryStage.setTitle("WarmUp Pie");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void text_fields(){
		DoubleProperty sum = new SimpleDoubleProperty(0.0);
		for(int i = 0; i < 4; i++){
			textList[i] = text();
			doubleList[i] = new SimpleDoubleProperty(0.0);
			intList[i] = new SimpleIntegerProperty(0);
			labelList[i] = new Label();
			doubleList[i].bind(intList[i].divide(sum));
			textList[i].textProperty().bindBidirectional(intList[i], new NumberStringConverter());
			labelList[i].textProperty().bind(doubleList[i].asString("%.4f"));
			root.add(textList[i], 0, i + 1);
			root.add(labelList[i], 1, i + 1);
		}
		sum.bind(intList[0].add(intList[1].add(intList[2].add(intList[3]))));
	}

	private static TextField text(){
		// This code is generate by chatGPT but I permission from the TA Jasmijn to use this code since the given code doesn't work
		TextField textField = new TextField();
		TextFormatter<String> formatter = new TextFormatter<>(change -> {
			String newText = change.getControlNewText();
			if (!newText.matches("[1-9]\\d{0,3}") && !change.isDeleted()) {
				return null;
			}
			return change;
		});
		textField.setTextFormatter(formatter);
		return textField;
	}

	public static void main(String[] args) {
		launch(args);
	}
}