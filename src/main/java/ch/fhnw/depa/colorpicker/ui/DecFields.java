package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

import ch.fhnw.depa.colorpicker.abstracts.UIAbstract;
import ch.fhnw.depa.colorpicker.ColorPicker;

public class DecFields extends UIAbstract {
  private ColorPicker app;

  private VBox decFields;

  private TextField redDecField;
  private TextField greenDecField;
  private TextField blueDecField;

  public DecFields(ColorPicker app) {
    this.app = app;

    this.redDecField = new TextField();
    this.greenDecField = new TextField();
    this.blueDecField = new TextField();

    setDefaults();
  }

  private void setDefaults() {
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
