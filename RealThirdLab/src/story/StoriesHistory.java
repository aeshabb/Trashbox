package story;

import newStructure.MyStack;
import output.ConsolePrinter;

public class StoriesHistory extends Story {
    private final MyStack<String> storiesHistory = new MyStack<>();

    public StoriesHistory(String description, ConsolePrinter consolePrinter) {
        super(description, consolePrinter);
    }

    @Override
    public void execute() {
        if (storiesHistory.size() >= 5) {
            consolePrinter.printList(storiesHistory.subList(storiesHistory.size() - 5, storiesHistory.size()));
        } else {
            consolePrinter.printStack(storiesHistory);
        }
    }

    public void addStory(String name) {
        storiesHistory.push(name);
    }
}
