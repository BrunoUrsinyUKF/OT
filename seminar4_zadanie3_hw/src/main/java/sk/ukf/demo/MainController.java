package sk.ukf.demo;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MainController {


    @FXML
    private Pane canvas;

    @FXML
    private Button btnStop;

    private final ArrayList<WeatherObject> objects = new ArrayList<>();

    @FXML
    private void initialize() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (WeatherObject o : objects) {
                    o.move();
                    o.update();
                }

                for (int i = objects.size() - 1; i >= 0; i--) {
                    if (objects.get(i).isOut()) {
                        canvas.getChildren().remove(objects.get(i).shape);
                        objects.remove(i);
                    }
                }
            }
        }.start();
    }


    @FXML
    private void addCloud() {
        add(new Cloud(Math.random() * Main.WIDTH, 30 + Math.random() * 50));
    }

    @FXML
    private void addRaindrop() {
        add(new Raindrop(Math.random() * Main.WIDTH, Math.random() * Main.HEIGHT));
    }

    @FXML
    private void addSnowflake() {
        add(new Snowflake(Math.random() * Main.WIDTH, Math.random() * Main.HEIGHT));
    }

    private void add(WeatherObject o) {
        objects.add(o);
        canvas.getChildren().add(o.shape);
        o.update();
    }


    @FXML
    private void toggleRain() {
        Raindrop.stopped = !Raindrop.stopped;
        if (Raindrop.stopped) {
            btnStop.setText("Spustiť dážď");
        } else {
            btnStop.setText("Zastaviť dážď");
        }
    }

    @FXML
    private void makeCloudsBlue() {
        for (WeatherObject o : objects) {
            if (o instanceof Cloud) {
                ((Cloud) o).setColor(Color.DODGERBLUE);
            }
        }
    }


    @FXML
    private void shiftLeft() {
        for (WeatherObject o : objects) {
            o.x -= 20;
            o.update();
        }
    }
}
