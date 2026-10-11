package sk.ukf.seminar3_zadanie2_hw;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class HelloController {

    @FXML
    private Pane root;

    private final double padding = 50;
    private final double gameSize = 400;
    private final double robotSize = 40;
    private final double speed = 10;

    private boolean randomMode = false;
    private final Random random = new Random();

    private Group robotGroup;
    private Rectangle robot;
    private Rectangle front1;
    private Rectangle front2;

    @FXML
    protected void initialize() {

        // Border
        Rectangle border = new Rectangle(
                padding,
                padding,
                gameSize,
                gameSize
        );

        border.setFill(null);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(3);

        root.getChildren().add(border);

        // Robot
        robot = new Rectangle(
                padding + 180,
                padding + 180,
                robotSize,
                robotSize
        );

        robot.setFill(Color.GRAY);

        front1 = new Rectangle(
                padding + 185,
                padding + 180,
                10,
                10
        );

        front1.setFill(Color.RED);

        front2 = new Rectangle(
                padding + 205,
                padding + 180,
                10,
                10
        );

        robotGroup = new Group(robot, front1, front2);

        front2.setFill(Color.RED);

        root.getChildren().add(robotGroup);

        // Keyboard controls
        root.setFocusTraversable(true);

        root.setOnKeyPressed(event -> {
            moveRobot(event.getCode());
        });

        Timeline randomMovement = new Timeline(
                new KeyFrame(Duration.seconds(0.5), event -> {

                    if (randomMode) {

                        KeyCode[] keys = {
                                KeyCode.W,
                                KeyCode.A,
                                KeyCode.S,
                                KeyCode.D
                        };

                        KeyCode randomKey =
                                keys[random.nextInt(keys.length)];

                        moveRobot(randomKey);
                    }
                })
        );

        randomMovement.setCycleCount(Timeline.INDEFINITE);
        randomMovement.play();
    }

    private void moveRobot(KeyCode key) {

        switch (key) {

            case W -> {
                robotGroup.setRotate(0);

                if (robot.getY() - speed >= padding) {
                    robot.setY(robot.getY() - speed);
                    front1.setY(front1.getY() - speed);
                    front2.setY(front2.getY() - speed);
                }
            }

            case A -> {
                robotGroup.setRotate(-90);

                if (robot.getX() - speed >= padding) {
                    robot.setX(robot.getX() - speed);
                    front1.setX(front1.getX() - speed);
                    front2.setX(front2.getX() - speed);
                }
            }

            case S -> {
                robotGroup.setRotate(180);

                if (robot.getY() + robot.getHeight() + speed
                        <= padding + gameSize) {
                    robot.setY(robot.getY() + speed);
                    front1.setY(front1.getY() + speed);
                    front2.setY(front2.getY() + speed);
                }
            }

            case D -> {
                robotGroup.setRotate(90);
                front1.setRotate(90);
                front2.setRotate(90);

                if (robot.getX() + robot.getWidth() + speed
                        <= padding + gameSize) {
                    robot.setX(robot.getX() + speed);
                    front1.setX(front1.getX() + speed);
                    front2.setX(front2.getX() + speed);
                }
            }
        }
    }

    @FXML
    private void handleButton() {
        randomMode = !randomMode;
    }
}