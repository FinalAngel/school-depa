package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.layout.HBox;

import ch.fhnw.depa.colorpicker.ColorPicker;
import ch.fhnw.depa.colorpicker.components.Sliders;
import ch.fhnw.depa.colorpicker.components.DecFields;
import ch.fhnw.depa.colorpicker.components.HexFields;

public class UpperUI {
  private HBox ui;

  private Sliders sliders;
  private DecFields decFields;
  private HexFields hexFields;

  public UpperUI(ColorPicker app) {
    this.sliders = new Sliders(app);
    this.decFields = new DecFields(app);
    this.hexFields = new HexFields(app);

    ui = new HBox(sliders.getSliders(), decFields.getFields(), hexFields.getFields());
    ui.setSpacing(10);
  }

  public HBox getUI() {
    return ui;
  }

  public void update(String type, String string) {
    switch (type) {
      case "red":
        hexFields.setRedHexField(string);
        break;
      case "green":
        hexFields.setGreenHexField(string);
        break;
      case "blue":
        hexFields.setBlueHexField(string);
        break;
      default:
        // do nothing
    }

  }

}
