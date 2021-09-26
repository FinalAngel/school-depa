package ch.fhnw.depa.colorpicker.components;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class PreviewBox {
  private Label preview;

  private CornerRadii radius = new CornerRadii(5.0);
  private Insets inset = new Insets(0);

  public PreviewBox(ColorPicker app) {
    preview = new Label();
    preview.setMinWidth(150);
    preview.setMinHeight(100);

    // set initial fill
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
