package model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import model.command.Command;
import model.command.Parser;
import model.exception.AliceException;
import model.exception.AliceExit;
import model.exception.StorageIOException;
import model.response.Response;
import model.response.Response.RESPONSE_TYPE;
import model.storage.Storage;
import model.task.TaskList;

/**
 * The main class for the Alice application.
 */
public class Alice {

    private TaskList tasks;
    private final Storage storage;
    private final BlockingQueue<Response> responseBuffer;

    /**
     * Constructs an Alice object and initializes the task list and storage.
     */
    public Alice() {
        this.tasks = new TaskList();
        this.storage = new Storage();
        this.responseBuffer = new LinkedBlockingQueue<>();
    }

    /**
     * Initializes the task list with the tasks stored in the storage.
     *
     * @throws StorageIOException If an error occurs during initialization.
     */
    public void initialize() {
        responseBuffer.clear();
        responseBuffer.add(new Response(RESPONSE_TYPE.INTRO));
        try {
            this.tasks = storage.loadTasks();
        } catch (StorageIOException e) {
            responseBuffer.add(new Response(RESPONSE_TYPE.ERROR)); 
        }
    }

    public void run(String input) throws AliceExit {
        try {
            Command command = Parser.parseCommand(input);
            Response response = command.execute(tasks, storage);
            responseBuffer.add(response);
        } catch (AliceExit e) {
            throw e;
        } catch (AliceException e) {
            responseBuffer.add(new Response(RESPONSE_TYPE.ERROR, e.getMessage()));
        }
    }

    public Response takeResponse() throws InterruptedException {
        return responseBuffer.take();
    }

    public void quit() {
        responseBuffer.add(new Response(RESPONSE_TYPE.GOODBYE));
    }

}
