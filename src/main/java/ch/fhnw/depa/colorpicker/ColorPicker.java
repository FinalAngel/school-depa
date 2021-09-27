package ch.fhnw.depa.colorpicker;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import ch.fhnw.depa.colorpicker.ui.DecFields;
import ch.fhnw.depa.colorpicker.ui.HexFields;
import ch.fhnw.depa.colorpicker.ui.PresetButtons;
import ch.fhnw.depa.colorpicker.ui.PreviewBox;
import ch.fhnw.depa.colorpicker.ui.Sliders;
import ch.fhnw.depa.colorpicker.ui.StepButtons;

public class ColorPicker extends VBox {
  private Toolbar toolBar;

  private IntegerProperty red;
  private IntegerProperty green;
  private IntegerProperty blue;

  private StepButtons stepButtons;
  private PresetButtons presetButtons;
  private PreviewBox preview;

  private Sliders sliders;
  private DecFields decFields;
  private HexFields hexFields;

  private int spacing = 15;

  public ColorPicker(Stage stage) {
    this.red = new SimpleIntegerProperty(0);
    this.green = new SimpleIntegerProperty(0);
    this.blue = new SimpleIntegerProperty(0);

    this.toolBar = new Toolbar(this, stage);

    this.stepButtons = new StepButtons(this);
    this.presetButtons = new PresetButtons(this);
    this.preview = new PreviewBox(this);

    this.sliders = new Sliders(this);
    this.decFields = new DecFields(this);
    this.hexFields = new HexFields(this);

    buildUI();
    addListener();
  }

  private void buildUI() {
    HBox ui;
    Pane spacingPane = new Pane();
    spacingPane.setMinWidth(60);

    toolBar.setSpacing(spacing);
    this.getChildren().add(toolBar);

    ui = new HBox();
    ui.getChildren().add(sliders.getSliders());
    ui.getChildren().add(decFields.getFields());
    ui.getChildren().add(hexFields.getFields());
    ui.setPadding(new Insets(spacing));
    this.getChildren().add(ui);

    ui = new HBox();
    ui.getChildren().add(preview.getPreview());
    ui.getChildren().add(presetButtons.getButtons());
    ui.getChildren().add(spacingPane);
    ui.getChildren().add(stepButtons.getButtons());
    ui.setSpacing(spacing);
    ui.setPadding(new Insets(spacing));
    this.getChildren().add(ui);
  }

  private void addListener() {
    red.addListener((p, o, n) -> {
      int value = getBound(n.intValue());
      red.set(value);

      hexFields.setRedHexField(Integer.toHexString(value));
      preview.setPreview(value, green.intValue(), blue.intValue());
      presetButtons.setButtons(value, green.intValue(), blue.intValue());
    });

    green.addListener((p, o, n) -> {
      int value = getBound(n.intValue());
      green.set(value);

      hexFields.setGreenHexField(Integer.toHexString(value));
      preview.setPreview(red.intValue(), value, blue.intValue());
      presetButtons.setButtons(red.intValue(), value, blue.intValue());
    });

    blue.addListener((p, o, n) -> {
      int value = getBound(n.intValue());
      blue.set(value);

      hexFields.setBlueHexField(Integer.toHexString(value));
      preview.setPreview(red.intValue(), green.intValue(), value);
      presetButtons.setButtons(red.intValue(), green.intValue(), value);
    });
  }

  private int getBound(int i) {
    if (i > 255) {
      return 255;
    }

    if (i < 0) {
      return 0;
    }

    return i;
  }

  public IntegerProperty getRed() {
    return this.red;
  }

  public IntegerProperty getGreen() {
    return this.green;
  }

  public IntegerProperty getBlue() {
    return this.blue;
  }

  public void setRed(int value) {
    red.set(value);
  }

  public void setGreen(int value) {
    green.set(value);
  }

  public void setBlue(int value) {
    blue.set(value);
  }

  /**
   * Sets RGB value
   * 
   * @param r red value as number [0 - 255]
   * @param g green value as number [0 - 255]
   * @param b blue value as number [0 - 255]
   */
  public void setRGB(int r, int g, int b) {
    red.set(r);
    green.set(g);
    blue.set(b);
  }

  /**
   * Returns value as Color
   */
  public Color getRGB() {
    return Color.rgb(getRed().getValue(), getBlue().getValue(), getGreen().getValue());
  }

}
