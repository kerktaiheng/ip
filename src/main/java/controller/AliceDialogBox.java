package controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.response.Response;

public class AliceDialogBox extends HBox {

    private static final String DEFAULT_ALICE = "alice";
    private static final String DEFAULT_IMAGE = "images/defaultuser.jpg";

    @FXML
    private Circle imageCircle;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea messageArea;

    private AliceDialogBox(String message, String name, String imageUrl) {
        FXMLLoader fxmlLoader = new FXMLLoader(AliceDialogBox.class.getResource("fxml/AliceDialogBox.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
        }
        nameField.setText(name);
        messageArea.setText(message);
        imageCircle.setFill(new ImagePattern(new Image(AliceDialogBox.class.getResourceAsStream(imageUrl))));
    }

    public static AliceDialogBox of(String input) {
        return of(input, DEFAULT_ALICE, DEFAULT_IMAGE);
    }

    public static AliceDialogBox of(String input, String name, String imageUrl) {
        return new AliceDialogBox(input, name, imageUrl);
    }

    public static AliceDialogBox[] fromResponse(Response response) {
        return List.of(response.getMessages()).stream()
                .map(AliceDialogBox::of)
                .toArray(AliceDialogBox[]::new);
    }

}
