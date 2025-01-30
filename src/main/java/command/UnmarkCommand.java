package command;

import exceptions.AliceException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int oneBasedIndex) {
        this.index = oneBasedIndex - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException{
        Task task = tasks.getTask(index);
        task.unmark();
        ui.showTaskUnmarked(task);
        storage.saveTasks(tasks);
    }
}
