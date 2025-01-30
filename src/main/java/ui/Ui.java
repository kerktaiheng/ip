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

    public void showIntro() {
        System.out.println(box(MessageGenerator.getIntroString()));
    }

    public void showGoodbye() {
        System.out.println(box(MessageGenerator.getGoodbyeString()));
    }

    public void showTaskAdded(Task task, TaskList tasks) {
        System.out.println(box(MessageGenerator.getTaskAddedString()));
        System.out.println(box(task.toString()));
    }

    public void showTaskMarked(Task task) {
        System.out.println(box(MessageGenerator.getTaskMarkedString()));
        System.out.println(box(task.toString()));
    }

    public void showTaskUnmarked(Task task) {
        System.out.println(box(MessageGenerator.getTaskUnmarkedString()));
        System.out.println(box(task.toString()));
    }

    public void showTaskDeleted(Task task, TaskList tasks) {
        System.out.println(box(MessageGenerator.getTaskDeletedString()));
        System.out.println(box(task.toString()));
        System.out.println(box(tasks.toString()));
    }

    public void showLogo() {
        System.out.println(MessageGenerator.LOGO);
    }

    public void showError() {
        System.out.println(box(MessageGenerator.getErrorMsg()));
    }

    public void showTask(Task task) {
        System.out.println(box(task.toString()));
    }

    public void showTasks(TaskList tasks) {
        System.out.println(box(tasks.toString()));
    }

    public String readCommand() {
        return SC.nextLine();
    }

}
