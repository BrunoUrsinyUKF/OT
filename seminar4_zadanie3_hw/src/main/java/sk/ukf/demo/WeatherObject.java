package sk.ukf.demo;

import javafx.scene.shape.Shape;

public class WeatherObject {
    double x, y;
    Shape shape;

    void move() {
    }

    boolean isOut() {
        return x < -20 || x > Main.WIDTH + 20 || y > Main.HEIGHT + 20;
    }

    void update() {
        shape.setLayoutX(x);
        shape.setLayoutY(y);
    }
}
