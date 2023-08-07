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

import  java.time.LocalDate;

import java.io.IOException;
import java.time.chrono.ChronoLocalDate;

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

        int x_size = 630;
        int y_size = 480;
        //customise the stage
        Image icon = new Image("calendar_icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Calendar");
        stage.setHeight(y_size);
        stage.setWidth(x_size);

        Text text = new Text();
        String month = "MAI";
        text.setText(month);
        text.setX((x_size/2)-(22*month.length()/2)-10);
        text.setY(y_size/11);
        text.setFont(Font.font("Arial Black",25));

        Line line = new Line();
        line.setStartX((x_size/2)-(22*month.length()/2)-15);
        line.setStartY(y_size/10);
        line.setEndX((x_size/2)+(18*month.length()/2)-10);
        line.setEndY(y_size/10);
        line.setStrokeWidth(2);

        button_left = new Button();
        button_left.setText("Precedent Month");
        button_left.setLayoutY(y_size*0.38);
        button_left.setLayoutX(5);

        //L'idée serait de depuis un autre fichier générer un List<Text> qui contiendrait chaque texte
        //Avec en entrée une local date (pour le mois et l'année)
        LocalDate date_test = LocalDate.now();
        Text text_date = new Text(String.valueOf(date_test.getDayOfMonth()));
        text_date.setX(300);
        text_date.setY(300);
        text_date.setFont(Font.font("Agency FB",14));
        root.getChildren().add(text_date);
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
        button_right.setLayoutY(y_size*0.38);
        button_right.setLayoutX(x_size-100);
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