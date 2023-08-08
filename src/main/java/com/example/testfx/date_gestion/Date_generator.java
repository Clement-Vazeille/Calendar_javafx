package com.example.testfx.date_gestion;

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
}
