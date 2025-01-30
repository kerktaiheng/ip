package command;

import exceptions.AliceException;
import exceptions.AliceExit;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException{
        storage.saveTasks(tasks);
        throw new AliceExit();
    }

}
