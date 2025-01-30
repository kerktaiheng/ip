package command;

import exceptions.AliceException;
import exceptions.AliceExit;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public class ExitCommand extends Command {

    /**
     * Executes the exit command.
     *
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @param storage The storage.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        storage.saveTasks(tasks);
        throw new AliceExit();
    }

}
