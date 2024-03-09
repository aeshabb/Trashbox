package story;

import output.ConsolePrinter;

import java.util.Objects;

public abstract class Story {
    protected String description;
    protected ConsolePrinter consolePrinter;

    Story(String description, ConsolePrinter consolePrinter) {
        this.description = description;
        this.consolePrinter = consolePrinter;
    }

    abstract public void execute();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ConsolePrinter getPrinter() {
        return consolePrinter;
    }

    public void setPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Story story)) return false;
        return Objects.equals(getDescription(), story.getDescription()) && Objects.equals(consolePrinter, story.consolePrinter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), consolePrinter);
    }

    @Override
    public String toString() {
        return "Story{" +
                "description='" + description + '\'' +
                ", consolePrinter=" + consolePrinter +
                '}';
    }
}
