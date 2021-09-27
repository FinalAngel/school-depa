package ch.fhnw.depa.colorpicker;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Toolbar extends VBox {
  private Stage stage;
  private ColorPicker colorPicker;

  private Menu menu;
  private MenuBar menuBar;
  private MenuItem reset;
  private MenuItem close;

  public Toolbar(ColorPicker colorPicker, Stage stage) {
    this.stage = stage;
    this.colorPicker = colorPicker;

    this.reset = new MenuItem("Reset");
    this.close = new MenuItem("Close");

    this.menu = new Menu("App");
    menu.getItems().add(reset);
    menu.getItems().add(close);

    this.menuBar = new MenuBar();
    menuBar.getMenus().add(menu);

    this.getChildren().add(menuBar);

    addListener();
  }

  private void addListener() {
    close.setOnAction(e -> {
      stage.close();
    });

    reset.setOnAction(e -> {
      colorPicker.setRGB(0, 0, 0);
    });
  }

}
