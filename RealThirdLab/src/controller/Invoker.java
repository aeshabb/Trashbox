package controller;

import story.StoriesHistory;
import story.Story;

import java.util.Map;

public class Invoker {
    private final Map<String, Story> stories;
    private final StoriesHistory storiesHistory;

    public Invoker(Map<String, Story> stories) {
        this.stories = stories;
        storiesHistory = (StoriesHistory) stories.get("History");
    }

    public void executeCommand(String characterName) {
        if (stories.containsKey(characterName)) {
            Story story = stories.get(characterName);
            if (characterName.equals("Alice") || characterName.equals("Chef") || characterName.equals("Duchess") || characterName.equals("Mistress") || characterName.equals("Ponchik")) {
                storiesHistory.addStory(characterName);
            }
            story.execute();

        } else {
            System.out.println("Неверная команда");
        }
    }

}
