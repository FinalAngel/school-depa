package ch.fhnw.depa.colorpicker.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class Sliders extends VBox {

  public Sliders(ColorPicker app) {

    Slider redSlider = new Slider(0, 255, 0);
    Slider greenSlider = new Slider(0, 255, 0);
    Slider blueSlider = new Slider(0, 255, 0);
    redSlider.valueProperty().bindBidirectional(app.getRed());
    greenSlider.valueProperty().bindBidirectional(app.getGreen());
    blueSlider.valueProperty().bindBidirectional(app.getBlue());
    getChildren().add(redSlider);
    getChildren().add(greenSlider);
    getChildren().add(blueSlider);
    setSpacing(15);
    setPadding(new Insets(5, 0, 5, 0));
  }
}
