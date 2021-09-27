package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.abstracts.UIAbstract;
import ch.fhnw.depa.colorpicker.ColorPicker;

public class HexFields extends UIAbstract {
  private ColorPicker app;

  private VBox hexFields;

  private TextField redHexField;
  private TextField greenHexField;
  private TextField blueHexField;

  public HexFields(ColorPicker app) {
    this.app = app;

    this.redHexField = new TextField();
    this.greenHexField = new TextField();
    this.blueHexField = new TextField();

    setDefaults();
  }

  private void setDefaults() {
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
