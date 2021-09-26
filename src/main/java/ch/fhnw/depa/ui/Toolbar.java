package ch.fhnw.depa.ui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Toolbar extends VBox {

  public Toolbar(Stage stage) {
    Menu menu = new Menu("ColorPicker");

    // close entry
    MenuItem item = new MenuItem("Close");
    item.setOnAction(e -> {
      stage.close();
    });

    menu.getItems().add(item);

    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().add(menu);

    this.getChildren().add(menuBar);
  }

}
