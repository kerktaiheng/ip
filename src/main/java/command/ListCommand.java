package command;

import exceptions.AliceException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    /**
     * Executes the list command.
     *
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @param storage The storage.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        ui.showTasks(tasks);
    }

}
