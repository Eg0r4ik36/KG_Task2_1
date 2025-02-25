package ru.vsu.cs.kg_task2_1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DDAAlgorithm {
    public static void drawLine(Line line, GraphicsContext gc) {
        Point start = line.getStart();
        Point end = line.getEnd();
        Color startColor = line.getStartColor();
        Color endColor = line.getEndColor();

        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        double steps = Math.max(Math.abs(dx), Math.abs(dy));

        double xIncrement = dx / steps;
        double yIncrement = dy / steps;

        double x = start.getX();
        double y = start.getY();

        for (int i = 0; i <= steps; i++) {
            // Интерполяция цвета
            double t = i / steps;
            double red = startColor.getRed() * (1 - t) + endColor.getRed() * t;
            double green = startColor.getGreen() * (1 - t) + endColor.getGreen() * t;
            double blue = startColor.getBlue() * (1 - t) + endColor.getBlue() * t;
            Color interpolatedColor = new Color(red, green, blue, 1.0);

            // Рисуем пиксель
            gc.setFill(interpolatedColor);
            gc.fillRect(x, y, 1, 1);

            x += xIncrement;
            y += yIncrement;
        }

        // Рисуем круги на концах отрезка для визуализации точек перемещения
        gc.setFill(Color.BLACK);
        gc.fillOval(start.getX() - 5, start.getY() - 5, 10, 10); // Начало отрезка
        gc.fillOval(end.getX() - 5, end.getY() - 5, 10, 10); // Конец отрезка
    }
}
