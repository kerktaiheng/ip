package command;

import exceptions.AliceException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command that can be executed.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @param storage The storage.
     * @throws AliceException If an error occurs during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException;

}
