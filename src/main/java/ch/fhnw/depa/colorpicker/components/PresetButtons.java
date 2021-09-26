package ch.fhnw.depa.colorpicker.components;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class PresetButtons {
  private VBox buttons;

  private ToggleGroup colorRadio = new ToggleGroup();
  private RadioButton redRadio = new RadioButton("red");
  private RadioButton blueRadio = new RadioButton("blue");
  private RadioButton greenRadio = new RadioButton("green");
  private RadioButton yellowRadio = new RadioButton("yellow");
  private RadioButton cyanRadio = new RadioButton("cyan");
  private RadioButton orangeRadio = new RadioButton("orange");
  private RadioButton blackRadio = new RadioButton("black");

  public PresetButtons(ColorPicker app) {
    redRadio.setToggleGroup(colorRadio);
    blueRadio.setToggleGroup(colorRadio);
    greenRadio.setToggleGroup(colorRadio);
    yellowRadio.setToggleGroup(colorRadio);
    cyanRadio.setToggleGroup(colorRadio);
    orangeRadio.setToggleGroup(colorRadio);
    blackRadio.setToggleGroup(colorRadio);

    redRadio.setOnAction(event -> app.setRGB(255, 0, 0));
    greenRadio.setOnAction(event -> app.setRGB(0, 255, 0));
    blueRadio.setOnAction(event -> app.setRGB(0, 0, 255));
    yellowRadio.setOnAction(event -> app.setRGB(255, 255, 0));
    cyanRadio.setOnAction(event -> app.setRGB(0, 255, 255));
    orangeRadio.setOnAction(event -> app.setRGB(255, 136, 0));
    blackRadio.setOnAction(event -> app.setRGB(0, 0, 0));

    buttons = new VBox(redRadio, blueRadio, greenRadio, yellowRadio, cyanRadio, orangeRadio, blackRadio);
    buttons.setSpacing(5);
  }

  public VBox getButtons() {
    return buttons;
  }

  public void setButtons(int r, int g, int b) {
    redRadio.selectedProperty().set(r == 255 && g == 0 && b == 0);
    greenRadio.selectedProperty().set(r == 0 && g == 255 && b == 0);
    blueRadio.selectedProperty().set(r == 0 && g == 0 && b == 255);
    yellowRadio.selectedProperty().set(r == 255 && g == 255 && b == 0);
    cyanRadio.selectedProperty().set(r == 0 && g == 255 && b == 255);
    orangeRadio.selectedProperty().set(r == 255 && g == 136 && b == 0);
    blackRadio.selectedProperty().set(r == 0 && g == 0 && b == 0);
  }

}
