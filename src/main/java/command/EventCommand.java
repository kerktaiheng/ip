package command;

import task.Event;
import task.TaskList;
import ui.Ui;
import storage.Storage;
import java.time.LocalDateTime;
import exceptions.AliceException;

public class EventCommand extends Command {
    private String name;
    private LocalDateTime from;
    private LocalDateTime to;

    public EventCommand(String name, LocalDateTime from, LocalDateTime to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        Event event = new Event(name, from, to);
        tasks.addTask(event);
        ui.showTaskAdded(event, tasks);
        storage.saveTasks(tasks);
    }

}
