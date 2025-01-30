package command;

import exceptions.AliceException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        ui.showTasks(tasks);
    }

}
