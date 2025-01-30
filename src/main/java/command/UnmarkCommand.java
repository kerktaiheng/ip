package command;

import exceptions.AliceException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command to unmark a task as not done.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param oneBasedIndex The one-based index of the task to unmark.
     */
    public UnmarkCommand(int oneBasedIndex) {
        this.index = oneBasedIndex - 1;
    }

    /**
     * Executes the unmark command, unmarking the task and updating the storage.
     *
     * @param tasks The list of tasks.
     * @param ui The UI component.
     * @param storage The storage component.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Task task = tasks.getTask(index);
        task.unmark();
        ui.showTaskUnmarked(task);
        storage.saveTasks(tasks);
    }
}
