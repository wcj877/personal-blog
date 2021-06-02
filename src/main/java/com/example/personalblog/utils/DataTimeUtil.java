package com.example.personalblog.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataTimeUtil {

    public static String getDataTime(){
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(calendar.getTime());
        return format;
    }

}
