package timeline;

public class Day {
    private DayTime dayTime;

    public Day(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }
}
