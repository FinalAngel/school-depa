package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.interfaces.UI;
import ch.fhnw.depa.colorpicker.ColorPicker;

public class PresetButtons implements UI {
  private ColorPicker app;

  private VBox buttons;

  private ToggleGroup colorRadio;
  private RadioButton redRadio;
  private RadioButton blueRadio;
  private RadioButton greenRadio;
  private RadioButton yellowRadio;
  private RadioButton cyanRadio;
  private RadioButton orangeRadio;
  private RadioButton blackRadio;

  public PresetButtons(ColorPicker app) {
    this.app = app;

    this.colorRadio = new ToggleGroup();
    this.redRadio = new RadioButton("red");
    this.blueRadio = new RadioButton("blue");
    this.greenRadio = new RadioButton("green");
    this.yellowRadio = new RadioButton("yellow");
    this.cyanRadio = new RadioButton("cyan");
    this.orangeRadio = new RadioButton("orange");
    this.blackRadio = new RadioButton("black");

    setDefaults();
  }

  private void setDefaults() {
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
