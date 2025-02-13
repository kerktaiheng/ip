package model.response;

import utils.RandomUtils;

public class MessageGenerator {

    private static final String[] INTROS = {
        "what do u want",
        "im busy, make this quick",
        "i have so many better things to do",
        "i dont have all day",
        "i hate your guts",
        "i dont like you",
        "i dont want to talk to you",
        "i dont want to see you",
        "i dont want to hear from you",
        "screw off",
        "go away",
        "leave me alone",
        "i dont want to be your friend",
        "if i help you, will u leave?",
        "i dont want to be here",};

    private static final String[] GOODBYES = {
        "bye",
        "goodbye",
        "farewell",
        "good riddance",
        "finally",
        "see you never",
        "i hope i never see you again",
        "i hope i never hear from you again",
        "i hope i never talk to you again",
        "i hope i never have to deal with you again",
        "never return",};

    private static final String[] GENERIC_INSULTS = {
        "you are so annoying",
        "you are so stupid",
        "you are so dumb",
        "you are so slow",
        "you are so lazy",
        "you are so useless",
        "you are so boring",
        "you are so ugly",
        "you are so fat",
        "you are so weak",
        "you are so poor",
        "you are so bad",
        "you are so terrible",
        "you are so awful",
        "you are so horrible",
        "you are so disgusting",
        "you are so repulsive",
        "you are so revolting",
        "you are so abhorrent",
        "you are so despicable",
        "you are so detestable",
        "you are so contemptible",
        "you are so loathsome",
        "you are so vile",
        "you are so wretched",
        "you are so evil",
        "you are so wicked",
        "you are so malevolent",
        "you are so malicious",
        "you are so spiteful",
        "you are so mean",
        "you are so cruel",
        "you are so heartless",
        "you are so cold",
        "you are so callous",
        "you are so savage",
        "you are so useless",
        "you are so worthless",
        "you are so pointless",
        "you are so meaningless",
        "you are so insignificant",
        "you are so trivial",
        "you are so unimportant",
        "you are so irrelevant",
        "you are so perverted",
        "you are so depraved",
        "you are so degenerate",
        "you are so debased",
        "you are so corrupt",
        "you are so immoral",
        "you are so sinful",};

    private static final String[] LIST_TASKS_MSGS = GENERIC_INSULTS;

    private static final String[] TASK_ADDED_MSGS = GENERIC_INSULTS;

    private static final String[] TASK_MARKED_MSGS = {
        "wow, you finally did something",
        "congratulations, you did something",
        "you did something, wow",
        "you did something, amazing",
        "you did something, incredible",
        "congrats on being so productive",
        "congrats on being so efficient",
        "one small step for you, one giant leap for nobody",
        "great job, you did something",
        "i hope ure not too proud of yourself",
        "i hope you dont think you're special",
        "i hope you dont think you're important",
        "i hope you dont think you're valuable",
        "i hope you dont think you're useful",
        "i hope you dont think you're good",
        "work harder next time?",
        "do better next time?",};

    private static final String[] TASK_UNMARKED_MSGS = {
        "typical",
        "lazy as always",
        "slacking off again?",
        "you never learn",
        "you never improve",
        "you never change",
        "you never get better",
        "ull never be good",
        "ull never be useful",
        "ull never be valuable",
        "ull never be important",
        "this is why ure so bad",
        "this is why ure so terrible",
        "this is why ure so awful",
        "whats stopping u from working harder?",
        "whats stopping u from doing better?",
        "whats stopping u from improving?",
        "how r u so trash?",
        "how r u so bad?",
        "how r u so garbage?",
        "even kids can do better",
        "even cockroaches are more useful",
        "even rats are more valuable",
        "useless",
        "worthless",
        "pointless",
        "honestly expected at this point",
        "i knew u would fail",
        "i knew u would mess up",
        "i knew u would screw up",};

    private static final String[] TASK_DELETED_MSGS = TASK_UNMARKED_MSGS;

    //TODO: make distinct
    private static final String[] TASK_FOUND_MSGS = GENERIC_INSULTS;

