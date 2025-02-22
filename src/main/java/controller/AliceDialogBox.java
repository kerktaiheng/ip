package controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXMLLoader;
import model.response.Response;

public class AliceDialogBox extends DialogBox {

    private AliceDialogBox(String message, String name, String imageUrl) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/AliceDialogBox.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
        }
        this.fill(message, name, imageUrl);
    }

    public static AliceDialogBox of(String input) {
        return of(input, DEFAULT_ALICE_NAME, DEFAULT_ALICE_IMAGE);
    }

    public static AliceDialogBox of(String input, String imageUrl) {
        return of(input, DEFAULT_ALICE_NAME, imageUrl);
    }

    public static AliceDialogBox of(String input, String name, String imageUrl) {
        return new AliceDialogBox(input, name, imageUrl);
    }

    public static AliceDialogBox[] fromResponse(Response response) {
        return List.of(response.getMessages()).stream()
                .map(AliceDialogBox::of)
                .toArray(AliceDialogBox[]::new);
    }

    public static AliceDialogBox[] fromResponse(Response response, String imageUrl) {
        return List.of(response.getMessages()).stream()
                .map(resp -> AliceDialogBox.of(resp, imageUrl))
                .toArray(AliceDialogBox[]::new);
    }

}
