package command;

import java.time.LocalDateTime;

import exceptions.AliceException;
import storage.Storage;
import task.Event;
import task.TaskList;
import ui.Ui;

public class EventCommand extends Command {
    private final String name;
    private final LocalDateTime from;
    private final LocalDateTime to;

    /**
     * Constructs an EventCommand with the specified name, start time, and end
     * time.
     *
     * @param name The name of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public EventCommand(String name, LocalDateTime from, LocalDateTime to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes the event command.
     *
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @param storage The storage.
     * @throws AliceException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Event event = new Event(name, from, to);
        tasks.addTask(event);
        ui.showTaskAdded(event, tasks);
        storage.saveTasks(tasks);
    }

}
