package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Alice;

/**
 * Main entry point for Alice chatbot.
 */
public class Main extends Application {

    private final Alice alice = new Alice();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/MainWindow.fxml"));
            VBox vb = fxmlLoader.load();
            Scene scene = new Scene(vb);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setAlice(alice);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
