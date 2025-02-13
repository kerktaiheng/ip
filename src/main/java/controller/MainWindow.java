package controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private SplitPane mainSplitPane;
    @FXML
    private AnchorPane leftSidebar;
    @FXML
    private ScrollPane chatScrollPane;
    @FXML
    private VBox chatVBox;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Alice alice;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @FXML
    public void initialize() {
        chatScrollPane.vvalueProperty().bind(chatVBox.heightProperty());
        chatScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        chatVBox.prefWidthProperty().bind(chatScrollPane.widthProperty());
    }

    /**
     * Injects the Alice instance
     */
    public void setAlice(Alice alice) {
        this.alice = alice;
        alice.initialize();
        startListeningToAlice();
        System.out.println("Alice is ready!");
    }

    private void startListeningToAlice() {
        executorService.submit(() -> {
            try {
                while (true) {
                    Response response = alice.takeResponse();
                    javafx.application.Platform.runLater(() -> {
                        AliceDialogBox[] aliceDialogBoxes = AliceDialogBox.fromResponse(response);
                        chatVBox.getChildren().addAll(aliceDialogBoxes);
                    });
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
                Thread.sleep(1000);
                executorService.shutdown();
            } catch (InterruptedException e) {
            } finally {
                System.exit(0);
            }
        }
        userInput.clear();
    }

}
