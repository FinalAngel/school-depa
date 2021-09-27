package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class DecFields {
  private VBox decFields;

  private TextField redDecField = new TextField();
  private TextField greenDecField = new TextField();
  private TextField blueDecField = new TextField();

  public DecFields(ColorPicker app) {
    redDecField.setDisable(false);
    greenDecField.setDisable(false);
    blueDecField.setDisable(false);

    redDecField.textProperty().bindBidirectional(app.getRed(), new NumberStringConverter());
    greenDecField.textProperty().bindBidirectional(app.getGreen(), new NumberStringConverter());
    blueDecField.textProperty().bindBidirectional(app.getBlue(), new NumberStringConverter());

    decFields = new VBox(redDecField, greenDecField, blueDecField);
    decFields.setSpacing(5);
  }

  public VBox getFields() {
    return decFields;
  }

}
