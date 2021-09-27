package ch.fhnw.depa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class App extends Application {
  private Scene scene;

  private VBox layout;
  private ColorPicker colorPicker;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    colorPicker = new ColorPicker(stage);
    layout = new VBox(colorPicker);
    scene = new Scene(layout);
    stage.setTitle("Color Picker");
    stage.setScene(scene);
    stage.show();
  }

}
