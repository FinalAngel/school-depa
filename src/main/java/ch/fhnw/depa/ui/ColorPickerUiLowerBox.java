package ch.fhnw.depa.ui;

import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class ColorPickerUiLowerBox {
  private HBox lowerBox;

  private Label colorField;

  private ToggleGroup colorRadio;
  private RadioButton redRadio;
  private RadioButton blueRadio;
  private RadioButton greenRadio;
  private RadioButton yellowRadio;
  private RadioButton cyanRadio;
  private RadioButton orangeRadio;
  private RadioButton blackRadio;

  private Button darker;
  private Button brighter;

  public ColorPickerUiLowerBox(IntegerProperty red, IntegerProperty green, IntegerProperty blue) {
    colorField = new Label();
    colorField.setMinWidth(150);
    colorField.setMinHeight(100);
    colorField
        .setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 80), new CornerRadii(5.0), new Insets(0))));

    colorRadio = new ToggleGroup();

    redRadio = new RadioButton("red");
    redRadio.setToggleGroup(colorRadio);
    blueRadio = new RadioButton("blue");
    blueRadio.setToggleGroup(colorRadio);
    greenRadio = new RadioButton("green");
    greenRadio.setToggleGroup(colorRadio);
    yellowRadio = new RadioButton("yellow");
    yellowRadio.setToggleGroup(colorRadio);
    cyanRadio = new RadioButton("cyan");
    cyanRadio.setToggleGroup(colorRadio);
    orangeRadio = new RadioButton("orange");
    orangeRadio.setToggleGroup(colorRadio);
    blackRadio = new RadioButton("black");
    blackRadio.setToggleGroup(colorRadio);

    VBox radio = new VBox(redRadio, blueRadio, greenRadio, yellowRadio, cyanRadio, orangeRadio, blackRadio);
    radio.setSpacing(5);

    darker = new Button("Darker");
    brighter = new Button("Brighter");

    VBox buttons = new VBox(darker, brighter);
    buttons.setSpacing(15);

    brighter.setOnAction(event -> {
      red.set(red.intValue() + 10);
      green.set(green.intValue() + 10);
      blue.set(blue.intValue() + 10);
    });

    darker.setOnAction(event -> {
      red.set(red.intValue() - 10);
      green.set(green.intValue() - 10);
      blue.set(blue.intValue() - 10);
    });

    redRadio.setOnAction(event -> {
      red.set(255);
      green.set(0);
      blue.set(0);
    });

    greenRadio.setOnAction(event -> {
      red.set(0);
      green.set(255);
      blue.set(0);
    });

    blueRadio.setOnAction(event -> {
      red.set(0);
      green.set(0);
      blue.set(255);
    });

    yellowRadio.setOnAction(event -> {
      red.set(255);
      green.set(255);
      blue.set(0);
    });

    cyanRadio.setOnAction(event -> {
      red.set(0);
      green.set(255);
      blue.set(255);
    });

    orangeRadio.setOnAction(event -> {
      red.set(255);
      green.set(136);
      blue.set(0);
    });

    blackRadio.setOnAction(event -> {
      red.set(0);
      green.set(0);
      blue.set(0);
    });

    lowerBox = new HBox(colorField, radio, buttons); // add field here
    lowerBox.setSpacing(60);
  }

  public HBox getLowerBox() {
    return lowerBox;
  }

  public void colorFieldSetBackground(int r, int g, int b) {
    colorField
        .setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b), new CornerRadii(5.0), new Insets(0))));
  }

  public void radioSelector(int r, int g, int b) {
    redRadio.selectedProperty().set(r == 255 && g == 0 && b == 0);
    greenRadio.selectedProperty().set(r == 0 && g == 255 && b == 0);
    blueRadio.selectedProperty().set(r == 0 && g == 0 && b == 255);
    yellowRadio.selectedProperty().set(r == 255 && g == 255 && b == 0);
    cyanRadio.selectedProperty().set(r == 0 && g == 255 && b == 255);
    orangeRadio.selectedProperty().set(r == 255 && g == 136 && b == 0);
    blackRadio.selectedProperty().set(r == 0 && g == 0 && b == 0);
  }
}
