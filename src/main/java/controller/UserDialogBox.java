package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class UserDialogBox extends HBox {

    private static final String DEFAULT_USER = "annoyinguser";
    private static final String DEFAULT_IMAGE = "images/defaultuser.jpg";

    @FXML
    private Circle imageCircle;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea inputArea;

    private UserDialogBox(String input, String name, String imageUrl) {
        FXMLLoader fxmlLoader = new FXMLLoader(UserDialogBox.class.getResource("fxml/UserDialogBox.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
        }
        nameField.setText(name);
        inputArea.setText(input);
        imageCircle.setFill(new ImagePattern(new Image(this.getClass().getResourceAsStream(imageUrl))));
    }

    public static UserDialogBox of(String input) {
        return of(input, DEFAULT_USER, DEFAULT_IMAGE);
    }

    public static UserDialogBox of(String input, String name, String imageUrl) {
        return new UserDialogBox(input, name, imageUrl);
    }

}
