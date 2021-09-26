package ch.fhnw.depa.colorpicker.components;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class HexFields {
  private VBox hexFields;

  private TextField redHexField = new TextField();
  private TextField greenHexField = new TextField();
  private TextField blueHexField = new TextField();

  public HexFields(ColorPicker app) {
    redHexField.setDisable(true);
    redHexField.setText(Integer.toHexString(app.getRed().intValue()));
    greenHexField.setDisable(true);
    greenHexField.setText(Integer.toHexString(app.getGreen().intValue()));
    blueHexField.setDisable(true);
    blueHexField.setText(Integer.toHexString(app.getBlue().intValue()));

    hexFields = new VBox(redHexField, greenHexField, blueHexField);
    hexFields.setSpacing(5);
  }

  public VBox getFields() {
    return hexFields;
  }

  public void setRedHexField(String string) {
    redHexField.setText(string);
  }

  public void setGreenHexField(String string) {
    greenHexField.setText(string);
  }

  public void setBlueHexField(String string) {
    blueHexField.setText(string);
  }

}