    //TODO: add some helping for specific errors and some variety
    public static final String[] ERROR_MSGS = {
        "i dont understand",
        "i dont get it",
        "i dont know",
        "utterly incomprehensible",
        "completely incomprehensible",
        "what are you talking about?",
        "what are you saying?",
        "what are you doing?",
        "what are u blabbering about?",
        "what are u rambling about?",
        "what are you mumbling about?",
        "what nonsense is this?",
        "what rubbish is this?",
        "what garbage is this?",
        "just like you, completely useless",
        "why not just ask for help instead of pretending to know?",
        "why are u wasting my time with this nonsense?",
        "why are u wasting my time with this rubbish?",
        "i dont know what u mean",
        "i dont know what u want",
        "cant u speak properly?",
        "cant u communicate properly?",
        "cant u just follow the format of the command?",
        "what is so difficult to understand about the command?",
        "what is so difficult to understand about the format?",
        "the world has rules for a reason",
        "absolute nonsense",
        "absolute rubbish",
        "absolute garbage",
        "this doesnt make any sense",
        "this doesnt make any sense to me",
        "this doesnt make any sense to anyone",
        "how do u expect to do these tasks if u cant even follow the command format?",
        "huh???",
        "what???",
        "hello???",
        "eh???",
        "...r u ok?",
        "...i dont know what to say",
        "...i dont know what to do",};

    /**
     * Returns a random introduction message.
     *
     * @return a random introduction message
     */
    public static String getIntroString() {
        return INTROS[RandomUtils.getRandomInt(INTROS.length)];
    }

    /**
     * Returns a random goodbye message.
     *
     * @return a random goodbye message
     */
    public static String getGoodbyeString() {
        return GOODBYES[RandomUtils.getRandomInt(GOODBYES.length)];
    }

    /**
     * Returns a random generic insult.
     *
     * @return a random generic insult
     */
    public static String getGenericInsult() {
        return GENERIC_INSULTS[RandomUtils.getRandomInt(GENERIC_INSULTS.length)];
    }

    /**
     * Returns a random message indicating that a list of tasks has been found.
     *
     * @return a random message indicating that a list of tasks has been found
     */
    public static String getListTasksString() {
        return LIST_TASKS_MSGS[RandomUtils.getRandomInt(LIST_TASKS_MSGS.length)];
    }

    /**
     * Returns a random message indicating that a task has been added.
     *
     * @return a random message indicating that a task has been added
     */
    public static String getTaskAddedString() {
        return TASK_ADDED_MSGS[RandomUtils.getRandomInt(TASK_ADDED_MSGS.length)];
    }

    /**
     * Returns a random message indicating that a task has been marked as
     * completed.
     *
     * @return a random message indicating that a task has been marked as
     * completed
     */
    public static String getTaskMarkedString() {
        return TASK_MARKED_MSGS[RandomUtils.getRandomInt(TASK_MARKED_MSGS.length)];
    }

    /**
     * Returns a random message indicating that a task has been unmarked as
     * completed.
     *
     * @return a random message indicating that a task has been unmarked as
     * completed
     */
    public static String getTaskUnmarkedString() {
        return TASK_UNMARKED_MSGS[RandomUtils.getRandomInt(TASK_UNMARKED_MSGS.length)];
    }

    /**
     * Returns a random message indicating that a task has been deleted.
     *
     * @return a random message indicating that a task has been deleted
     */
    public static String getTaskDeletedString() {
        return TASK_DELETED_MSGS[RandomUtils.getRandomInt(TASK_DELETED_MSGS.length)];
    }

    /**
     * Returns a random message indicating that a task has been found.
     *
     * @return a random message indicating that a task has been found
     */
    public static String getTasksFoundString() {
        return TASK_FOUND_MSGS[RandomUtils.getRandomInt(TASK_FOUND_MSGS.length)];
    }

    /**
     * Returns a random error message.
     *
     * @return a random error message
     */
    public static String getErrorString() {
        return ERROR_MSGS[RandomUtils.getRandomInt(ERROR_MSGS.length)];
    }

}
