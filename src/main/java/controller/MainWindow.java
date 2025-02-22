package controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Alice;
import model.exception.AliceExit;
import model.response.Response;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends VBox {

    @FXML
    private StackPane leftSidebar;
    @FXML
    private ScrollPane chatScrollPane;
    @FXML
    private VBox chatVBox;
    @FXML
    private TextField userInput;
    @FXML
    private StackPane rightSidebar;

    private Alice alice;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private AliceSidebar aliceSidebar = new AliceSidebar();

    @FXML
    public void initialize() {
        chatScrollPane.vvalueProperty().bind(chatVBox.heightProperty());
        chatScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        chatVBox.prefWidthProperty().bind(chatScrollPane.widthProperty());

        FormSidebar formSidebar = new FormSidebar(this);
        leftSidebar.getChildren().add(formSidebar);
        StackPane.setAlignment(formSidebar, Pos.TOP_CENTER);
    }

    /**
     * Injects the Alice instance
     */
    public void setAlice(Alice alice) {
        this.alice = alice;
        alice.initialize();

        aliceSidebar.setAlice(alice);
        rightSidebar.getChildren().add(aliceSidebar);
        StackPane.setAlignment(aliceSidebar, Pos.TOP_CENTER);

        startListeningToAlice();
        System.out.println("alice is ready (and more than excited to see you)");
    }

    private void startListeningToAlice() {
        executorService.submit(() -> {
            try {
                while (true) {
                    Response response = alice.takeResponse();
                    String imageUrl = alice.getImageUrl();
                    javafx.application.Platform.runLater(() -> {
                        AliceDialogBox[] aliceDialogBoxes = AliceDialogBox.fromResponse(response, imageUrl);
                        chatVBox.getChildren().addAll(aliceDialogBoxes);
                    });
                    aliceSidebar.updateAliceImage();
                    aliceSidebar.setAngerLabel();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    /**
     * Controller handler for user input.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        StackPane stackPane = new StackPane();
        UserDialogBox userDialogBox = UserDialogBox.of(input);
        stackPane.getChildren().add(userDialogBox);
        stackPane.prefWidthProperty().bind(chatVBox.widthProperty());
        StackPane.setAlignment(userDialogBox, Pos.BOTTOM_RIGHT);
        chatVBox.getChildren().add(stackPane);
        try {
            alice.run(input);
        } catch (AliceExit ex) {
            alice.quit();
            try {
                Thread.sleep(2000);
                executorService.shutdown();
            } catch (InterruptedException e) {
            } finally {
                System.exit(0);
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        userInput.clear();
    }

    protected void handleUserInput(String input) {
        userInput.setText(input);
        handleUserInput();
    }

    @FXML
    private void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            handleUserInput();
        }
    }

    protected Alice getAlice() {
        return this.alice;
    }

}
