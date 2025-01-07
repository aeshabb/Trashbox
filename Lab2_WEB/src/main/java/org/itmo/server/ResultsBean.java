package org.itmo.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultsBean implements Serializable {

    // Класс для представления одного результата
    public static class Result {
        private final double x;
        private final double y;
        private final double radius;
        private final boolean inArea;
        private final long executionTime;
        private final long timestamp;



        public Result(double x, double y, double radius, boolean inArea, long executionTime) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.inArea = inArea;
            this.executionTime = executionTime;
            this.timestamp = System.currentTimeMillis();

        }

        public double getX() { return x; }
        public double getY() { return y; }
        public double getRadius() { return radius; }
        public boolean isInArea() { return inArea; }
        public long getExecutionTime() { return executionTime; }
        public long getTimestamp() { return timestamp; }
    }

    // Список для хранения всех результатов
    private final List<Result> results = new ArrayList<>();

    // Метод для добавления нового результата
    public void addResult(double x, double y, double radius, boolean inArea, long executionTime) {
        results.add(new Result(x, y, radius, inArea, executionTime));
    }

    // Метод для получения списка всех результатов
    public List<Result> getResults() {
        return results;
    }

    // Метод для очистки всех результатов
    public void clearResults() {
        results.clear();
    }
}