package model.command;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import model.exception.AliceException;
import model.exception.CommandFormatException;

public class ParserTest {

    @Test
    public void parseCommand_byeCommand() throws AliceException {
        Command command = Parser.parseCommand("bye");
        assertTrue(command instanceof ExitCommand);
    }

    @Test
    public void parseCommand_listCommand() throws AliceException {
        Command command = Parser.parseCommand("list");
        assertTrue(command instanceof ListCommand);
    }

    @Test
    public void parseCommand_markCommand() throws AliceException {
        Command command = Parser.parseCommand("mark 1");
        assertTrue(command instanceof MarkCommand);
    }

    @Test
    public void parseCommand_unmarkCommand() throws AliceException {
        Command command = Parser.parseCommand("unmark 1");
        assertTrue(command instanceof UnmarkCommand);
    }

    @Test
    public void parseCommand_deleteCommand() throws AliceException {
        Command command = Parser.parseCommand("delete 1");
        assertTrue(command instanceof DeleteCommand);
    }

    @Test
    public void parseCommand_todoCommand() throws AliceException {
        Command command = Parser.parseCommand("todo read book");
        assertTrue(command instanceof TodoCommand);
    }

    @Test
    public void parseCommand_deadlineCommand() throws AliceException {
        Command command = Parser.parseCommand("deadline submit report /by 2023-12-31 23:59");
        assertTrue(command instanceof DeadlineCommand);
    }

    @Test
    public void parseCommand_eventCommand() throws AliceException {
        Command command = Parser.parseCommand("event project meeting /from 2023-12-01 10:00 /to 2023-12-01 12:00");
        assertTrue(command instanceof EventCommand);
    }

    @Test
    public void parseCommand_findCommand() throws AliceException {
        Command command = Parser.parseCommand("find book");
        assertTrue(command instanceof FindCommand);
    }

    @Test
    public void parseCommand_invalidCommand_throwsCommandFormatException() {
        assertThrows(CommandFormatException.class, () -> {
            Parser.parseCommand("invalid command");
        });
    }
}
