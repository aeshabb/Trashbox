package timeline;

import output.ConsolePrinter;

public class Day {
    private DayTime dayTime;

    public Day(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime, ConsolePrinter consolePrinter) {
        this.dayTime = dayTime;
        consolePrinter.printLine("It's " + dayTime.name() + " now");
    }
}
