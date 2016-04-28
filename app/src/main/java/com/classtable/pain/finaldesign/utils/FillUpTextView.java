package com.classtable.pain.finaldesign.utils;

import android.content.Context;
import android.widget.TextView;

import com.classtable.pain.finaldesign.AddClassActivity;
import com.classtable.pain.finaldesign.MainActivity;
import com.classtable.pain.finaldesign.R;
import com.classtable.pain.finaldesign.bean.Classbean;

import java.util.List;

/**
 * Created by pain on 2016/4/5.
 */
public class FillUpTextView {
    public void fill(MainActivity activity){
        for (Object ob:Constants.classbeans){
            Classbean classbean= (Classbean) ob;
            TextView textview;
           switch (classbean.getTimeid()){
                case 11:
                    textview= (TextView) activity.findViewById(R.id.class1_1);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 12:
                    textview= (TextView) activity.findViewById(R.id.class1_2);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 13:
                    textview= (TextView) activity.findViewById(R.id.class1_3);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 14:
                    textview= (TextView) activity.findViewById(R.id.class1_4);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 15:
                    textview= (TextView) activity.findViewById(R.id.class1_5);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 21:
                    textview= (TextView) activity.findViewById(R.id.class2_1);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 22:
                    textview= (TextView) activity.findViewById(R.id.class2_2);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 23:
                    textview= (TextView) activity.findViewById(R.id.class2_3);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 24:
                    textview= (TextView) activity.findViewById(R.id.class2_4);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 25:
                    textview= (TextView) activity.findViewById(R.id.class2_5);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 31:
                    textview= (TextView) activity.findViewById(R.id.class3_1);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 32:
                    textview= (TextView) activity.findViewById(R.id.class3_2);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 33:
                    textview= (TextView) activity.findViewById(R.id.class3_3);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 34:
                    textview= (TextView) activity.findViewById(R.id.class3_4);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 35:
                    textview= (TextView) activity.findViewById(R.id.class3_5);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 41:
                    textview= (TextView) activity.findViewById(R.id.class4_1);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 42:
                    textview= (TextView) activity.findViewById(R.id.class4_2);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 43:
                    textview= (TextView) activity.findViewById(R.id.class4_3);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 44:
                    textview= (TextView) activity.findViewById(R.id.class4_4);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 45:
                    textview= (TextView) activity.findViewById(R.id.class4_5);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 51:
                    textview= (TextView) activity.findViewById(R.id.class5_1);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 52:
                    textview= (TextView) activity.findViewById(R.id.class5_2);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 53:
                    textview= (TextView) activity.findViewById(R.id.class5_3);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 54:
                    textview= (TextView) activity.findViewById(R.id.class5_4);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");break;
                case 55:
                    textview= (TextView) activity.findViewById(R.id.class5_5);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 61:
                    textview= (TextView) activity.findViewById(R.id.class6_1);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 62:
                    textview= (TextView) activity.findViewById(R.id.class6_2);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 63:
                    textview= (TextView) activity.findViewById(R.id.class6_3);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 64:
                    textview= (TextView) activity.findViewById(R.id.class6_4);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 65:
                    textview= (TextView) activity.findViewById(R.id.class6_5);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 71:
                    textview= (TextView) activity.findViewById(R.id.class7_1);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 72:
                    textview= (TextView) activity.findViewById(R.id.class7_2);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 73:
                    textview= (TextView) activity.findViewById(R.id.class7_3);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 74:
                    textview= (TextView) activity.findViewById(R.id.class7_4);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;
                case 75:
                    textview= (TextView) activity.findViewById(R.id.class7_5);
                    textview.setText(classbean.getClassname()+"\n"+classbean.getClasslocation()+"\n"+classbean.getSingleordouble()+"周");
                    break;

            }
        }
    }
}
