package ch.fhnw.depa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class App extends Application {
  private Stage stage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    this.stage = stage;

    ColorPicker colorPicker = new ColorPicker();
    Scene scene = new Scene(colorPicker);

    stage.setScene(scene);
    stage.setTitle("Color Picker");
    stage.show();
  }

  public Stage getStage() {
    return stage;
  }

}
