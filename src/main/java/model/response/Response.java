package model.response;

import utils.ArrayUtils;

/**
 * Represents a response from Alice.
 */
public class Response {

    public static enum RESPONSE_TYPE {
        INTRO, TASK_ADDED, TASK_DELETED, TASK_MARKED, TASK_UNMARKED, LIST_TASKS, TASKS_FOUND, GOODBYE, ERROR, 
        GENERIC_INSULT
    }

    private final String[] messages;

    public Response(RESPONSE_TYPE type, String... messages) {
        String firstMessage = switch(type) {
            case INTRO -> MessageGenerator.getIntroString();
            case TASK_ADDED -> MessageGenerator.getTaskAddedString();
            case TASK_DELETED -> MessageGenerator.getTaskDeletedString();
            case TASK_MARKED -> MessageGenerator.getTaskMarkedString();
            case TASK_UNMARKED -> MessageGenerator.getTaskUnmarkedString();
            case LIST_TASKS -> MessageGenerator.getListTasksString();
            case TASKS_FOUND -> MessageGenerator.getTasksFoundString();
            case GOODBYE -> MessageGenerator.getGoodbyeString();
            case ERROR -> MessageGenerator.getErrorString();
            case GENERIC_INSULT -> MessageGenerator.getGenericInsult();
        };
        this.messages = ArrayUtils.prepend(messages, firstMessage);
    }

    public Response(String... messages) {
        this.messages = messages;
    }

    public String[] getMessages() {
        return messages;
    }

}
