package com.classtable.pain.finaldesign;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.classtable.pain.finaldesign.utils.ClassDao;
import com.classtable.pain.finaldesign.utils.ClearAllTextView;
import com.classtable.pain.finaldesign.utils.Constants;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by pain on 2016/4/25.
 */
public class SettingWeekActivity extends Activity {
    @ViewInject(R.id.button_settingsubmit)
    private Button buttonSubmit;
    @ViewInject(R.id.textview_settingweek)
    private TextView textviewCurrentWeek;
    @ViewInject(R.id.edittext_week)
    private EditText edittextnewWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_setting);
        x.view().inject(this);
        textviewCurrentWeek.setText("当前周为第"+Constants.weekflag+"周");
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weektemp= edittextnewWeek.getText().toString();
                if (!TextUtils.isEmpty(edittextnewWeek.getText())){
                    int week=Integer.valueOf(weektemp);
                    Constants.weekflag=week;
                    SharedPreferences setting = getSharedPreferences("Setting.ini", 0);
                    setting.edit().putInt("WEEK",Constants.weekflag).commit();
                    new ClearAllTextView().clearAll((MainActivity) Constants.activity);
                    ClassDao.initselect();
                    SettingWeekActivity.this.finish();

                }else {
                    Toast.makeText(SettingWeekActivity.this,"请输入新周",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
