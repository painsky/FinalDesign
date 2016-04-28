package com.classtable.pain.finaldesign;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

import com.classtable.pain.finaldesign.utils.AlarmService;
import com.classtable.pain.finaldesign.utils.ClassDao;
import com.classtable.pain.finaldesign.utils.Constants;
import com.classtable.pain.finaldesign.utils.FillUpTextView;
import com.classtable.pain.finaldesign.utils.WeekUtils;

import org.xutils.DbManager;

/**
 * Created by pain on 2016/3/29.
 */
public class SplashActivity extends Activity{
    private LinearLayout splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_splash);
        SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
        Boolean user_first = setting.getBoolean("FIRST", true);
        if (user_first) {//第一次
            setting.edit().putBoolean("FIRST", false).commit();
            setting.edit().putInt("WEEK", 1).commit();
            setting.edit().putInt("STATUS", 1).commit();
        }
        if (setting.getInt("STATUS",1)==2){
            Constants.alarmstatus=2;
            Constants.alarmnumber=setting.getInt("NUMBER",0);
            Constants.alarmday=setting.getInt("DAY",0);
            startService(new Intent(SplashActivity.this, AlarmService.class));
        }
        Constants.weekflag=setting.getInt("WEEK",1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        splash = (LinearLayout) findViewById(R.id.splash_whole);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(3000);
        splash.startAnimation(alphaAnimation);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ClassDao.initselect();
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);

            }
        }).start();
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    new Thread() {
                        public void run() {
                            try {
                                Thread.sleep(3000);
                                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                SplashActivity.this.finish();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        ;
                    }.start();
                    break;

            }
        }
    };
}
