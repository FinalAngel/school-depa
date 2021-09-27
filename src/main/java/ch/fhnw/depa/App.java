package ch.fhnw.depa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class App extends Application {
  private ColorPicker colorPicker;
  private VBox layout;
  private Scene scene;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    this.colorPicker = new ColorPicker(stage);
    this.layout = new VBox(colorPicker);
    this.scene = new Scene(layout);

    stage.setTitle("Color Picker");
    stage.setScene(scene);
    stage.show();
  }

}
