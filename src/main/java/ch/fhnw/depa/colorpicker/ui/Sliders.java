package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.interfaces.UI;
import ch.fhnw.depa.colorpicker.ColorPicker;

public class Sliders implements UI {
  private ColorPicker app;

  private VBox sliders;

  private Slider redSlider;
  private Slider greenSlider;
  private Slider blueSlider;

  public Sliders(ColorPicker app) {
    this.app = app;

    this.redSlider = new Slider(0, 255, 0);
    this.greenSlider = new Slider(0, 255, 0);
    this.blueSlider = new Slider(0, 255, 0);

    setDefaults();
  }

  private void setDefaults() {
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
