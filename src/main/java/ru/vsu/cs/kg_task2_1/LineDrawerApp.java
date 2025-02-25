package ru.vsu.cs.kg_task2_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LineDrawerApp extends Application {
    private Canvas canvas;
    private GraphicsContext gc;
    private Line line;
    private boolean draggingStart = false;
    private boolean draggingEnd = false;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        // Инициализация отрезка
        Point start = new Point(100, 100);
        Point end = new Point(300, 300);
        line = new Line(start, end, Color.RED, Color.BLUE);

        // Обработка событий мыши
        canvas.setOnMousePressed(this::handleMousePressed);
        canvas.setOnMouseDragged(this::handleMouseDragged);
        canvas.setOnMouseReleased(this::handleMouseReleased);

        drawLine(); // Нарисовать отрезок при запуске

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("DDA Line Drawing with Color Interpolation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Нарисовать отрезок
    private void drawLine() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Очистить холст
        DDAAlgorithm.drawLine(line, gc);
    }

    // Обработка нажатия мыши
    private void handleMousePressed(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();
        Point mousePoint = new Point(mouseX, mouseY);

        // Проверяем, нажали ли на начало или конец отрезка
        if (line.getStart().isNear(mousePoint, 5)) {
            draggingStart = true;
        } else if (line.getEnd().isNear(mousePoint, 5)) {
            draggingEnd = true;
        }
    }

    // Обработка перемещения мыши
    private void handleMouseDragged(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();

        if (draggingStart) {
            line.setStart(new Point(mouseX, mouseY));
        } else if (draggingEnd) {
            line.setEnd(new Point(mouseX, mouseY));
        }

        drawLine(); // Перерисовываем отрезок
    }

    // Обработка отпускания мыши
    private void handleMouseReleased(MouseEvent event) {
        draggingStart = false;
        draggingEnd = false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}