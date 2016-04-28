package com.classtable.pain.finaldesign.utils;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pain on 2016/4/27.
 */
public class AlarmService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println(Constants.weekdayflag);
        System.out.println(Constants.alarmday);
        if (Constants.weekdayflag==Constants.alarmday){
            if (Constants.alarmabale){
                Calendar calendar=Calendar.getInstance();
                Constants.weekdayflag = calendar.get(Calendar.DAY_OF_WEEK);
                int day=calendar.get(Calendar.DATE);
                int month=calendar.get(Calendar.MONTH)+1;
                int year=calendar.get(Calendar.YEAR);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                switch (Constants.alarmnumber){
                    case 1:
                        try {
                            Date date = sdf.parse(year + "-" + month + "-" + day);
                            long dateMill = date.getTime();
                            long temp=28800000-60000;
                            long goal=temp+ dateMill-System.currentTimeMillis();
                            Constants.alarmabale=false;
                            Constants.alarmstatus=2;
                            startAlarm(goal);
                            SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
                            setting.edit().putInt("STATUS",Constants.alarmstatus).commit();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            Date date = sdf.parse(year + "-" + month + "-" + day);
                            long dateMill = date.getTime();
                            long temp=36000000-60000;
                            long goal=temp+ dateMill-System.currentTimeMillis();
                            Constants.alarmabale=false;
                            Constants.alarmstatus=2;
                            startAlarm(goal);
                            SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
                            setting.edit().putInt("STATUS",Constants.alarmstatus).commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            Date date = sdf.parse(year + "-" + month + "-" + day);
                            long dateMill = date.getTime();
                            long temp=50220000-60000;
                            long goal=temp+ dateMill-System.currentTimeMillis();
                            Constants.alarmabale=false;
                            Constants.alarmstatus=2;
                            startAlarm(goal);
                            SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
                            setting.edit().putInt("STATUS",Constants.alarmstatus).commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            Date date = sdf.parse(year + "-" + month + "-" + day);
                            long dateMill = date.getTime();
                            long temp=50940000-60000;
                            long goal=temp+ dateMill-System.currentTimeMillis();
                            Constants.alarmabale=false;
                            Constants.alarmstatus=2;
                            startAlarm(goal);
                            SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
                            setting.edit().putInt("STATUS",Constants.alarmstatus).commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            Date date = sdf.parse(year + "-" + month + "-" + day);
                            long dateMill = date.getTime();
                            long temp=68400000-60000;
                            long goal=temp+ dateMill-System.currentTimeMillis();
                            Constants.alarmabale=false;
                            Constants.alarmstatus=2;
                            startAlarm(goal);
                            SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
                            setting.edit().putInt("STATUS",Constants.alarmstatus).commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
                Constants.alarmabale=true;
                Toast.makeText(getApplicationContext(),"请注意上课",Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public  void startAlarm(long l){
        Vibrator vibrator= (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(new long[]{l, 10000, 1000}, -1);
    }
}
