package command;

import java.util.List;
import java.util.stream.Collectors;

import exceptions.AliceException;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.BoundExtractedResult;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws AliceException {
        List<Task> taskList = tasks.asList();
        List<BoundExtractedResult<Task>> match = FuzzySearch.extractTop(keyword, taskList, Task::toString, 10);
        List<Task> matchTaskList = match.stream().map(BoundExtractedResult::getReferent).collect(Collectors.toList());
        TaskList matchTasks = new TaskList(matchTaskList);
        ui.showTasksFound(matchTasks);
    }
}
