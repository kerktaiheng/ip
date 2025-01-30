package command;

import exceptions.AliceException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int oneBasedIndex) {
        this.index = oneBasedIndex - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Task task = tasks.getTask(index);
        task.mark();
        ui.showTaskMarked(task);
        storage.saveTasks(tasks);
    }
}
