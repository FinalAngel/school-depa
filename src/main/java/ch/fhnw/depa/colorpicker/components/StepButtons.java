package ch.fhnw.depa.colorpicker.components;

import ch.fhnw.depa.colorpicker.ColorPicker;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class StepButtons {
  private Button darker;
  private Button brighter;

  private VBox buttons;

  private int increment = 10;

  public StepButtons(ColorPicker app) {
    darker = new Button("Darker");
    brighter = new Button("Brighter");

    buttons = new VBox(darker, brighter);
    buttons.setSpacing(15);

    brighter.setOnAction(event -> {
      app.setRed(app.getRed().intValue() + increment);
      app.setGreen(app.getGreen().intValue() + increment);
      app.setBlue(app.getBlue().intValue() + increment);
    });

    darker.setOnAction(event -> {
      app.setRed(app.getRed().intValue() - increment);
      app.setGreen(app.getGreen().intValue() - increment);
      app.setBlue(app.getBlue().intValue() - increment);
    });
  }

  public VBox getButtons() {
    return buttons;
  }

}
