package com.example.appchat.server;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;
import java.util.function.Consumer;

import java.io.IOException;

/**
 * JavaFX App
 */

public class ServerApp extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;



        Parent root = loadFXML("/server/ServerDashboardFrm");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setTitle("Server");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        Parent root = loadFXML(fxml);
        scene.setRoot(root);
        stage.setWidth(root.prefWidth(-1));
        stage.setHeight(root.prefHeight(-1));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ServerApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



    public static void setRootPop(String fxml, String title, boolean resizable, Optional<Consumer<Void>> onHiddenAction) throws IOException { // hien thi hop thoai dialog
        Stage stage = new Stage();
        Scene newScene = new Scene(loadFXML(fxml), 789, 532);
        stage.setResizable(resizable);
        stage.setScene(newScene);
        stage.setTitle(title);
        Image icon = new Image(String.valueOf(ServerApp.class.getResource("79163-200.png")));


        Stage parentStage = (Stage) scene.getWindow();
        parentStage.setOpacity(0.95);


        stage.setOnHidden(e -> {
            parentStage.setOpacity(1.0);
            onHiddenAction.ifPresent(action -> action.accept(null));
        });

        // Show the new stage as a dialog and wait for it to close
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }


    public static void main(String[] args) {
        launch();
    }
}