package com.example.projetovelocity;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {



    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        Speedometer speedometer = new Speedometer(10);
        speedometer.show(root);

        Button btn = new Button("Correr");
        btn.setOnAction(e -> {speedometer.speedUp();});
        btn.setLayoutX(250);
        btn.setLayoutY(500);

        Button btn2 = new Button("Frear");
        btn2.setOnAction(e -> {speedometer.speedDown();});
        btn2.setLayoutX(350);
        btn2.setLayoutY(500);

        root.getChildren().addAll(btn, btn2);

        Scene scene = new Scene(root, 600, 600);

        stage.setTitle("Interactive Speedometer");
        stage.setScene(scene);
        stage.show();

    }




}