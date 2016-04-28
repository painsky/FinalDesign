package com.classtable.pain.finaldesign;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.classtable.pain.finaldesign.utils.ClassDao;
import com.classtable.pain.finaldesign.utils.ClearTextView;
import com.classtable.pain.finaldesign.utils.Constants;
import com.classtable.pain.finaldesign.utils.FillUpTextView;

import org.xutils.x;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pain on 2016/3/16.
 */
public class MainApplication extends Application {
    private Timer timer=new Timer();
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        timer.schedule(timerTask,10000,300000);

    }
    TimerTask timerTask=new TimerTask() {
        @Override
        public void run() {
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);

        }
    };
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Calendar calendar=Calendar.getInstance();
                    if (Constants.weekdayflag!=calendar.get(Calendar.DAY_OF_WEEK)) {
                        Constants.weekdayflag = calendar.get(Calendar.DAY_OF_WEEK);
                        ClassDao.initselect();
                        new ClearTextView().clear((MainActivity) Constants.activity);
                        new FillUpTextView().fill((MainActivity) Constants.activity);
                    }
                    break;
            }
            super.handleMessage(msg);

        }
    };
}
