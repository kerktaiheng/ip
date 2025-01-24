import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alice {
    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        final String ERRORMSG = "Huh????";
        String logo = 
            "   ,---,        ,--,                                 \n" +
            "  '  .' \\     ,--.'|     ,--,                        \n" +
            " /  ;    '.   |  | :   ,--.'|                        \n" +
            ":  :       \\  :  : '   |  |,                         \n" +
            ":  |   /\\   \\ |  ' |   `--'_       ,---.     ,---.   \n" +
            "|  :  ' ;.   :'  | |   ,' ,'|     /     \\   /     \\  \n" +
            "|  |  ;/  \\   \\  | :   '  | |    /    / '  /    /  | \n" +
            "'  :  | \\  \\ ,'  : |__ |  | :   .    ' /  .    ' / | \n" +
            "|  |  '  '--' |  | '.'|'  : |__ '   ; :__ '   ;   /| \n" +
            "|  :  :       ;  :    ;|  | '.'|'   | '.'|'   |  / | \n" +
            "|  | ,'       |  ,   / ;  :    ;|   :    :|   :    | \n" +
            "`--''          ---`-'  |  ,   /  \\   \\  /  \\   \\  /  \n" +
            "                        ---`-'    `----'    `----'   \n";
        System.out.println("Hello from\n\n" + logo + "\n\n");
        System.out.println("What can I do for you today?\n");
        while (sc.hasNextLine()) {
            System.out.println("");
            String input = sc.nextLine();
            String[] varargs = input.split("\\s+");
            if (varargs.length == 1 && varargs[0].equals("bye")) {
                break;
            } else if (varargs.length == 1 && varargs[0].equals(("list"))) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + ". " +  list.get(i));
                }
                continue;
            } else if (varargs.length == 2 && varargs[0].equals("mark")) {
                try {
                    int index = Integer.parseInt(varargs[1]);
                    if (index > 0 && index <= list.size()) {
                        Task task = list.get(index - 1);
                        task.isDone = true;
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(list.get(index - 1));
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
                    if (index > 0 && index <= list.size()) {
                        Task task = list.get(index - 1);
                        task.isDone = false;
                        System.out.println("Please stop slacking off:");
                        System.out.println(list.get(index - 1));
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
                    if (index > 0 && index <= list.size()) {
                        Task task = list.get(index - 1);
                        System.out.println("Can't wait to hear your sh*tty excuse this time:");
                        System.out.println(list.get(index - 1));
                        list.remove(index - 1);
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                    } else {
                        System.out.println("Invalid index");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid index");
                }
                continue;
            }
            else {
                StringBuilder sb;
                String name;
                String by;
                String from;
                String to;
                switch (varargs[0]) {
                    case "todo":
                        sb = new StringBuilder();
                        for (int i = 1; i < varargs.length; i++) {
                            sb.append(varargs[i]);
                            sb.append(" ");
                        }
                        name = sb.toString().trim();
                        if (name.equals("")) {
                            System.out.println(ERRORMSG);
                            break;
                        }
                        Todo todo = new Todo(name);
                        list.add(todo);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(todo);
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
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
                            System.out.println(ERRORMSG);
                            break;
                        }
                        Deadline deadline = new Deadline(name, by);
                        list.add(deadline);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(deadline);
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
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
                            System.out.println(ERRORMSG);
                            break;
                        }
                        Event event = new Event(name, from, to);
                        list.add(event);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(event);
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                        break;
                    default:
                        System.out.println(ERRORMSG);
                        break;
                }
            }
        }
        System.out.println();
        System.out.println("See you soon!");
    }
}
