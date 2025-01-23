import java.util.ArrayList;
import java.util.List;

public class Alice {
    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();
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
        while (true) {
            System.out.println();
            String input = System.console().readLine();
            String[] varargs = input.split("\\s+");
            if (varargs.length == 1 && varargs[0].equals("bye")) {
                break;
            } 
            if (varargs.length == 1 && varargs[0].equals(("list"))) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + ". " + "[" +
                        (list.get(i).isDone ? "X" : " ") +
                        "] " + list.get(i).name);
                }
                continue;
            }
            if (varargs.length == 2 && varargs[0].equals("mark")) {
                try {
                    int index = Integer.parseInt(varargs[1]);
                    if (index > 0 && index <= list.size()) {
                        list.set(index - 1, new Task(list.get(index - 1).name));
                        System.out.println("Nice! I've marked this task as done:\n");
                        System.out.println("[X] " + list.get(index - 1).name);
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
            if (varargs.length == 2 && varargs[0].equals("unmark")) {
                try {
                    int index = Integer.parseInt(varargs[1]);
                    if (index > 0 && index <= list.size()) {
                        list.set(index - 1, new Task( list.get(index - 1).name));
                        System.out.println("Please stop slacking off: " + 
                            "[ ] " + list.get(index - 1).name);
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
                list.add(new Task(input));
                System.out.println("Task added: " + input + "\n");
            }
        }
        System.out.println();
        System.out.println("See you soon!");
    }
}
