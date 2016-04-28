package com.classtable.pain.finaldesign.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.classtable.pain.finaldesign.R;
import com.classtable.pain.finaldesign.bean.Studentbean;

/**
 * Created by pain on 2016/4/26.
 */
public class StudentAdapter extends BaseAdapter {
    private Context context;

    public StudentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Constants.studentbeans.size();
    }

    @Override
    public Object getItem(int position) {
        return Constants.studentbeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Studentbean studentbean=Constants.studentbeans.get(position);
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_showstudent,null);
            viewHolder=new ViewHolder();
            viewHolder.textViewNumber= (TextView) convertView.findViewById(R.id.textview_studentnumber);
            viewHolder.textViewName= (TextView) convertView.findViewById(R.id.textview_studentname);
            viewHolder.textViewClass= (TextView) convertView.findViewById(R.id.textview_studentclass);
            viewHolder.textViewLater= (TextView) convertView.findViewById(R.id.textview_studentlater);
            viewHolder.textViewAnswer= (TextView) convertView.findViewById(R.id.textview_studentanswer);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textViewNumber.setText(studentbean.getStudentnumber()+"");
        viewHolder.textViewName.setText(studentbean.getStudentname()+"");
        viewHolder.textViewClass.setText(studentbean.getStudentclass()+"");
        viewHolder.textViewLater.setText(studentbean.getStudentlatertimes()+"");
        viewHolder.textViewAnswer.setText(studentbean.getStudentanswertimes() + "");
        viewHolder.textViewLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = studentbean.getStudentlatertimes() + 1;
                studentbean.setStudentlatertimes(a);
                ClassDao.save(studentbean);
                notifyDataSetChanged();
            }
        });
        viewHolder.textViewLater.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int a = studentbean.getStudentlatertimes() - 1;
                if (a < 0) {
                    a = 0;
                }
                studentbean.setStudentlatertimes(a);
                ClassDao.save(studentbean);
                notifyDataSetChanged();
                return true;
            }
        });
        viewHolder.textViewAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = studentbean.getStudentanswertimes() + 1;
                studentbean.setStudentanswertimes(a);
                ClassDao.save(studentbean);
                notifyDataSetChanged();
            }
        });
        viewHolder.textViewAnswer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int a = studentbean.getStudentanswertimes()- 1;
                if (a < 0) {
                    a = 0;
                }
                studentbean.setStudentanswertimes(a);
                ClassDao.save(studentbean);
                notifyDataSetChanged();
                return true;
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,studentbean.getStudentname()+"",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
class ViewHolder{
    TextView textViewNumber;
    TextView textViewName;
    TextView textViewClass;
    TextView textViewLater;
    TextView textViewAnswer;

}
