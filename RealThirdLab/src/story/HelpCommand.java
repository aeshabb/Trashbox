package story;

import output.ConsolePrinter;

import java.util.List;

public class HelpCommand extends Story {
    private List<String> descriptionCommands;

    public HelpCommand(String description, ConsolePrinter consolePrinter, List<String> descriptionCommands) {
        super(description, consolePrinter);
        descriptionCommands.add(description);
        descriptionCommands.add("Завершить работу: \"quit\"");
        this.descriptionCommands = descriptionCommands;
    }

    @Override
    public void execute() {
        consolePrinter.printList(descriptionCommands);
    }
}
