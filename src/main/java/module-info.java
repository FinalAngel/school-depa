module colorpicker {
  requires javafx.base;
  requires transitive javafx.controls;
  requires transitive javafx.graphics;

  exports ch.fhnw.depa;
  exports ch.fhnw.depa.colorpicker;
  exports ch.fhnw.depa.colorpicker.abstracts;
  exports ch.fhnw.depa.colorpicker.interfaces;
  exports ch.fhnw.depa.colorpicker.ui;
}
