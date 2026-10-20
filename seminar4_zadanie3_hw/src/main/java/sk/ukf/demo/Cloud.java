package sk.ukf.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Cloud extends WeatherObject {

    Cloud(double x, double y) {
        this.x = x;
        this.y = y;
        shape = new Ellipse(0, 0, 50, 25);
        shape.setFill(Color.LIGHTGRAY);
    }

    @Override
    void move() {
        x += 0.3;
        if (x > Main.WIDTH + 60) {
            x = -60;
        }
        if (x < -60) {
            x = Main.WIDTH + 50;
        }
    }

    @Override
    boolean isOut() {
        return false;
    }

    void setColor(Color color) {
        shape.setFill(color);
    }
}
