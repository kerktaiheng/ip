package ui;

import java.util.Scanner;

import task.Task;
import task.TaskList;

public class Ui {

    private final Scanner SC = new Scanner(System.in);

    private String box(String message) {
        String[] lines = message.split("\n");
        int maxLength = 0;
        for (String line : lines) {
            maxLength = Math.max(maxLength, line.length());
        }
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append("//").append("=".repeat(maxLength + 2)).append("\\\\").append("\n");
        for (String line : lines) {
            sb.append("|| ").append(line).append(" ".repeat(maxLength - line.length())).append(" ||").append("\n");
        }
        sb.append("\\\\").append("=".repeat(maxLength + 2)).append("//").append("\n");
        return sb.toString();
    }

    /**
     * Displays the introduction message.
     */
    public void showIntro() {
        System.out.println(box(MessageGenerator.getIntroString()));
    }

    /**
     * Displays the goodbye message.
     */
    public void showGoodbye() {
        System.out.println(box(MessageGenerator.getGoodbyeString()));
    }

    /**
     * Displays a message indicating that a task has been added.
     *
     * @param task the task that was added
     * @param tasks the current list of tasks
     */
    public void showTaskAdded(Task task, TaskList tasks) {
        System.out.println(box(MessageGenerator.getTaskAddedString()));
        System.out.println(box(task.toString()));
    }

    /**
     * Displays a message indicating that a task has been marked as completed.
     *
     * @param task the task that was marked as completed
     */
    public void showTaskMarked(Task task) {
        System.out.println(box(MessageGenerator.getTaskMarkedString()));
        System.out.println(box(task.toString()));
    }

    /**
     * Displays a message indicating that a task has been unmarked as completed.
     *
     * @param task the task that was unmarked as completed
     */
    public void showTaskUnmarked(Task task) {
        System.out.println(box(MessageGenerator.getTaskUnmarkedString()));
        System.out.println(box(task.toString()));
    }

    /**
     * Displays a message indicating that a task has been deleted.
     *
     * @param task the task that was deleted
     * @param tasks the current list of tasks
     */
    public void showTaskDeleted(Task task, TaskList tasks) {
        System.out.println(box(MessageGenerator.getTaskDeletedString()));
        System.out.println(box(task.toString()));
        System.out.println(box(tasks.toString()));
    }

    /**
     * Displays the logo.
     */
    public void showLogo() {
        System.out.println(MessageGenerator.LOGO);
    }

    /**
     * Displays an error message.
     */
    public void showError() {
        System.out.println(box(MessageGenerator.getErrorMsg()));
    }

    /**
     * Displays the details of a task.
     *
     * @param task the task to display
     */
    public void showTask(Task task) {
        System.out.println(box(task.toString()));
    }

    /**
     * Displays the list of tasks.
     *
     * @param tasks the list of tasks to display
     */
    public void showTasks(TaskList tasks) {
        System.out.println(box(tasks.toString()));
    }

    /**
     * Reads a command from the user input.
     *
     * @return the command entered by the user
     */
    public String readCommand() {
        return SC.nextLine();
    }

}
