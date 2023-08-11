package com.example.testfx.launcher;

import com.example.testfx.date_gestion.Date_generator;
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
import java.util.List;

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
        String month = LocalDate.now().getMonth().toString();
        text.setText(month);
        text.setX((x_size/2)-(22*month.length()/2));
        text.setY(y_size/11);
        text.setFont(Font.font("Arial Black",25));

        Line line = new Line();
        line.setStartX((x_size/2)-(22*month.length()/2)-5);
        line.setStartY(y_size/10);
        line.setEndX((x_size/2)+(18*month.length()/2));
        line.setEndY(y_size/10);
        line.setStrokeWidth(2);

        button_left = new Button();
        button_left.setText("Precedent Month");
        button_left.setLayoutY(y_size*0.38);
        button_left.setLayoutX(5);

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

        //add the 7 days of the week in text objects
        Text[] days = new Text[7];
        days[0]=new Text("Mon");
        days[1]= new Text("Tue");
        days[2]= new Text("Wed");
        days[3]= new Text("Thu");
        days[4]= new Text("Fri");
        days[5]= new Text("Sat");
        days[6]= new Text("Sun");

        //positions of the seven days of the week
        double[] pos_days = new double[7];

        for(int i=0;i<7;i++)
        {
           days[i].setX((0.24 +i*0.08)*x_size);
           days[i].setY(y_size*0.19);
           days[i].setFont(Font.font("Agency FB",20));
           root.getChildren().add(days[i]);
        }

        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(button_left);
        root.getChildren().add(button_right);

        List<LocalDate> monthLocalDates = Date_generator.month_day_list(LocalDate.now());
        List<Text> monthTexts = Date_generator.days_text_list_generator(monthLocalDates,x_size,y_size);

        for (Text dayText:monthTexts){
            root.getChildren().add(dayText);
        }

        stage.show();
    }


}