package ch.fhnw.depa.colorpicker.ui;

import javafx.beans.property.IntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class Sliders extends VBox {

  public Sliders(ColorPicker app) {
    add(app.getRed());
    add(app.getGreen());
    add(app.getBlue());
    setSpacing(15);
    setPadding(new Insets(5, 0, 5, 0));
  }
  private void add(IntegerProperty col) {
    Slider s = new Slider(0, 255, 0);
    s.valueProperty().bindBidirectional(col);
    getChildren().add(s);
  }
}
