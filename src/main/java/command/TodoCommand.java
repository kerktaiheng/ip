package command;

import task.Task;
import task.TaskList;
import task.Todo;
import ui.Ui;
import exceptions.AliceException;
import storage.Storage;

public class TodoCommand extends Command {
    private String name;

    public TodoCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Task task = new Todo(name);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks);
        storage.saveTasks(tasks);
    }
}
