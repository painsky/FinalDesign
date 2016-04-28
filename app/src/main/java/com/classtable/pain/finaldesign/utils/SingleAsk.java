package com.classtable.pain.finaldesign.utils;

import java.util.Random;

/**
 * Created by pain on 2016/4/27.
 */
public class SingleAsk {
    public static void ask(){
        int num=Constants.studentbeans.size();
        Random random=new Random();
        int index=random.nextInt(num);
        Constants.studentbean=Constants.studentbeans.get(index);
    }
}
