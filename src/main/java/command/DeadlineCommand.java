package command;

import task.Deadline;
import task.TaskList;
import ui.Ui;
import storage.Storage;
import java.time.LocalDateTime;
import exceptions.AliceException;

public class DeadlineCommand extends Command {
    private String name;
    private LocalDateTime by;

    public DeadlineCommand(String name, LocalDateTime by) {
        this.name = name;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException{
        Deadline deadline = new Deadline(name, by);
        tasks.addTask(deadline);
        ui.showTaskAdded(deadline, tasks);
        storage.saveTasks(tasks);
    }

}
