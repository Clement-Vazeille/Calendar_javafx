package com.example.testfx.launcher;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);   //launch start method
    }

    Button button_left;
    Button button_right;
    @Override
    public void start(Stage stage) throws IOException {
        //create a scene and set it to the stage
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        stage.setScene(scene);

        //customise the stage
        Image icon = new Image("calendar_icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Calendar");
        stage.setHeight(480);
        stage.setWidth(640);

        Text text = new Text();
        text.setText("AOUT");
        text.setX(270);
        text.setY(40);
        text.setFont(Font.font("Arial Black",25));

        Line line = new Line();
        line.setStartX(250);
        line.setStartY(45);
        line.setEndX(360);
        line.setEndY(45);
        line.setStrokeWidth(2);

        button_left = new Button();
        button_left.setText("Precedent Month");
        button_left.setLayoutY(200);
        button_left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Left");
                Text textadded = new Text();
                textadded.setText("Sheeeesh");
                textadded.setX(80);
                textadded.setY(200);
                root.getChildren().add(textadded);
            }
        });

        button_right = new Button();
        button_right.setText("Next Month");
        button_right.setLayoutY(200);
        button_right.setLayoutX(540);
        button_right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("right");
                Text textadded = new Text();
                textadded.setText("Sheeeesh");
                textadded.setX(500);
                textadded.setY(200);
                root.getChildren().add(textadded);
            }
        });

        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(button_left);
        root.getChildren().add(button_right);

        stage.show();
    }


}