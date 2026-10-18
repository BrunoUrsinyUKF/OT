package sk.ukf.seminar3_zadanie2_hw;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Pane root;
    private double padding = 3;
    private final double speed = 10;
    private final double floorHeight = 100;
    private Rectangle vytah;

    private int poschodie = 0;
    private List<Integer> pqueue = new ArrayList<>();
    private boolean pohyb = false;

    @FXML
    protected void initialize() {

        // Border
        Rectangle border = new Rectangle(
                padding,
                padding,
                300,
                900
        );
        border.setFill(null);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(3);
        root.getChildren().add(border);

        // Vytah
        vytah = new Rectangle(
                150,
                810,
                50,
                90
        );
        vytah.setFill(Color.GRAY);
        root.getChildren().add(vytah);

        // Keyboard controls
        root.setFocusTraversable(true);

        root.setOnKeyPressed(event -> {
            moveVytah(event.getCode());
        });
    }

    private void moveVytah(KeyCode key) {

        switch (key) {

            case DIGIT0, NUMPAD0 -> {
                pqueue.add(0);
            }

            case DIGIT1, NUMPAD1 -> {
                pqueue.add(1);
            }

            case DIGIT2, NUMPAD2 -> {
                pqueue.add(2);
            }

            case DIGIT3, NUMPAD3 -> {
                pqueue.add(3);
            }

            case DIGIT4, NUMPAD4 -> {
                pqueue.add(4);
            }

            case DIGIT5, NUMPAD5 -> {
                pqueue.add(5);
            }
            case DIGIT6, NUMPAD6 -> {
                pqueue.add(6);
            }
            case DIGIT7, NUMPAD7 -> {
                pqueue.add(7);
            }
            case DIGIT8, NUMPAD8 -> {
                pqueue.add(8);
            }
        }
        processQueue();
    }
    private void processQueue(){
        if(pohyb || pqueue.isEmpty())return;
        pohyb = true;
        int target = pqueue.removeFirst();
        double targetY = 810 - target * floorHeight;

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(50), e -> {
            double y = vytah.getY();

            if (y == targetY) {
                timeline.stop();
                poschodie = target;
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(event -> {
                    pohyb = false;
                    processQueue();
                });
                pause.play();
            }
            else if (y > targetY) {
                vytah.setY(Math.max(y - speed, targetY));
            } else {
                vytah.setY(Math.min(y + speed, targetY));
            }
            }));
        timeline.play();
    }
}