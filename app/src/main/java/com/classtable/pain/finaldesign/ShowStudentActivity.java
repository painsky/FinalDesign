package com.classtable.pain.finaldesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.classtable.pain.finaldesign.bean.Studentbean;
import com.classtable.pain.finaldesign.utils.ClassDao;
import com.classtable.pain.finaldesign.utils.Constants;
import com.classtable.pain.finaldesign.utils.StudentAdapter;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Created by pain on 2016/4/17.
 */
public class ShowStudentActivity extends Activity {
    private ListView listView;
    private ImageButton imageButton;
    public String toast="没有名单可以导出QAQ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_showstudent);
        imageButton= (ImageButton) findViewById(R.id.imagebutton_student);
        listView= (ListView)findViewById(R.id.lv_student);
        listView.setAdapter(new StudentAdapter(this));
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(ShowStudentActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_student,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_student_export:
                                saveasExcel();
                                Toast.makeText(ShowStudentActivity.this, "导出至名单至/sdcard/"+toast, Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void saveasExcel() {
        WritableWorkbook book  = null;
        String name=Constants.findClassBean.getClassname();
        String temp=Constants.findClassBean.getTimeid()+"";
        temp=name+"周"+temp.substring(0,1)+"第"+temp.substring(1)+"节"+".xls";
        try {
            int i=1;
            book = Workbook.createWorkbook(new File(Environment.getExternalStorageDirectory().getPath(),temp));
            //  生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 );
            //  在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
            //  以及单元格内容为test
            sheet.addCell(new Label(0,0,"学号"));
            sheet.addCell(new Label(1,0,"姓名"));
            sheet.addCell(new Label(2,0,"班级"));
            sheet.addCell(new Label(3,0,"迟到"));
            sheet.addCell(new Label(4, 0, "回答"));
            for(Studentbean studentbean: Constants.studentbeans){
                sheet.addCell(new Label(0,i,studentbean.getStudentnumber()));
                sheet.addCell(new Label(1,i,studentbean.getStudentname()));
                sheet.addCell(new Label(2,i,studentbean.getStudentclass()));
                sheet.addCell(new Label(3,i,studentbean.getStudentlatertimes()+""));
                sheet.addCell(new Label(4,i,studentbean.getStudentanswertimes()+""));
                i++;
            }
            toast=temp;
            book.write();
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
