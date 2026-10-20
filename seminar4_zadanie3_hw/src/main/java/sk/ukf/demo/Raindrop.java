package sk.ukf.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Raindrop extends WeatherObject {

    static boolean stopped = false;

    Raindrop(double x, double y) {
        this.x = x;
        this.y = y;
        Line line = new Line(0, 0, 0, 12);
        line.setStroke(Color.DEEPSKYBLUE);
        line.setStrokeWidth(2);
        shape = line;
    }

    @Override
    void move() {
        if (!stopped) {
            y += 6;
        }
    }
}
