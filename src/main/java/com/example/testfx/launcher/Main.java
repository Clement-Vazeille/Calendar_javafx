package com.example.testfx.launcher;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
        root.getChildren().add(line);

        root.getChildren().add(text);
        root.getChildren().add(line);

        stage.show();
    }


}