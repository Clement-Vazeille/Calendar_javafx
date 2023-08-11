package com.example.testfx.date_gestion;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Date_generator {

    //Take a day and return the list of all days within the month
    public static List<LocalDate> month_day_list(LocalDate base_day)
    {
        List<LocalDate> dateList = new ArrayList<>();

        //make base_day the first day of the month
        Month month = base_day.getMonth();
        while (base_day.getMonth().equals(month))
        {
            base_day=base_day.plusDays(-1);
        }
        base_day=base_day.plusDays(1);

        while(base_day.getMonth().equals(month))
        {
            dateList.add(base_day);
            base_day=base_day.plusDays(1);
        }

        return dateList;
    }

    public static List<Text> days_text_list_generator(List<LocalDate> localDates,int x_size,int y_size)
    {
        int line_number = 0;
        int column_number =localDates.get(0).getDayOfWeek().getValue()-1;

        List<Text> textList = new ArrayList<>();
        for(LocalDate day_treated:localDates)
        {
            Text text = new Text(String.valueOf(day_treated.getDayOfMonth()));
            text.setX((0.245 +column_number*0.0815)*x_size);
            text.setY((0.27+0.1*line_number)*y_size);
            text.setFont(Font.font("Agency FB",16));
            column_number=(column_number+1)%7;
            if(column_number==0){line_number++;}
            textList.add((text));
        }
        return textList;
    }
}
