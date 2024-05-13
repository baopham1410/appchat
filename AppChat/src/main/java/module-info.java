module com.example.appchat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.rmi;

    opens com.example.appchat.server.controller to javafx.fxml;
    opens com.example.appchat.client.controller to javafx.fxml;
    opens com.example.appchat.client to javafx.fxml;
    opens com.example.appchat.model to javafx.fxml;
    opens com.example.appchat.server.service to javafx.fxml;
    opens com.example.appchat.utils to javafx.fxml;
    opens com.example.appchat.common to javafx.fxml;

    exports com.example.appchat.server.controller;
    exports com.example.appchat.client.controller;
    exports com.example.appchat.common;
    exports com.example.appchat.model;
    exports com.example.appchat.utils;
    exports com.example.appchat.client;
    exports com.example.appchat.server;
}