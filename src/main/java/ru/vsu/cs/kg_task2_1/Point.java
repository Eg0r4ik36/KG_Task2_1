package ru.vsu.cs.kg_task2_1;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Проверка, находится ли точка рядом с другой точкой
    public boolean isNear(Point other, double radius) {
        return Math.hypot(this.x - other.getX(), this.y - other.getY()) <= radius;
    }
}
