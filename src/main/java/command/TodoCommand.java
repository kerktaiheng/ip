package command;

import exceptions.AliceException;
import storage.Storage;
import task.Task;
import task.TaskList;
import task.Todo;
import ui.Ui;

/**
 * Represents a command to add a new todo task.
 */
public class TodoCommand extends Command {
    private final String name;

    /**
     * Constructs a TodoCommand with the specified task name.
     *
     * @param name The name of the todo task.
     */
    public TodoCommand(String name) {
        this.name = name;
    }

    /**
     * Executes the todo command, adding the task and updating the storage.
     *
     * @param tasks The list of tasks.
     * @param ui The UI component.
     * @param storage The storage component.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Task task = new Todo(name);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks);
        storage.saveTasks(tasks);
    }
}
