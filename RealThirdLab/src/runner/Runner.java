package runner;

import controller.Invoker;
import output.ConsolePrinter;
import reader.ReadCharacter;
import story.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    private Invoker invoker;

    public void runMethods() {
        initInvoker();
        runCommands();
    }

    private void initInvoker() {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        Map<String, Story> commandMap = fillStoryMap(consolePrinter);
        invoker = new Invoker(commandMap);
    }

    private Map<String, Story> fillStoryMap(ConsolePrinter consolePrinter) {
        Story ponchikStory = new PonchikStory("История Пончика: \"Ponchik\"", consolePrinter);
        Story mistressStory = new MistressStory("История Хозяйки: \"Mistress\"", consolePrinter);
        Story aliceStory = new AliceStory("История Алисы: \"Alice\"", consolePrinter);
        Story chefStory = new ChefStory("История Поварихи: \"Chef\"", consolePrinter);
        Story duchessStory = new DuchessStory("История Герцогини: \"Duchess\"", consolePrinter);
        Story showStack = new StoriesHistory("Вывести последние 5 историй: \"History\"", consolePrinter);

        Map<String, Story> storyMap = new HashMap<>();

        storyMap.put("Ponchik", ponchikStory);
        storyMap.put("Mistress", mistressStory);
        storyMap.put("Alice", aliceStory);
        storyMap.put("Chef", chefStory);
        storyMap.put("Duchess", duchessStory);
        storyMap.put("History", showStack);

        Story help = new HelpCommand("Вывести список персонажей: \"help\"", consolePrinter, createDescriptionMap(storyMap));
        storyMap.put("help", help);

        return storyMap;
    }

    private List<String> createDescriptionMap(Map<String, Story> commandMap) {
        List<String> descriptionList = new ArrayList<>();
        for (String key : commandMap.keySet()) {
            descriptionList.add(commandMap.get(key).getDescription());
        }
        return descriptionList;
    }

    private void runCommands() {
        invoker.executeCommand("help");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ReadCharacter readCommands = new ReadCharacter(br);
        String line;
        while (!("quit").equals(line = readCommands.readConsoleString())) {
            invoker.executeCommand(line);
        }
        readCommands.stopStream();
    }
}
