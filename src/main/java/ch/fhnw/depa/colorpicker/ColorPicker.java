package ch.fhnw.depa.colorpicker;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import ch.fhnw.depa.colorpicker.ui.LowerUI;
import ch.fhnw.depa.colorpicker.ui.UpperUI;

public class ColorPicker extends VBox {
  private IntegerProperty red;
  private IntegerProperty green;
  private IntegerProperty blue;

  private UpperUI upper;
  private LowerUI lower;

  public ColorPicker() {
    this.red = new SimpleIntegerProperty(0);
    this.green = new SimpleIntegerProperty(0);
    this.blue = new SimpleIntegerProperty(0);

    this.upper = new UpperUI(this);
    this.lower = new LowerUI(this);

    this.getChildren().add(upper.getUI());
    this.getChildren().add(lower.getUI());
    this.addListener();
  }

  private void addListener() {
    red.addListener((p, o, n) -> {
      int value = getBound(n.intValue());

      red.set(value);
      upper.update("red", Integer.toHexString(value));
      lower.update(value, green.intValue(), blue.intValue());
    });

    green.addListener((p, o, n) -> {
      int value = getBound(n.intValue());

      green.set(value);
      upper.update("green", Integer.toHexString(value));
      lower.update(red.intValue(), value, blue.intValue());
    });

    blue.addListener((p, o, n) -> {
      int value = getBound(n.intValue());

      blue.set(value);
      upper.update("blue", Integer.toHexString(value));
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
