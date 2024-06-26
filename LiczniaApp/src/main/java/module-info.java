module org.example.liczniaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jdk.jdi;
    requires java.desktop;
    requires java.sql;
    requires java.management;

    opens org.example.liczniaapp to javafx.fxml;
    exports org.example.liczniaapp;
}