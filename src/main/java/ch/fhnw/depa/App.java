package ch.fhnw.depa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import ch.fhnw.depa.colorpicker.ColorPicker;

public class App extends Application {
  private Stage stage;
  private Toolbar toolBar;
  private ColorPicker colorPicker;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    this.stage = stage;

    toolBar = new Toolbar(stage);
    toolBar.setSpacing(15);

    colorPicker = new ColorPicker();
    colorPicker.setSpacing(15);
    colorPicker.setPadding(new Insets(20));

    Scene scene = new Scene(new VBox(toolBar, colorPicker));

    stage.setTitle("Color Picker");
    stage.setScene(scene);
    stage.show();
  }

  public Stage getStage() {
    return stage;
  }

}
