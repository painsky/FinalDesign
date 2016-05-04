package com.classtable.pain.finaldesign;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.classtable.pain.finaldesign.bean.Classbean;
import com.classtable.pain.finaldesign.bean.Studentbean;
import com.classtable.pain.finaldesign.utils.AlarmService;
import com.classtable.pain.finaldesign.utils.ClassDao;
import com.classtable.pain.finaldesign.utils.ClearTextView;
import com.classtable.pain.finaldesign.utils.Constants;
import com.classtable.pain.finaldesign.utils.FillUpTextView;
import com.classtable.pain.finaldesign.utils.SingleAsk;
import com.classtable.pain.finaldesign.utils.WeekUtils;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends Activity {
    public int timeid=0;
    private AlertDialog dialog;
    private Dialog askdialog;
    @ViewInject(R.id.class1_1)
    private TextView classTextView1_1;
    @ViewInject(R.id.class1_2)
    private TextView classTextView1_2;
    @ViewInject(R.id.class1_3)
    private TextView classTextView1_3;
    @ViewInject(R.id.class1_4)
    private TextView classTextView1_4;
    @ViewInject(R.id.class1_5)
    private TextView classTextView1_5;
    @ViewInject(R.id.class2_1)
    private TextView classTextView2_1;
    @ViewInject(R.id.class2_2)
    private TextView classTextView2_2;
    @ViewInject(R.id.class2_3)
    private TextView classTextView2_3;
    @ViewInject(R.id.class2_4)
    private TextView classTextView2_4;
    @ViewInject(R.id.class2_5)
    private TextView classTextView2_5;
    @ViewInject(R.id.class3_1)
    private TextView classTextView3_1;
    @ViewInject(R.id.class3_2)
    private TextView classTextView3_2;
    @ViewInject(R.id.class3_3)
    private TextView classTextView3_3;
    @ViewInject(R.id.class3_4)
    private TextView classTextView3_4;
    @ViewInject(R.id.class3_5)
    private TextView classTextView3_5;
    @ViewInject(R.id.class4_1)
    private TextView classTextView4_1;
    @ViewInject(R.id.class4_2)
    private TextView classTextView4_2;
    @ViewInject(R.id.class4_3)
    private TextView classTextView4_3;
    @ViewInject(R.id.class4_4)
    private TextView classTextView4_4;
    @ViewInject(R.id.class4_5)
    private TextView classTextView4_5;
    @ViewInject(R.id.class5_1)
    private TextView classTextView5_1;
    @ViewInject(R.id.class5_2)
    private TextView classTextView5_2;
    @ViewInject(R.id.class5_3)
    private TextView classTextView5_3;
    @ViewInject(R.id.class5_4)
    private TextView classTextView5_4;
    @ViewInject(R.id.class5_5)
    private TextView classTextView5_5;
    @ViewInject(R.id.class6_1)
    private TextView classTextView6_1;
    @ViewInject(R.id.class6_2)
    private TextView classTextView6_2;
    @ViewInject(R.id.class6_3)
    private TextView classTextView6_3;
    @ViewInject(R.id.class6_4)
    private TextView classTextView6_4;
    @ViewInject(R.id.class6_5)
    private TextView classTextView6_5;
    @ViewInject(R.id.class7_1)
    private TextView classTextView7_1;
    @ViewInject(R.id.class7_2)
    private TextView classTextView7_2;
    @ViewInject(R.id.class7_3)
    private TextView classTextView7_3;
    @ViewInject(R.id.class7_4)
    private TextView classTextView7_4;
    @ViewInject(R.id.class7_5)
    private TextView classTextView7_5;
    @ViewInject(R.id.textview_whatweek)
    private  TextView textView;
    @ViewInject(R.id.imagebutton)
    private ImageButton imageButton;
    @Override
    protected void onRestart() {
        super.onRestart();
        textView.setText("第" + Constants.weekflag + "周");
        if (Constants.classbeans!=null) {
            new ClearTextView().clear(MainActivity.this);
            new FillUpTextView().fill(MainActivity.this);
        }else {
            new ClearTextView().clear(MainActivity.this);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.whole_main);
        Constants.activity=this;
        WeekUtils.getWeekday();
        initDialog();
        initAskDialog();
        x.view().inject(this);
        textView.setText("第" + Constants.weekflag + "周");
        if (Constants.classbeans!=null) {
            new FillUpTextView().fill(MainActivity.this);
        }
    }

    private void initAskDialog() {
        askdialog=new AlertDialog.Builder(this) .setPositiveButton("确定", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                switch (Constants.result){
                    case 0:
                       break;
                    case 1:
                      Constants.studentbean.setStudentlatertimes(Constants.studentbean.getStudentabsenttimes()+1);
                        String temp=Constants.findClassBean.getTimeid()+"";
                        temp="第"+Constants.weekflag+"周周"+temp.substring(0,1)+"第"+temp.substring(1)+"节"+";";
                        temp=Constants.studentbean.getStudentabsentdetail()+temp;
                        Constants.studentbean.setStudentabsentdetail(Constants.studentbean.getStudentabsentdetail() + temp);
                        ClassDao.save(Constants.studentbean);
                        break;
                    case 2:
                        Constants.studentbean.setStudentanswertimes(Constants.studentbean.getStudentanswertimes()+1);
                        String temp1=Constants.findClassBean.getTimeid()+"";
                        temp1="第"+Constants.weekflag+"周周"+temp1.substring(0,1)+"第"+temp1.substring(1)+"节"+";";
                        temp1=Constants.studentbean.getStudentanswerdetail()+temp1;
                        Constants.studentbean.setStudentanswerdetail(Constants.studentbean.getStudentanswerdetail() + temp1);
                        ClassDao.save(Constants.studentbean);
                        break;
                }

                // TODO Auto-generated method stub

            }
        }).setSingleChoiceItems(Constants.askArray, 0,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog,
                                        int which) {
                        // TODO Auto-generated method stub
                        switch (which){
                            case 0:
                                Constants.result=0;
                                break;
                            case 1:
                                Constants.result=1;
                                break;
                            case 2:
                                Constants.result=2;
                                break;
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
        setting.edit().putInt("STATUS",Constants.alarmstatus).commit();
        setting.edit().putInt("DAY",Constants.alarmday).commit();
        setting.edit().putInt("NUMBER",Constants.alarmnumber).commit();

    }

    private void initDialog() {
      dialog=new AlertDialog.Builder(this).setItems(Constants.longClickArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        startActivity(new Intent(MainActivity.this, AddClassActivity.class));
                        break;
                    case 1:
                        ClassDao.findBefore(timeid);
                        if (Constants.findFlag)
                        {
                            Classbean classbean=Constants.findClassBean;
                            startActivity(new Intent(MainActivity.this, EditClassActivity.class));
                            Constants.findFlag=false;
                        }else {
                            Toast.makeText(getApplicationContext(), "所选内容为空", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        ClassDao.findBefore(timeid);
                        if (Constants.findFlag)
                        {
                            Classbean classbean=Constants.findClassBean;
                            Constants.findFlag=false;
                            Constants.clearsize=Constants.classbeans.size();
                            Constants.clearitime=classbean.getTimeid();
                            ClassDao.delete(classbean);
                            ClassDao.findStudentBefore(classbean.getClassid());
                            if (Constants.studentbeans!=null){
                                for (Studentbean studentbean:Constants.studentbeans){
                                    ClassDao.deleteStudent(studentbean);
                                }
                            }
                            ClassDao.initselect();
                            new ClearTextView().clear(MainActivity.this);
                            Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "所选内容为空", Toast.LENGTH_SHORT).show();
                        }
                        //Toast.makeText(MainActivity.this,"课程删除",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, BindClassActivity.class));
                        break;
                    case 4:
                        ClassDao.findBefore(timeid);
                        if (Constants.findFlag) {
                            switch (timeid / 10) {
                                case 1:
                                    Constants.alarmday = 2;
                                    break;
                                case 2:
                                    Constants.alarmday = 3;
                                    break;
                                case 3:
                                    Constants.alarmday = 4;
                                    break;
                                case 4:
                                    Constants.alarmday = 5;
                                    break;
                                case 5:
                                    Constants.alarmday = 6;
                                    break;
                                case 6:
                                    Constants.alarmday = 7;
                                    break;
                                case 7:
                                    Constants.alarmday = 1;
                                    break;

                            }
                            Constants.findFlag=false;
                            Constants.alarmnumber = timeid % 10;
                            startService(new Intent(MainActivity.this, AlarmService.class));
                            Toast.makeText(getApplicationContext(), "提醒已设置", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "所选内容为空", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5:
                        ClassDao.findBefore(timeid);
                        if (Constants.findFlag)
                        {
                            Classbean classbean=Constants.findClassBean;
                            ClassDao.findStudentBefore(classbean.getClassid());
                            if (Constants.studentbeans==null||Constants.studentbeans.size()==0){
                                Toast.makeText(getApplicationContext(), "木有名单~~", Toast.LENGTH_SHORT).show();
                            }else {
                                SingleAsk.ask();
                                askdialog.setTitle(Constants.studentbean.getStudentname());
                                askdialog.show();
                            }
                            Constants.findFlag=false;
                        }else {
                            Toast.makeText(getApplicationContext(), "所选内容为空", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        }).create();
    }

    private void showStudent() {
        ClassDao.findBefore(timeid);
        if (Constants.findFlag)
        {
            Classbean classbean=Constants.findClassBean;
            Constants.findFlag=false;
            ClassDao.findStudentBefore(classbean.getClassid());
            if (Constants.studentbeans!=null){
                startActivity(new Intent(MainActivity.this,ShowStudentActivity.class));
            }else {
                Toast.makeText(getApplicationContext(), "暂未绑定名单", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "所选内容为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Event(value = {R.id.class1_1, R.id.class1_2, R.id.class1_3, R.id.class1_4, R.id.class1_5
            , R.id.class2_1, R.id.class2_2, R.id.class2_3, R.id.class2_4, R.id.class2_5, R.id.class3_1,
            R.id.class3_2, R.id.class3_3, R.id.class3_4, R.id.class3_5,
            R.id.class4_1, R.id.class4_2, R.id.class4_3, R.id.class4_4, R.id.class4_5,
            R.id.class5_1, R.id.class5_2, R.id.class5_3, R.id.class5_4, R.id.class5_5
            , R.id.class6_1, R.id.class6_2, R.id.class6_3, R.id.class6_4, R.id.class6_5,
            R.id.class7_1, R.id.class7_2, R.id.class7_3, R.id.class7_4, R.id.class7_5,R.id.imagebutton}, type = View.OnClickListener.class)
    private void onClassClick(View view) {
        switch (view.getId()){
            case R.id.class1_1:
                Constants.idRestore=R.id.class1_1;
                timeid=11;
                showStudent();
                break;
            case R.id.class1_2:
                Constants.idRestore=R.id.class1_2;
                timeid=12;
                showStudent();
                break;
            case R.id.class1_3:
                Constants.idRestore=R.id.class1_3;
                timeid=13;
                showStudent();
                break;
            case R.id.class1_4:
                Constants.idRestore=R.id.class1_4;
                timeid=14;
                showStudent();
                break;
            case R.id.class1_5:
                Constants.idRestore=R.id.class1_5;
                timeid=15;
                showStudent();
                break;
            case R.id.class2_1:
                Constants.idRestore=R.id.class2_1;
                timeid=21;
                showStudent();
                break;
            case R.id.class2_2:
                Constants.idRestore=R.id.class2_2;
                timeid=22;
                showStudent();
                break;
            case R.id.class2_3:
                Constants.idRestore=R.id.class2_3;
                timeid=23;
                showStudent();
                break;
            case R.id.class2_4:
                Constants.idRestore=R.id.class2_4;
                timeid=24;
                showStudent();
                break;
            case R.id.class2_5:
                Constants.idRestore=R.id.class2_5;
                timeid=25;
                showStudent();
                break;
            case R.id.class3_1:
                Constants.idRestore=R.id.class3_1;
                timeid=31;
                showStudent();
                break;
            case R.id.class3_2:
                Constants.idRestore=R.id.class3_2;
                timeid=32;
                showStudent();
                break;
            case R.id.class3_3:
                Constants.idRestore=R.id.class3_3;
                timeid=33;
                showStudent();
                break;
            case R.id.class3_4:
                Constants.idRestore=R.id.class3_4;
                timeid=34;
                showStudent();
                break;
            case R.id.class3_5:
                Constants.idRestore=R.id.class3_5;
                timeid=35;
                showStudent();
                break;
            case R.id.class4_1:
                Constants.idRestore=R.id.class4_1;
                timeid=41;
                showStudent();
                break;
            case R.id.class4_2:
                Constants.idRestore=R.id.class4_2;
                timeid=42;
                showStudent();
                break;
            case R.id.class4_3:
                Constants.idRestore=R.id.class4_3;
                timeid=43;
                showStudent();
                break;
            case R.id.class4_4:
                Constants.idRestore=R.id.class4_4;
                timeid=44;
                showStudent();
                break;
            case R.id.class4_5:
                Constants.idRestore=R.id.class4_5;
                timeid=45;
                showStudent();
                break;
            case R.id.class5_1:
                Constants.idRestore=R.id.class5_1;
                timeid=51;
                showStudent();
                break;
            case R.id.class5_2:
                Constants.idRestore=R.id.class5_2;
                timeid=52;
                showStudent();
                break;
            case R.id.class5_3:
                Constants.idRestore=R.id.class5_3;
                timeid=53;
                showStudent();
                break;
            case R.id.class5_4:
                Constants.idRestore=R.id.class5_4;
                timeid=54;
                showStudent();
                break;
            case R.id.class5_5:
                Constants.idRestore=R.id.class5_5;
                timeid=55;
                showStudent();
                break;
            case R.id.class6_1:
                Constants.idRestore=R.id.class6_1;
                timeid=61;
                showStudent();
                break;
            case R.id.class6_2:
                Constants.idRestore=R.id.class6_2;
                timeid=62;
                showStudent();
                break;
            case R.id.class6_3:
                Constants.idRestore=R.id.class6_3;
                timeid=63;
                showStudent();
                break;
            case R.id.class6_4:
                Constants.idRestore=R.id.class6_4;
                timeid=64;
                showStudent();;
                break;
            case R.id.class6_5:
                Constants.idRestore=R.id.class6_5;
                timeid=65;
                showStudent();
                break;
            case R.id.class7_1:
                Constants.idRestore=R.id.class7_1;
                timeid=71;
                showStudent();
                break;
            case R.id.class7_2:
                Constants.idRestore=R.id.class7_2;
                timeid=72;
                showStudent();
                break;
            case R.id.class7_3:
                Constants.idRestore=R.id.class7_3;
                timeid=73;
                showStudent();
                break;
            case R.id.class7_4:
                Constants.idRestore=R.id.class7_4;
                timeid=74;
                showStudent();
                break;
            case R.id.class7_5:
                Constants.idRestore=R.id.class7_5;
                timeid=75;
                showStudent();
                break;
            case R.id.imagebutton:
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item_setting:
                                startActivity(new Intent(MainActivity.this,SettingWeekActivity.class));
                                break;
                            case R.id.item_clear:
                                startActivity(new Intent(MainActivity.this,WebActivity.class));
                                break;

                        }
                        return true;
                    }
                });
                popupMenu.show();
                break;
        }

    }
    @Event(value = {R.id.class1_1, R.id.class1_2, R.id.class1_3, R.id.class1_4, R.id.class1_5
            , R.id.class2_1, R.id.class2_2, R.id.class2_3, R.id.class2_4, R.id.class2_5, R.id.class3_1,
            R.id.class3_2, R.id.class3_3, R.id.class3_4, R.id.class3_5,
            R.id.class4_1, R.id.class4_2, R.id.class4_3, R.id.class4_4, R.id.class4_5,
            R.id.class5_1, R.id.class5_2, R.id.class5_3, R.id.class5_4, R.id.class5_5
            , R.id.class6_1, R.id.class6_2, R.id.class6_3, R.id.class6_4, R.id.class6_5,
            R.id.class7_1, R.id.class7_2, R.id.class7_3, R.id.class7_4, R.id.class7_5}, type = View.OnLongClickListener.class)
    private boolean onClassLongClick(View view){
        switch (view.getId()){
            case R.id.class1_1:
                Constants.idRestore=R.id.class1_1;
                timeid=11;
                dialog.show();
                break;
            case R.id.class1_2:
                Constants.idRestore=R.id.class1_2;
                timeid=12;
                dialog.show();
                break;
            case R.id.class1_3:
                Constants.idRestore=R.id.class1_3;
                timeid=13;
                dialog.show();
                break;
            case R.id.class1_4:
                Constants.idRestore=R.id.class1_4;
                timeid=14;
                dialog.show();
                break;
            case R.id.class1_5:
                Constants.idRestore=R.id.class1_5;
                timeid=15;
                dialog.show();
                break;
            case R.id.class2_1:
                Constants.idRestore=R.id.class2_1;
                timeid=21;
                dialog.show();
                break;
            case R.id.class2_2:
                Constants.idRestore=R.id.class2_2;
                timeid=22;
                dialog.show();
                break;
            case R.id.class2_3:
                Constants.idRestore=R.id.class2_3;
                timeid=23;
                dialog.show();
                break;
            case R.id.class2_4:
                Constants.idRestore=R.id.class2_4;
                timeid=24;
                dialog.show();
                break;
            case R.id.class2_5:
                Constants.idRestore=R.id.class2_5;
                timeid=25;
                dialog.show();
                break;
            case R.id.class3_1:
                Constants.idRestore=R.id.class3_1;
                timeid=31;
                dialog.show();
                break;
            case R.id.class3_2:
                Constants.idRestore=R.id.class3_2;
                timeid=32;
                dialog.show();
                break;
            case R.id.class3_3:
                Constants.idRestore=R.id.class3_3;
                timeid=33;
                dialog.show();
                break;
            case R.id.class3_4:
                Constants.idRestore=R.id.class3_4;
                timeid=34;
                dialog.show();
                break;
            case R.id.class3_5:
                Constants.idRestore=R.id.class3_5;
                timeid=35;
                dialog.show();
                break;
            case R.id.class4_1:
                Constants.idRestore=R.id.class4_1;
                timeid=41;
                dialog.show();
                break;
            case R.id.class4_2:
                Constants.idRestore=R.id.class4_2;
                timeid=42;
                dialog.show();
                break;
            case R.id.class4_3:
                Constants.idRestore=R.id.class4_3;
                timeid=43;
                dialog.show();
                break;
            case R.id.class4_4:
                Constants.idRestore=R.id.class4_4;
                timeid=44;
                dialog.show();
                break;
            case R.id.class4_5:
                Constants.idRestore=R.id.class4_5;
                timeid=45;
                dialog.show();
                break;
            case R.id.class5_1:
                Constants.idRestore=R.id.class5_1;
                timeid=51;
                dialog.show();
                break;
            case R.id.class5_2:
                Constants.idRestore=R.id.class5_2;
                timeid=52;
                dialog.show();
                break;
            case R.id.class5_3:
                Constants.idRestore=R.id.class5_3;
                timeid=53;
                dialog.show();
                break;
            case R.id.class5_4:
                Constants.idRestore=R.id.class5_4;
                timeid=54;
                dialog.show();
                break;
            case R.id.class5_5:
                Constants.idRestore=R.id.class5_5;
                timeid=55;
                dialog.show();
                break;
            case R.id.class6_1:
                Constants.idRestore=R.id.class6_1;
                timeid=61;
                dialog.show();
                break;
            case R.id.class6_2:
                Constants.idRestore=R.id.class6_2;
                timeid=62;
                dialog.show();
                break;
            case R.id.class6_3:
                Constants.idRestore=R.id.class6_3;
                timeid=63;
                dialog.show();
                break;
            case R.id.class6_4:
                Constants.idRestore=R.id.class6_4;
                timeid=64;
                dialog.show();
                break;
            case R.id.class6_5:
                Constants.idRestore=R.id.class6_5;
                timeid=65;
                dialog.show();
                break;
            case R.id.class7_1:
                Constants.idRestore=R.id.class7_1;
                timeid=71;
                dialog.show();
                break;
            case R.id.class7_2:
                Constants.idRestore=R.id.class7_2;
                timeid=72;
                dialog.show();
                break;
            case R.id.class7_3:
                Constants.idRestore=R.id.class7_3;
                timeid=73;
                dialog.show();
                break;
            case R.id.class7_4:
                Constants.idRestore=R.id.class7_4;
                timeid=74;
                dialog.show();
                break;
            case R.id.class7_5:
                Constants.idRestore=R.id.class7_5;
                timeid=75;
                dialog.show();
                break;
        }
        return true;
    }
}
