package ch.fhnw.depa.colorpicker.ui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
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

    redDecField.textProperty().addListener(validateNumberField(redDecField, 3));
    greenDecField.textProperty().addListener(validateNumberField(greenDecField, 3));
    blueDecField.textProperty().addListener(validateNumberField(blueDecField, 3));

    decFields = new VBox(redDecField, greenDecField, blueDecField);
    decFields.setSpacing(5);
    decFields.setPadding(new Insets(0, 10, 0, 10));
  }

  private ChangeListener<String> validateNumberField(TextField field, int length) {
    // this should be refactored but my cat is annoying me right now
    return (obs, oldVal, newVal) -> {
      field.setText(newVal.replaceAll("[^\\d]", ""));

      if (newVal.length() > length) {
        field.setText(oldVal);
      } else if (newVal == "") {
        field.setText("0");
      } else if (Integer.parseInt(newVal) >= 255) {
        field.setText("255");
      }
    };
  }

  public VBox render() {
    return decFields;
  }

}
