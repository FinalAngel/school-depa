package ch.fhnw.depa.colorpicker;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.ui.ColorPickerUiLowerBox;
import ch.fhnw.depa.ui.ColorPickerUiTopBox;

public class ColorPicker extends VBox {
  private IntegerProperty red = new SimpleIntegerProperty(0);
  private IntegerProperty green = new SimpleIntegerProperty(0);
  private IntegerProperty blue = new SimpleIntegerProperty(0);

  public ColorPicker() {
    setSpacing(15);
    setPadding(new Insets(20));

    ColorPickerUiTopBox colorPickerUiTopBox = new ColorPickerUiTopBox(red, green, blue);
    HBox topBox = colorPickerUiTopBox.getTopBox();

    ColorPickerUiLowerBox colorPickerUiLowerBox = new ColorPickerUiLowerBox(red, green, blue);
    HBox lowerBox = colorPickerUiLowerBox.getLowerBox();

    getChildren().add(topBox);
    getChildren().add(lowerBox);

    red.addListener((p, o, n) -> {
      int i = limitInt(n.intValue());
      red.set(i);
      colorPickerUiLowerBox.radioSelector(i, green.intValue(), blue.intValue());
      colorPickerUiTopBox.setRedHexFieldText(Integer.toHexString(i));
      colorPickerUiLowerBox.colorFieldSetBackground(i, green.intValue(), blue.intValue());
    });

    green.addListener((p, o, n) -> {
      int i = limitInt(n.intValue());
      green.set(i);
      colorPickerUiLowerBox.radioSelector(red.intValue(), i, blue.intValue());
      colorPickerUiTopBox.setGreenHexFieldText(Integer.toHexString(i));
      colorPickerUiLowerBox.colorFieldSetBackground(red.intValue(), i, blue.intValue());
    });

    blue.addListener((p, o, n) -> {
      int i = limitInt(n.intValue());
      blue.set(i);
      colorPickerUiLowerBox.radioSelector(red.intValue(), green.intValue(), i);
      colorPickerUiTopBox.setBlueHexFieldText(Integer.toHexString(i));
      colorPickerUiLowerBox.colorFieldSetBackground(red.intValue(), green.intValue(), i);
    });

  }

  private int limitInt(int i) {
    if (i > 255) {
      return 255;
    } else if (i < 0) {
      return 0;
    }

    return i;
  }

}
