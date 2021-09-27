package ch.fhnw.depa.colorpicker.ui;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

import ch.fhnw.depa.colorpicker.interfaces.UI;
import ch.fhnw.depa.colorpicker.ColorPicker;

public class PreviewBox implements UI {
  private ColorPicker app;

  private Label preview;
  private CornerRadii radius;
  private Insets inset;

  public PreviewBox(ColorPicker app) {
    this.app = app;

    this.preview = new Label();
    this.radius = new CornerRadii(5.0);
    this.inset = new Insets(0);

    setDefaults();
  }

  public void setDefaults() {
    preview.setMinWidth(200);
    preview.setMinHeight(200 / 1.25);

    BackgroundFill fill = new BackgroundFill(app.getRGB(), radius, inset);
    Background bg = new Background(fill);
    preview.setBackground(bg);
  }

  public Label getPreview() {
    return preview;
  }

  public void setPreview(int r, int g, int b) {
    Color color = Color.rgb(r, g, b);
    BackgroundFill fill = new BackgroundFill(color, radius, inset);
    Background bg = new Background(fill);

    preview.setBackground(bg);
  }

}
