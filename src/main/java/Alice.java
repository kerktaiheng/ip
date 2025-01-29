import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alice {

    private List<Task> tasklist;
    private boolean isTestMode = false;

    public Alice() {
        this.tasklist = new ArrayList<>();
        isTestMode = false;
        initializeTasks();
    }

    public Alice(boolean isTestMode) {
        this.tasklist = new ArrayList<>();
        this.isTestMode = isTestMode;
        initializeTasks();
    }

    private void initializeTasks() {
        Path dirPath = Paths.get("data");
        Path filePath = dirPath.resolve("alice.txt");

        if (!isTestMode) {
            try {
                if (!Files.exists(dirPath)) {
                    Files.createDirectory(dirPath);
                }
                if (!Files.exists(filePath)) {
                    Files.createFile(filePath);
                } else {
                    List<String> lines = Files.readAllLines(filePath);
                    for (String line : lines) {
                        Task task = Task.parseTask(line);
                        tasklist.add(task);
                    }
                    System.out.println("Tasks read from file: " + tasklist);
                }
            } catch (IOException e) {
                System.err.println("Error initializing tasks: " + e.getMessage());
            }
        }
    }

    private void saveTasks() {
        Path dirPath = Paths.get("data");
        Path filePath = dirPath.resolve("alice.txt");

        try {
            List<String> lines = new ArrayList<>();
            for (Task task : tasklist) {
                lines.add(task.toDataString());
            }
            Files.write(filePath, lines);
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        Alice alice;
        Scanner sc = new Scanner(System.in);

        if (args.length > 0 && args[0].equals("test")) {
            alice = new Alice(true);
        } else {
            alice = new Alice();
        }   

        alice.initializeTasks();

        System.out.println(MessageGenerator.LOGO);
        System.out.println(MessageGenerator.getIntroString());

        while (sc.hasNextLine()) {
            System.out.println("");
            String input = sc.nextLine();
            String[] varargs = input.split("\\s+");
            if (varargs.length == 1 && varargs[0].equals("bye")) {
                System.out.println(MessageGenerator.getGoodbyeString());
                alice.saveTasks();
                break;
            } else if (varargs.length == 1 && varargs[0].equals(("list"))) {
                for (int i = 0; i < alice.tasklist.size(); i++) {
                    System.out.println(i + 1 + ". " +  alice.tasklist.get(i));
                }
                continue;
            } else if (varargs.length == 2 && varargs[0].equals("mark")) {
                try {
                    int index = Integer.parseInt(varargs[1]);
                    if (index > 0 && index <= alice.tasklist.size()) {
                        Task task = alice.tasklist.get(index - 1);
                        task.isMarked = true;
                        System.out.println(MessageGenerator.getTaskMarkedString());
                        System.out.println(alice.tasklist.get(index - 1));
                    } else {
                        System.out.println("Invalid index");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid index");
                }
                continue;
            } else if (varargs.length == 2 && varargs[0].equals("unmark")) {
                try {
                    int index = Integer.parseInt(varargs[1]);
                    if (index > 0 && index <= alice.tasklist.size()) {
                        Task task = alice.tasklist.get(index - 1);
                        task.isMarked = false;
                        System.out.println(MessageGenerator.getTaskUnmarkedString());
                        System.out.println(alice.tasklist.get(index - 1));
                    } else {
                        System.out.println("Invalid index");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid index");
                }
                continue;
            } else if (varargs.length == 2 && varargs[0].equals("delete")) {
                try {
                    int index = Integer.parseInt(varargs[1]);
                    if (index > 0 && index <= alice.tasklist.size()) {
                        Task task = alice.tasklist.get(index - 1);
                        System.out.println(MessageGenerator.getTaskUnmarkedString());
                        System.out.println(task);
                        alice.tasklist.remove(index - 1);
                    } else {
                        System.out.println("Invalid index");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid index");
                }
                continue;
            } else {
                StringBuilder sb;
                String name;
                String by;
                String from;
                String to;
                Task task = null;
                try{
                    switch (varargs[0]) {
                    case "todo":
                        sb = new StringBuilder();
                        for (int i = 1; i < varargs.length; i++) {
                            sb.append(varargs[i]);
                            sb.append(" ");
                        }
                        name = sb.toString().trim();
                        if (name.equals("")) {
                            throw new CommandFormatException();
                        }
                        task = new Todo(name);
                        break;
                    case "deadline":
                        sb = new StringBuilder();
                        int i = 1;
                        while (!varargs[i].equals("/by")) {
                            sb.append(varargs[i]);
                            sb.append(" ");
                            i++;
                        }
                        name = sb.toString().trim();
                        sb = new StringBuilder();
                        i++;
                        while (i < varargs.length) {
                            sb.append(varargs[i]);
                            sb.append(" ");
                            i++;
                        }
                        by = sb.toString().trim();
                        if (name.equals("") || by.equals("")) {
                            throw new CommandFormatException();
                        }
                        task = new Deadline(name, by);
                        break;
                    case "event":
                        sb = new StringBuilder();
                        int j = 1;
                        while (!varargs[j].equals("/from")) {
                            sb.append(varargs[j]);
                            sb.append(" ");
                            j++;
                        }
                        name = sb.toString().trim();
                        sb = new StringBuilder();
                        j++;
                        while (!varargs[j].equals("/to")) {
                            sb.append(varargs[j]);
                            sb.append(" ");
                            j++;
                        }
                        from = sb.toString().trim();
                        sb = new StringBuilder();
                        j++;
                        while (j < varargs.length) {
                            sb.append(varargs[j]);
                            sb.append(" ");
                            j++;
                        }
                        to = sb.toString().trim();
                        if (name.equals("") || from.equals("") || to.equals("")) {
                            throw new CommandFormatException();
                        }
                        task = new Event(name, from, to);
                        break;
                    default:
                        System.out.println(MessageGenerator.getErrorMsg());
                        break;
                    }
                } catch (CommandFormatException e) {
                    System.out.println(MessageGenerator.getErrorMsg());
                }
                if (task != null) {
                    alice.tasklist.add(task);
                    System.out.println(MessageGenerator.getGenericInsult());
                    System.out.println(task);
                }
            }
        }
        System.out.println();
        System.out.println("...come back soon");
    }
}
