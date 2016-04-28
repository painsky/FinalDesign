package com.classtable.pain.finaldesign;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.classtable.pain.finaldesign.bean.Classbean;
import com.classtable.pain.finaldesign.bean.Studentbean;
import com.classtable.pain.finaldesign.utils.ClassDao;
import com.classtable.pain.finaldesign.utils.Constants;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

/**
 * Created by pain on 2016/4/10.
 */
public class BindClassActivity extends Activity {
    @ViewInject(R.id.bind_title)
    private TextView title;
    @ViewInject(R.id.button_select_bind)
    private Button selectbutton;
    private int timeid;
    private int parentid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_bind);
        x.view().inject(this);
        initClassFlag();
    }

    android.os.Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Toast.makeText(BindClassActivity.this, "数据已同步", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Event(value =  R.id.button_select_bind, type = View.OnClickListener.class)
    private void bindClick(View view) {
        switch (view.getId()) {
            case R.id.button_select_bind:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            final Uri dataUri = data.getData();
            if (requestCode == 1) {
                if (resultCode == RESULT_OK) {
                    new Thread() {
                        @Override
                        public void run() {
                            String fileName = Constants.getFileNameByUri(BindClassActivity.this, dataUri);
                            String file = dataUri.toString().substring(7);
                            try {
                                Workbook workbook = Workbook.getWorkbook(new File(file));
                                Sheet sheet = workbook.getSheet(0);
                                for (int i = 1; i < sheet.getRows(); i++) {
                                    Studentbean studentbean = new Studentbean();
                                    String studentNumber = sheet.getCell(0, i).getContents();
                                    String studentName = sheet.getCell(1, i).getContents();
                                    String studentClass = sheet.getCell(2, i).getContents();
                                    studentbean.setParentid(parentid);
                                    studentbean.setStudentnumber(studentNumber);
                                    studentbean.setStudentname(studentName);
                                    studentbean.setStudentclass(studentClass);
                                    ClassDao.save(studentbean);
                                }
                                Message msg = new Message();
                                msg.what = 1;
                                handler.sendMessage(msg);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }.start();

                }
            }
        }
    }

    private void initClassFlag() {
        switch (Constants.idRestore) {
            case R.id.class1_1:
                title.setText("绑定周一第一节名单");
                timeid = 11;
                break;
            case R.id.class1_2:
                title.setText("绑定周一第二节名单");
                timeid = 12;
                break;
            case R.id.class1_3:
                title.setText("绑定周一第三节名单");
                timeid = 13;
                break;
            case R.id.class1_4:
                title.setText("绑定周一第四节名单");
                timeid = 14;
                break;
            case R.id.class1_5:
                title.setText("绑定周一第五节名单");
                timeid = 15;
                break;
            case R.id.class2_1:
                title.setText("绑定周二第一节名单");
                timeid = 21;
                break;
            case R.id.class2_2:
                title.setText("绑定周二第二节名单");
                timeid = 22;
                break;
            case R.id.class2_3:
                title.setText("绑定周二第三节名单");
                timeid = 23;
                break;
            case R.id.class2_4:
                title.setText("绑定周二第四节名单");
                timeid = 24;
                break;
            case R.id.class2_5:
                title.setText("绑定周二第五节名单");
                timeid = 25;
                break;
            case R.id.class3_1:
                title.setText("绑定周三第一节名单");
                timeid = 31;
                break;
            case R.id.class3_2:
                title.setText("绑定周三第二节名单");
                timeid = 32;
                break;
            case R.id.class3_3:
                title.setText("绑定周三第三节名单");
                timeid = 33;
                break;
            case R.id.class3_4:
                title.setText("绑定周三第四节名单");
                timeid = 34;
                break;
            case R.id.class3_5:
                title.setText("绑定周三第五节名单");
                timeid = 35;
                break;
            case R.id.class4_1:
                title.setText("绑定周四第一节名单");
                timeid = 41;
                break;
            case R.id.class4_2:
                title.setText("绑定周四第二节名单");
                timeid = 42;
                break;
            case R.id.class4_3:
                title.setText("绑定周四第三节名单");
                timeid = 43;
                break;
            case R.id.class4_4:
                title.setText("绑定周四第四节名单");
                timeid = 44;
                break;
            case R.id.class4_5:
                title.setText("绑定周四第五节名单");
                timeid = 45;
                break;
            case R.id.class5_1:
                title.setText("绑定周五第一节名单");
                timeid = 51;
                break;
            case R.id.class5_2:
                title.setText("绑定周五第二节名单");
                timeid = 52;
                break;
            case R.id.class5_3:
                title.setText("绑定周五第三节名单");
                timeid = 53;
                break;
            case R.id.class5_4:
                title.setText("绑定周五第四节名单");
                timeid = 54;
                break;
            case R.id.class5_5:
                title.setText("绑定周五第五节名单");
                timeid = 55;
                break;
            case R.id.class6_1:
                title.setText("绑定周六第一节名单");
                timeid = 61;
                break;
            case R.id.class6_2:
                title.setText("绑定周六第二节名单");
                timeid = 62;
                break;
            case R.id.class6_3:
                title.setText("绑定周六第三节名单");
                timeid = 63;
                break;
            case R.id.class6_4:
                title.setText("绑定周六第四节名单");
                timeid = 64;
                break;
            case R.id.class6_5:
                title.setText("绑定周六第五节名单");
                timeid = 65;
                break;
            case R.id.class7_1:
                title.setText("绑定周日第一节名单");
                timeid = 71;
                break;
            case R.id.class7_2:
                title.setText("绑定周日第二节名单");
                timeid = 72;
                break;
            case R.id.class7_3:
                title.setText("绑定周日第三节名单");
                timeid = 73;
                break;
            case R.id.class7_4:
                title.setText("绑定周日第四节名单");
                timeid = 74;
                break;
            case R.id.class7_5:
                title.setText("绑定周日第五节名单");
                timeid = 75;
                break;
        }
        if (Constants.classbeans != null) {
            for (Classbean classbean : Constants.classbeans) {
                if (classbean.getTimeid() == timeid)
                    parentid = classbean.getClassid();
            }
        }
    }

}
