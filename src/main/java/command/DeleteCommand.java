package command;

import exceptions.AliceException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param oneBasedIndex The one-based index of the task to delete.
     */
    public DeleteCommand(int oneBasedIndex) {
        this.index = oneBasedIndex - 1;
    }

    /**
     * Executes the delete command, removing the task and updating the storage.
     *
     * @param tasks The list of tasks.
     * @param ui The UI component.
     * @param storage The storage component.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Task task = tasks.getTask(index);
        tasks.deleteTask(index);
        ui.showTaskDeleted(task, tasks);
        storage.saveTasks(tasks);
    }

}
