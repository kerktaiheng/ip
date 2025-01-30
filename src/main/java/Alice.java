
import command.Command;
import command.Parser;
import exceptions.AliceException;
import exceptions.AliceExit;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public class Alice {

    private TaskList tasks;
    private final Ui ui;
    private final Storage storage;
    private boolean isTestMode = false;

    public Alice() {
        this.tasks = new TaskList();
        this.ui = new Ui();
        this.storage = new Storage();
        isTestMode = false;
    }

    public Alice(boolean isTestMode) {
        this.tasks = new TaskList();
        this.ui = new Ui();
        this.storage = new Storage();
        this.isTestMode = isTestMode;
    }

    public void run() {
        ui.showIntro();
        try {
            this.tasks = storage.loadTasks();
        } catch (AliceException e) {
            ui.showError();
        }
        while (true) {
            String commandString = ui.readCommand();
            Command command;
            try {
                command = Parser.parseCommand(commandString);
                command.execute(tasks, ui, storage);
            } catch (AliceExit e) {
                ui.showGoodbye();
                break;
            } catch (AliceException e) {
                ui.showError();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("test")) {
            new Alice(true).run();
        } else {
            new Alice().run();
        }
    }
}
