package command;

import exceptions.AliceException;
import exceptions.CommandFormatException;
import utils.ArrayUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Parser {

    private static final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static Command parseCommand(String input) throws AliceException {
        String[] args = input.split(" ");
        int numArgs = args.length;
        String command = args[0];
        switch (command) {
        case "bye":
            if (numArgs != 1) {
                throw new CommandFormatException();
            }
            return new ExitCommand();
        case "list":
            if (numArgs != 1) {
                throw new CommandFormatException();
            }
            return new ListCommand();
        case "mark":
            if (numArgs != 2) {
                throw new CommandFormatException();
            }
            try {
                int index = Integer.parseInt(args[1]);
                return new MarkCommand(index);
            } catch (NumberFormatException e) {
                throw new CommandFormatException();
            }
        case "unmark":
            if (numArgs != 2) {
                throw new CommandFormatException();
            }
            try {
                int index = Integer.parseInt(args[1]);
                return new UnmarkCommand(index);
            } catch (NumberFormatException e) {
                throw new CommandFormatException();
            }
        case "delete":
            if (numArgs != 2) {
                throw new CommandFormatException();
            }
            try {
                int index = Integer.parseInt(args[1]);
                return new DeleteCommand(index);
            } catch (NumberFormatException e) {
                throw new CommandFormatException();
            }
        case "todo":
            if (numArgs < 2) {
                throw new CommandFormatException();
            }
            String todoName = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
            return new TodoCommand(todoName);
        case "deadline":
            if (numArgs < 4) {
                throw new CommandFormatException();
            }
            String deadlineName = ArrayUtils.joinFromFind(args, " ", "deadline", "/by");
            String byString = ArrayUtils.joinFromFind(args, " ", "/by");
            try {
                LocalDateTime by = parseDateTime(byString);
                return new DeadlineCommand(deadlineName, by);
            } catch (Exception e) {
                throw new CommandFormatException();
            }
        case "event":
            if (numArgs < 6) {
                throw new CommandFormatException();
            }
            String eventName = ArrayUtils.joinFromFind(args, " ", "event", "/from");
            String fromString = ArrayUtils.joinFromFind(args, " ", "/from", "/to");
            String toString = ArrayUtils.joinFromFind(args, " ", "/to");
            try {
                LocalDateTime from = parseDateTime(fromString);
                LocalDateTime to = parseDateTime(toString);
                return new EventCommand(eventName, from, to);
            } catch (Exception e) {
                throw new CommandFormatException();
            }
        default:
            throw new CommandFormatException();
        }
    }

    private static LocalDateTime parseDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DATETIMEFORMATTER);
    }

    
}
