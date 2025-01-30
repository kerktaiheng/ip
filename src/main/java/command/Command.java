package command;

import exceptions.AliceException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException;

}
