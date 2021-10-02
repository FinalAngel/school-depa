package ch.fhnw.depa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class App extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    ColorPicker colorPicker = new ColorPicker(stage);
    VBox layout = new VBox(colorPicker);
    Scene scene = new Scene(layout);

    stage.setTitle("Color Picker");
    stage.setScene(scene);
    stage.show();
  }

}
