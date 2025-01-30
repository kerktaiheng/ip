package command;

import exceptions.AliceException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private final int index;

    /**
     * Constructs a MarkCommand with the specified index.
     *
     * @param oneBasedIndex The one-based index of the task to mark.
     */
    public MarkCommand(int oneBasedIndex) {
        this.index = oneBasedIndex - 1;
    }

    /**
     * Executes the mark command.
     *
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @param storage The storage.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Task task = tasks.getTask(index);
        task.mark();
        ui.showTaskMarked(task);
        storage.saveTasks(tasks);
    }
}
