package ch.fhnw.depa.colorpicker;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import ch.fhnw.depa.colorpicker.ui.LowerUI;
import ch.fhnw.depa.ui.ColorPickerUiTopBox;

public class ColorPicker extends VBox {
  private IntegerProperty red;
  private IntegerProperty green;
  private IntegerProperty blue;

  private ColorPickerUiTopBox colorPickerUiTopBox;
  private LowerUI lower;

  public ColorPicker() {
    this.red = new SimpleIntegerProperty(0);
    this.green = new SimpleIntegerProperty(0);
    this.blue = new SimpleIntegerProperty(0);

    this.colorPickerUiTopBox = new ColorPickerUiTopBox(red, green, blue);
    this.lower = new LowerUI(this);

    this.getChildren().add(colorPickerUiTopBox.getTopBox());
    this.getChildren().add(lower.getUI());
    this.addListener();
  }

  private void addListener() {
    red.addListener((p, o, n) -> {
      int value = getBound(n.intValue());

      red.set(value);
      colorPickerUiTopBox.setRedHexFieldText(Integer.toHexString(value));
      lower.update(value, green.intValue(), blue.intValue());
    });

    green.addListener((p, o, n) -> {
      int value = getBound(n.intValue());

      green.set(value);
      colorPickerUiTopBox.setGreenHexFieldText(Integer.toHexString(value));
      lower.update(red.intValue(), value, blue.intValue());
    });

    blue.addListener((p, o, n) -> {
      int value = getBound(n.intValue());

      blue.set(value);
      colorPickerUiTopBox.setBlueHexFieldText(Integer.toHexString(value));
      lower.update(red.intValue(), green.intValue(), value);
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
