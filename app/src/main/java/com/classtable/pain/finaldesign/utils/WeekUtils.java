package com.classtable.pain.finaldesign.utils;

import android.content.Context;
import android.os.Vibrator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pain on 2016/4/19.
 */
public class WeekUtils {
    public static void getWeekday(){
        Calendar calendar=Calendar.getInstance();
        Constants.weekdayflag = calendar.get(Calendar.DAY_OF_WEEK);

        }

}
