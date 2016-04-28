package com.classtable.pain.finaldesign.utils;

import android.widget.TextView;

import com.classtable.pain.finaldesign.MainActivity;
import com.classtable.pain.finaldesign.R;
import com.classtable.pain.finaldesign.bean.Classbean;

/**
 * Created by pain on 2016/4/14.
 */
public class ClearTextView {
    public void clear(MainActivity activity){
        if (Constants.classbeans!=null&&Constants.clearsize!=Constants.classbeans.size()){
            Constants.clearflag=true;
        }
        if (Constants.clearflag==true){
            TextView textview;
            switch (Constants.clearitime){
                case 11:
                    textview= (TextView) activity.findViewById(R.id.class1_1);
                    textview.setText("");
                    break;
                case 12:
                    textview= (TextView) activity.findViewById(R.id.class1_2);
                    textview.setText("");
                    break;
                case 13:
                    textview= (TextView) activity.findViewById(R.id.class1_3);
                    textview.setText("");
                    break;
                case 14:
                    textview= (TextView) activity.findViewById(R.id.class1_4);
                    textview.setText("");
                    break;
                case 15:
                    textview= (TextView) activity.findViewById(R.id.class1_5);
                    textview.setText("");
                    break;
                case 21:
                    textview= (TextView) activity.findViewById(R.id.class2_1);
                    textview.setText("");
                    break;
                case 22:
                    textview= (TextView) activity.findViewById(R.id.class2_2);
                    textview.setText("");
                    break;
                case 23:
                    textview= (TextView) activity.findViewById(R.id.class2_3);
                    textview.setText("");
                    break;
                case 24:
                    textview= (TextView) activity.findViewById(R.id.class2_4);
                    textview.setText("");
                    break;
                case 25:
                    textview= (TextView) activity.findViewById(R.id.class2_5);
                    textview.setText("");
                    break;
                case 31:
                    textview= (TextView) activity.findViewById(R.id.class3_1);
                    textview.setText("");
                    break;
                case 32:
                    textview= (TextView) activity.findViewById(R.id.class3_2);
                    textview.setText("");
                    break;
                case 33:
                    textview= (TextView) activity.findViewById(R.id.class3_3);
                    textview.setText("");
                    break;
                case 34:
                    textview= (TextView) activity.findViewById(R.id.class3_4);
                    textview.setText("");
                    break;
                case 35:
                    textview= (TextView) activity.findViewById(R.id.class3_5);
                    textview.setText("");
                    break;
                case 41:
                    textview= (TextView) activity.findViewById(R.id.class4_1);
                    textview.setText("");
                    break;
                case 42:
                    textview= (TextView) activity.findViewById(R.id.class4_2);
                    textview.setText("");
                    break;
                case 43:
                    textview= (TextView) activity.findViewById(R.id.class4_3);
                    textview.setText("");
                    break;
                case 44:
                    textview= (TextView) activity.findViewById(R.id.class4_4);
                    textview.setText("");
                    break;
                case 45:
                    textview= (TextView) activity.findViewById(R.id.class4_5);
                    textview.setText("");
                    break;
                case 51:
                    textview= (TextView) activity.findViewById(R.id.class5_1);
                    textview.setText("");
                    break;
                case 52:
                    textview= (TextView) activity.findViewById(R.id.class5_2);
                    textview.setText("");
                    break;
                case 53:
                    textview= (TextView) activity.findViewById(R.id.class5_3);
                    textview.setText("");
                    break;
                case 54:
                    textview= (TextView) activity.findViewById(R.id.class5_4);
                    textview.setText("");break;
                case 55:
                    textview= (TextView) activity.findViewById(R.id.class5_5);
                    textview.setText("");
                    break;
                case 61:
                    textview= (TextView) activity.findViewById(R.id.class6_1);
                    textview.setText("");
                    break;
                case 62:
                    textview= (TextView) activity.findViewById(R.id.class6_2);
                    textview.setText("");
                    break;
                case 63:
                    textview= (TextView) activity.findViewById(R.id.class6_3);
                    textview.setText("");
                    break;
                case 64:
                    textview= (TextView) activity.findViewById(R.id.class6_4);
                    textview.setText("");
                    break;
                case 65:
                    textview= (TextView) activity.findViewById(R.id.class6_5);
                    textview.setText("");
                    break;
                case 71:
                    textview= (TextView) activity.findViewById(R.id.class7_1);
                    textview.setText("");
                    break;
                case 72:
                    textview= (TextView) activity.findViewById(R.id.class7_2);
                    textview.setText("");
                    break;
                case 73:
                    textview= (TextView) activity.findViewById(R.id.class7_3);
                    textview.setText("");
                    break;
                case 74:
                    textview= (TextView) activity.findViewById(R.id.class7_4);
                    textview.setText("");
                    break;
                case 75:
                    textview= (TextView) activity.findViewById(R.id.class7_5);
                    textview.setText("");
                    break;

            }

        }
    }
}
