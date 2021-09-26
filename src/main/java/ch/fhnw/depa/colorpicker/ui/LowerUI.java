package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.layout.HBox;

import ch.fhnw.depa.colorpicker.ColorPicker;
import ch.fhnw.depa.colorpicker.components.PresetButtons;
import ch.fhnw.depa.colorpicker.components.PreviewBox;
import ch.fhnw.depa.colorpicker.components.StepButtons;

public class LowerUI {
  private HBox ui;

  private StepButtons stepButtons;
  private PresetButtons presetButtons;
  private PreviewBox preview;

  public LowerUI(ColorPicker app) {
    this.stepButtons = new StepButtons(app);
    this.presetButtons = new PresetButtons(app);
    this.preview = new PreviewBox(app);

    ui = new HBox(preview.getPreview(), presetButtons.getButtons(), stepButtons.getButtons()); // add field here
    ui.setSpacing(60);
  }

  public HBox getUI() {
    return ui;
  }

  public void update(int r, int g, int b) {
    preview.setPreview(r, g, b);
    presetButtons.setButtons(r, g, b);
  }
}
