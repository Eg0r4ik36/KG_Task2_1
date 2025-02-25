package ru.vsu.cs.kg_task2_1;

import javafx.scene.paint.Color;

public class Line {
    private Point start;
    private Point end;
    private Color startColor;
    private Color endColor;

    public Line(Point start, Point end, Color startColor, Color endColor) {
        this.start = start;
        this.end = end;
        this.startColor = startColor;
        this.endColor = endColor;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Color getStartColor() {
        return startColor;
    }

    public Color getEndColor() {
        return endColor;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
