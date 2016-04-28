package com.classtable.pain.finaldesign;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.classtable.pain.finaldesign.bean.Classbean;
import com.classtable.pain.finaldesign.utils.ClassDao;
import com.classtable.pain.finaldesign.utils.Constants;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by pain on 2016/4/4.
 */
public class EditClassActivity extends Activity{
    @ViewInject(R.id.add_title)
    private TextView title;
    @ViewInject(R.id.edittext_classname)
    private EditText editTextClassName;
    @ViewInject(R.id.edittext_room)
    private EditText editTextClassRoom;
    @ViewInject(R.id.edittext_start_week)
    private EditText editTextStartWeek;
    @ViewInject(R.id.edittext_end_week)
    private EditText editTextEndWeek;
    @ViewInject(R.id.button_save)
    private Button buttonSubmit;
    @ViewInject(R.id.radiogroup)
    private RadioGroup radioGroup;
    @ViewInject(R.id.rd_all)
    private RadioButton radioButtonAll;
    @ViewInject(R.id.rd_single)
    private RadioButton radioButtonSingle;
    @ViewInject(R.id.rd_double)
    private RadioButton radioButtonDouble;
    private int timeid;
    private String singleordouble="全";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_add);
        x.view().inject(this);
        initClassFlag();
        radioGroup= (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==radioButtonDouble.getId()){
                    singleordouble="双";

                }else if (checkedId==radioButtonSingle.getId()){
                    singleordouble="单";

                }
                else {
                    singleordouble="全";
                }
            }

        });
        initInformation();
    }

    private void initInformation() {
        String classname=Constants.findClassBean.getClassname();
        String classlocation=Constants.findClassBean.getClasslocation();
        String singleordouble=Constants.findClassBean.getSingleordouble();
        int startweek=Constants.findClassBean.getStartweek();
        int endweek=Constants.findClassBean.getEndweek();
        editTextClassName.setText(classname);
        editTextClassRoom.setText(classlocation);
        editTextStartWeek.setText(startweek+"");
        editTextEndWeek.setText(endweek+"");
        if (singleordouble.equals("单")){
           radioGroup.check(R.id.rd_single);
        }else if (singleordouble.equals("双")){
            radioGroup.check(R.id.rd_double);
        }else {
            radioGroup.check(R.id.rd_all );
        }
    }

    @Event(value=R.id.button_save,type = View.OnClickListener.class)
    private void submit(View view) {

        int start=Integer.valueOf(editTextStartWeek.getText().toString());
        int end=Integer.valueOf(editTextEndWeek.getText().toString());
        String classroom=editTextClassRoom.getText().toString();
        String classname=editTextClassName.getText().toString();
        Classbean classbean=Constants.findClassBean;
        classbean.setTimeid(timeid);
        classbean.setSingleordouble(singleordouble);
        classbean.setClasslocation(classroom);
        classbean.setClassname(classname);
        classbean.setStartweek(start);
        classbean.setEndweek(end);
        Constants.clearsize=Constants.classbeans.size();
        Constants.clearitime=classbean.getTimeid();
        ClassDao.save(classbean);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ClassDao.initselect();
                System.out.println(Constants.classbeans.size()+"sssssssssssssssssssssssssssssssss");
                Message msg=new Message();
                msg.what=1;
                handler.sendMessage(msg);
            }
        }).start();
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    EditClassActivity.this.finish();
                    Toast.makeText(getApplicationContext(),"课程修改成功",Toast.LENGTH_SHORT).show();
                    break;
            }        }
    };
    private void initClassFlag() {
        switch (Constants.idRestore){
            case R.id.class1_1:
                title.setText("修改周一第一节");
                timeid=11;
                break;
            case R.id.class1_2:
                title.setText("修改周一第二节");
                timeid=12;
                break;
            case R.id.class1_3:
                title.setText("修改周一第三节");
                timeid=13;
                break;
            case R.id.class1_4:
                title.setText("修改周一第四节");
                timeid=14;
                break;
            case R.id.class1_5:
                title.setText("修改周一第五节");
                timeid=15;
                break;
            case R.id.class2_1:
                title.setText("修改周二第一节");
                timeid=21;
                break;
            case R.id.class2_2:
                title.setText("修改周二第二节");
                timeid=22;
                break;
            case R.id.class2_3:
                title.setText("修改周二第三节");
                timeid=23;
                break;
            case R.id.class2_4:
                title.setText("修改周二第四节");
                timeid=24;
                break;
            case R.id.class2_5:
                title.setText("修改周二第五节");
                timeid=25;
                break;
            case R.id.class3_1:
                title.setText("修改周三第一节");
                timeid=31;
                break;
            case R.id.class3_2:
                title.setText("修改周三第二节");
                timeid=32;
                break;
            case R.id.class3_3:
                title.setText("修改周三第三节");
                timeid=33;
                break;
            case R.id.class3_4:
                title.setText("修改周三第四节");
                timeid=34;
                break;
            case R.id.class3_5:
                title.setText("修改周三第五节");
                timeid=35;
                break;
            case R.id.class4_1:
                title.setText("修改周四第一节");
                timeid=41;
                break;
            case R.id.class4_2:
                title.setText("修改周四第二节");
                timeid=42;
                break;
            case R.id.class4_3:
                title.setText("修改周四第三节");
                timeid=43;
                break;
            case R.id.class4_4:
                title.setText("修改周四第四节");
                timeid=44;
                break;
            case R.id.class4_5:
                title.setText("修改周四第五节");
                timeid=45;
                break;
            case R.id.class5_1:
                title.setText("修改周五第一节");
                timeid=51;
                break;
            case R.id.class5_2:
                title.setText("修改周五第二节");
                timeid=52;
                break;
            case R.id.class5_3:
                title.setText("修改周五第三节");
                timeid=53;
                break;
            case R.id.class5_4:
                title.setText("修改周五第四节");
                timeid=54;
                break;
            case R.id.class5_5:
                title.setText("修改周五第五节");
                timeid=55;
                break;
            case R.id.class6_1:
                title.setText("修改周六第一节");
                timeid=61;
                break;
            case R.id.class6_2:
                title.setText("修改周六第二节");
                timeid=62;
                break;
            case R.id.class6_3:
                title.setText("修改周六第三节");
                timeid=63;
                break;
            case R.id.class6_4:
                title.setText("修改周六第四节");
                timeid=64;
                break;
            case R.id.class6_5:
                title.setText("修改周六第五节");
                timeid=65;
                break;
            case R.id.class7_1:
                title.setText("修改周日第一节");
                timeid=71;
                break;
            case R.id.class7_2:
                title.setText("修改周日第二节");
                timeid=72;
                break;
            case R.id.class7_3:
                title.setText("修改周日第三节");
                timeid=73;
                break;
            case R.id.class7_4:
                title.setText("修改周日第四节");
                timeid=74;
                break;
            case R.id.class7_5:
                title.setText("修改周日第五节");
                timeid=75;
                break;
        }
    }
}
