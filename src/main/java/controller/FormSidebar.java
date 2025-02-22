package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FormSidebar extends VBox {

    @FXML
    private Label taskTypeLabel;
    @FXML
    private ToggleButton todoButton;
    @FXML
    private ToggleButton deadlineButton;
    @FXML
    private ToggleButton eventButton;
    @FXML
    private Button addButton;
    @FXML
    private StackPane formPane;

    private TodoInput todoInput = new TodoInput();
    private DeadlineInput deadlineInput = new DeadlineInput();
    private EventInput eventInput = new EventInput();

    private MainWindow mainWindow;

    private enum TaskType {
        TODO, DEADLINE, EVENT
    }

    private TaskType selectedTaskType = TaskType.TODO;

    public FormSidebar(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/FormSidebar.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
        }
        this.selectedTaskType = TaskType.TODO;
        onTodoButtonAction();
    }

    private void updateTaskButtons() {
        todoButton.setSelected(selectedTaskType == TaskType.TODO);
        deadlineButton.setSelected(selectedTaskType == TaskType.DEADLINE);
        eventButton.setSelected(selectedTaskType == TaskType.EVENT);
    }

    @FXML
    private void onTodoButtonAction() {
        selectedTaskType = TaskType.TODO;
        formPane.getChildren().clear();
        formPane.getChildren().add(todoInput);
        updateTaskButtons();
    }

    @FXML
    private void onDeadlineButtonAction() {
        selectedTaskType = TaskType.DEADLINE;
        formPane.getChildren().clear();
        formPane.getChildren().add(deadlineInput);
        updateTaskButtons();
    }

    @FXML
    private void onEventButtonAction() {
        selectedTaskType = TaskType.EVENT;
        formPane.getChildren().clear();
        formPane.getChildren().add(eventInput);
        updateTaskButtons();
    }

    @FXML
    private void onAddButtonAction() {
        switch (selectedTaskType) {
            case TODO -> {
                mainWindow.handleUserInput(todoInput.generateInput());
            }
            case DEADLINE -> {
                mainWindow.handleUserInput(deadlineInput.generateInput());
            }
            case EVENT -> {
                mainWindow.handleUserInput(eventInput.generateInput());
            }
        }
        todoInput.clear();
        deadlineInput.clear();
        eventInput.clear();
    }
}
