package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import ch.fhnw.depa.colorpicker.abstracts.UIAbstract;
import ch.fhnw.depa.colorpicker.ColorPicker;

public class StepButtons extends UIAbstract {
  private ColorPicker app;

  private VBox buttons;

  private Button darker;
  private Button brighter;

  private int increment = 10;

  public StepButtons(ColorPicker app) {
    this.app = app;

    this.darker = new Button("Darker");
    this.brighter = new Button("Brighter");

    this.buttons = new VBox(darker, brighter);

    setDefaults();
    addListener();
  }

  private void setDefaults() {
    buttons.setSpacing(15);
  }

  private void addListener() {
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
