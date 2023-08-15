package com.example.testfx;

import com.example.testfx.date_gestion.Date_generator;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.List;

public class Scene_manipulation {

    public static void addTextList(Group root, List<Text> textList) {
        for (Text text : textList) {
            root.getChildren().add(text);
        }
    }

    public static void removeTextList(Group root, List<Text> textList) {
        for (Text text : textList) {
            root.getChildren().remove(text);
        }
    }

    //send back the Text list of the days created
    public static List<Text> setUpScene(Group root, Line line, int x_size, int y_size, Text monthText, Text yearText, LocalDate date) {
        String monthString = date.getMonth().toString();
        monthText.setText(monthString);
        monthText.setX((x_size / 2) - (22 * monthString.length() / 2));
        yearText.setText(String.valueOf(date.getYear()));
        line.setStartX((x_size / 2) - (22 * monthString.length() / 2) - 5);
        line.setEndX((x_size / 2) + (18 * monthString.length() / 2));
        List<Text> monthTexts = Date_generator
                .days_text_list_generator(Date_generator.month_day_list(date), x_size, y_size);
        addTextList(root, monthTexts);
        return monthTexts;
    }
}
