package com.example.testfx.launcher;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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

        stage.show();
    }


}