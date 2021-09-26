package ch.fhnw.depa.ui;

import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

public class ColorPickerUiTopBox {

    private HBox topBox;

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    private TextField redDecField;
    private TextField greenDecField;
    private TextField blueDecField;

    private TextField redHexField;
    private TextField greenHexField;
    private TextField blueHexField;

    public ColorPickerUiTopBox(IntegerProperty red, IntegerProperty green, IntegerProperty blue) {

        redSlider = new Slider(0, 255, 0);
        redSlider.valueProperty().bindBidirectional(red);
        greenSlider = new Slider(0, 255, 0);
        greenSlider.valueProperty().bindBidirectional(green);
        blueSlider = new Slider(0, 255, 80);
        blueSlider.valueProperty().bindBidirectional(blue);

        VBox sliders = new VBox(redSlider, greenSlider, blueSlider);
        sliders.setSpacing(15);

        redDecField = new TextField();
        redDecField.setDisable(false);
        redDecField.textProperty().bindBidirectional(red, new NumberStringConverter());
        greenDecField = new TextField();
        greenDecField.setDisable(false);
        greenDecField.textProperty().bindBidirectional(green, new NumberStringConverter());
        blueDecField = new TextField();
        blueDecField.setDisable(false);
        blueDecField.textProperty().bindBidirectional(blue, new NumberStringConverter());

        VBox decField = new VBox(redDecField, greenDecField, blueDecField);
        decField.setSpacing(5);

        redHexField = new TextField();
        redHexField.setDisable(true);
        redHexField.setText(Integer.toHexString(red.intValue()));
        greenHexField = new TextField();
        greenHexField.setDisable(true);
        greenHexField.setText(Integer.toHexString(green.intValue()));
        blueHexField = new TextField();
        blueHexField.setDisable(true);
        blueHexField.setText(Integer.toHexString(blue.intValue()));

        VBox hexField = new VBox(redHexField, greenHexField, blueHexField);
        hexField.setSpacing(5);

        topBox = new HBox(sliders, decField, hexField);
        topBox.setSpacing(10);
    }

    public HBox getTopBox() {
        return topBox;
    }

    public void setRedHexFieldText(String string) {
        this.redHexField.setText(string);
    }

    public void setGreenHexFieldText(String string) {
        this.greenHexField.setText(string);
    }

    public void setBlueHexFieldText(String string) {
        this.blueHexField.setText(string);
    }
}
