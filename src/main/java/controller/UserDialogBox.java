package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class UserDialogBox extends DialogBox {

    private UserDialogBox(String input, String name, String imageUrl) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/UserDialogBox.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
        }
        this.fill(input, name, imageUrl);
    }

    public static UserDialogBox of(String input) {
        return of(input, DEFAULT_USER_NAME, DEFAULT_USER_IMAGE);
    }

    public static UserDialogBox of(String input, String name, String imageUrl) {
        return new UserDialogBox(input, name, imageUrl);
    }

}
