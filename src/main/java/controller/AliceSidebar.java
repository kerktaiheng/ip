package controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.Alice;

public final class AliceSidebar extends VBox {

    @FXML
    private Circle imageCircle;
    @FXML
    private Label angerLabel;

    private Alice alice;

    public AliceSidebar() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/AliceSidebar.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AliceSidebar(Alice alice) {
        this.alice = alice;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/AliceSidebar.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        updateAliceImage();
        setAngerLabel();
    }

    public void setAlice(Alice alice) {
        this.alice = alice;
        updateAliceImage();
        setAngerLabel();
    }

    public void setAngerLabel() {
        Platform.runLater(() -> {
            angerLabel.setText(alice.getAngerLevel().name());
        });
    }

    public void updateAliceImage() {
        String imageUrl = alice.getImageUrl();
        Image image = new Image(Main.class.getResourceAsStream(imageUrl));
        imageCircle.setFill(new ImagePattern(image));
    }
}
