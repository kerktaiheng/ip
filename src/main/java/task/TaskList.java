package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.InvalidIndexException;

public class TaskList {

    private final List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(List<Task> taskList) {
        this.taskList = new ArrayList<>();
        for (Task task : taskList) {
            this.taskList.add(task);
        }
    }

    public TaskList(Task... tasks) {
        this.taskList = new ArrayList<>();
        taskList.addAll(Arrays.asList(tasks));
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void deleteTask(int index) throws InvalidIndexException {
        if (index < 0 || index >= taskList.size()) {
            throw new InvalidIndexException();
        }
        this.taskList.remove(index);
    }

    public Task getTask(int index) throws InvalidIndexException {
        if (index < 0 || index >= taskList.size()) {
            throw new InvalidIndexException();
        }
        return this.taskList.get(index);
    }

    public List<Task> asList() {
        return this.taskList;
    }

    public int size() {
        return this.taskList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taskList.size(); i++) {
            sb.append(i + 1).append(". ").append(this.taskList.get(i)).append("\n");
        }
        return sb.toString();
    }

    public String toDataString() {
        StringBuilder sb = new StringBuilder();
        for (Task task : this.taskList) {
            sb.append(task.toDataString()).append("\n");
        }
        return sb.toString();
    }

}
