import command.Command;
import command.Parser;
import exceptions.AliceException;
import exceptions.AliceExit;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * The main class for the Alice application.
 */
public class Alice {

    private TaskList tasks;
    private final Ui ui;
    private final Storage storage;

    /**
     * Constructs an Alice object and initializes the task list, UI, and
     * storage.
     */
    public Alice() {
        this.tasks = new TaskList();
        this.ui = new Ui();
        this.storage = new Storage();
    }

    /**
     * Runs the Alice application. Displays the introduction message, loads
     * tasks from storage, and processes user commands in a loop until an exit
     * command is received.
     */
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

    /**
     * The main method to start the Alice application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new Alice().run();
    }
}
