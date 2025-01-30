package command;

import java.time.LocalDateTime;

import exceptions.AliceException;
import storage.Storage;
import task.Deadline;
import task.TaskList;
import ui.Ui;

public class DeadlineCommand extends Command {
    private final String name;
    private final LocalDateTime by;

    /**
     * Constructs a DeadlineCommand with the specified name and deadline.
     *
     * @param name The name of the deadline.
     * @param by The deadline date and time.
     */
    public DeadlineCommand(String name, LocalDateTime by) {
        this.name = name;
        this.by = by;
    }

    /**
     * Executes the deadline command.
     *
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @param storage The storage.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException{
        Deadline deadline = new Deadline(name, by);
        tasks.addTask(deadline);
        ui.showTaskAdded(deadline, tasks);
        storage.saveTasks(tasks);
    }

}
