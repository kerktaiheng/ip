package task;

import java.util.ArrayList;
import java.util.List;
import exceptions.InvalidIndexException;

public class TaskList {

    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public TaskList(List<Task> taskList) {
        taskList = new ArrayList<>();
        for (Task task : taskList) {
            taskList.add(task);
        }
    }

    public TaskList(Task... tasks) {
        taskList = new ArrayList<>();
        for (Task task : tasks) {
            taskList.add(task);
        }
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int index) throws InvalidIndexException {
        if (index < 0 || index >= taskList.size()) {
            throw new InvalidIndexException();
        }
        taskList.remove(index);
    }

    public Task getTask(int index) throws InvalidIndexException {
        if (index < 0 || index >= taskList.size()) {
            throw new InvalidIndexException();
        }
        return taskList.get(index);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taskList.size(); i++) {
            sb.append(i + 1).append(". ").append(taskList.get(i)).append("\n");
        }
        return sb.toString();
    }

    public String toDataString() {
        StringBuilder sb = new StringBuilder();
        for (Task task : taskList) {
            sb.append(task.toDataString()).append("\n");
        }
        return sb.toString();
    }

}
