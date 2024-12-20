package com.example.projetovelocity;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Speedometer {
    private static final double CENTER_X = 300;
    private static final double CENTER_Y = 250;
    private static final double RADIUS = 200;

    private Line needle;
    private Label speedLabel;

    private double speed;
    private double speedMax;
    private boolean isRunning;

    public Speedometer(double speedMax) {
        this.speed = 0;
        this.speedMax = speedMax;
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            updateSpeedometer();
        }
    };

    public void show(Pane root) {
        // Desenho do relogio
        Circle watch = new Circle(CENTER_X, CENTER_Y, RADIUS);
        watch.setFill(Color.LIGHTGRAY);
        watch.setStroke(Color.BLACK);

        // Desenho do ponteiro
        needle = new Line(CENTER_X, CENTER_Y, CENTER_X, CENTER_Y - RADIUS + 10);
        needle.setStroke(Color.RED);
        needle.setStrokeWidth(4.0);

        // Texto de velocidade
        speedLabel = new Label("0 km/h");
        speedLabel.setLayoutX(CENTER_X - 40);
        speedLabel.setLayoutY(CENTER_Y + RADIUS + 20);
        speedLabel.setStyle("-fx-font-size: 20px");

        root.getChildren().addAll(watch, needle, speedLabel);
    }

    public void speedUp() {
        isRunning = true;
        timer.start();
    }

    public void speedDown() {
        isRunning = false;
    }

    private void updateSpeedometer() {
        if (isRunning) {
            if (speed <= speedMax) {
                speed += 0.1;
            } else {
                speed = speedMax;
            }
        } else if (speed > 0) {
            speed -= 0.1;
        } else{
            speed = 0;
            timer.stop();
        }
        updateNeedle();

        speedLabel.setText(speed + "km/h");
    }

    private void updateNeedle() {
        double angle = Math.toRadians(-90 + (speed / speedMax) * 360);
        double needleX = CENTER_X + RADIUS * Math.cos(angle);
        double needleY = CENTER_Y + RADIUS * Math.sin(angle);

        needle.setEndX(needleX);
        needle.setEndY(needleY);
    }

}
