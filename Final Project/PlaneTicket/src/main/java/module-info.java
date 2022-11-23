module com.example.planeticket {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.planeticket to javafx.fxml;
    exports com.example.planeticket;
    exports com.example.planeticket.controller;
    opens com.example.planeticket.controller to javafx.fxml;
}