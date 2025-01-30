package storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import exceptions.StorageDecodeException;
import exceptions.StorageIOException;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.Todo;
import utils.DateTimeUtils;

public class Storage {
    private static final String DEFAULT_DIR_PATH = "data";
    private static final String DEFAULT_FILE_PATH = "alice.txt";

    private final String dir;
    private final String file;

    public Storage() {
        this.dir = DEFAULT_DIR_PATH;
        this.file = DEFAULT_FILE_PATH;
    }

    public Storage(String dir, String file) {
        this.dir = dir;
        this.file = file;
    }
    
    public TaskList loadTasks() throws StorageIOException {
        Path dirPath = Paths.get(this.dir);
        Path filePath = dirPath.resolve(this.file);
        TaskList tasks = new TaskList();
        List<String> lines;

        try {
            if (!Files.exists(dirPath)) {
                Files.createDirectory(dirPath);
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            } 
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new StorageIOException();
        }

        for (String line : lines) {
            try {
                Task task = decodeTask(line);
                tasks.addTask(task);
            } catch (StorageDecodeException e) {
                continue;
            }
        }

        return tasks;
    }

    public void saveTasks(TaskList tasks) throws StorageIOException {
        Path dirPath = Paths.get(this.dir);
        Path filePath = dirPath.resolve(this.file);

        try {
            Files.write(filePath, tasks.toDataString().getBytes());
        } catch (IOException e) {
            throw new StorageIOException();
        }
    }

    public void deleteFile() throws StorageIOException {
        Path dirPath = Paths.get(this.dir);
        Path filePath = dirPath.resolve(this.file);

        try {
            Files.delete(filePath);
        } catch (IOException e) {
            throw new StorageIOException();
        }
    }

    public static Task decodeTask(String taskString) throws StorageDecodeException {
        String[] taskParts = taskString.split("\\|");
        boolean isMarked = taskParts[1].equals("1");
        String name = taskParts[2];
        switch(taskParts[0]) {
            case "T" -> {
            return new Todo(name, isMarked);
            }
            case "D" -> {
                LocalDateTime by = DateTimeUtils.parseDateTime(taskParts[3]);
            return new Deadline(name, by, isMarked);
            }
            case "E" -> {
                LocalDateTime from = DateTimeUtils.parseDateTime(taskParts[3]);
                LocalDateTime to = DateTimeUtils.parseDateTime(taskParts[4]);
            return new Event(name, from, to, isMarked);
            }
            default ->
                throw new StorageDecodeException();
        }
    }

}
