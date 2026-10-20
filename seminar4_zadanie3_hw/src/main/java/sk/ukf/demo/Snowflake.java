package sk.ukf.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Snowflake extends WeatherObject {

    double angle = Math.random() * 6;

    Snowflake(double x, double y) {
        this.x = x;
        this.y = y;
        shape = new Circle(0, 0, 4);
        shape.setFill(Color.WHITE);
    }

    @Override
    void move() {
        y += 1.5;                        // pomalšie než kvapka (6)
        angle += 0.05;
        x += Math.sin(angle) * 0.7;      // kývanie doľava a doprava
    }
}
