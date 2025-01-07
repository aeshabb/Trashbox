package org.itmo.server;

public class CheckHit {
    public static boolean checkIfInArea(double x, double y, double radius) {
        return (checkRectangle(x, y, radius) || checkCircle(x, y, radius) || checkTriangle(x, y, radius)) && validate(x, y, radius);
    }

    // Проверка попадания в квадрат в 1-й четверти
    private static boolean checkRectangle(double x, double y, double radius) {
        return (x >= 0 && y >= 0 && x <= radius && y <= radius);
    }

    // Проверка попадания в четверть круга во 2-й четверти
    private static boolean checkCircle(double x, double y, double radius) {
        return (x <= 0 && y >= 0 && Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2));
    }

    // Проверка попадания в треугольник в 3-й четверти
    private static boolean checkTriangle(double x, double y, double radius) {
        return (x <= 0 && y <= 0 && x >= -radius / 2 && y >= -radius / 2 && y >= 2 * x - radius);
    }

    // Валидация входных данных
    private static boolean validate(double x, double y, double radius) {
        return (x >= -5 && x <= 3 && y >= -5 && y <= 3 && radius >= 1 && radius <= 4);
    }
}
