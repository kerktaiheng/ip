package command;

import task.Task;
import task.TaskList;
import ui.Ui;
import storage.Storage;
import exceptions.AliceException;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int oneBasedIndex) {
        this.index = oneBasedIndex - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Task task = tasks.getTask(index);
        tasks.deleteTask(index);
        ui.showTaskDeleted(task, tasks);
        storage.saveTasks(tasks);
    }

}
