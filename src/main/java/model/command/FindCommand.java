package model.command;

import java.util.List;
import java.util.stream.Collectors;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.BoundExtractedResult;
import model.exception.AliceException;
import model.response.MessageGenerator;
import model.response.Response;
import model.storage.Storage;
import model.task.Task;
import model.task.TaskList;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public Response execute(TaskList tasks, Storage storage) throws AliceException {
        List<Task> taskList = tasks.asList();
        List<BoundExtractedResult<Task>> match = FuzzySearch.extractTop(keyword, taskList, Task::toString, 10);
        List<Task> matchTaskList = match.stream().map(BoundExtractedResult::getReferent).collect(Collectors.toList());
        TaskList matchTasks = new TaskList(matchTaskList);
        return new Response(MessageGenerator.getTasksFoundString(), matchTasks.toString());
    }
}
