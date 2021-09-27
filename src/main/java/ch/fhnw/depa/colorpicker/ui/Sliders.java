package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class Sliders {
  private VBox sliders;

  private Slider redSlider = new Slider(0, 255, 0);
  private Slider greenSlider = new Slider(0, 255, 0);
  private Slider blueSlider = new Slider(0, 255, 0);

  public Sliders(ColorPicker app) {
    redSlider.valueProperty().bindBidirectional(app.getRed());
    greenSlider.valueProperty().bindBidirectional(app.getGreen());
    blueSlider.valueProperty().bindBidirectional(app.getBlue());

    sliders = new VBox(redSlider, greenSlider, blueSlider);
    sliders.setSpacing(15);
  }

  public VBox getSliders() {
    return sliders;
  }

}
