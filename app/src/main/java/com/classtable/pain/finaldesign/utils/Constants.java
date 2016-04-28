package com.classtable.pain.finaldesign.utils;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.MediaStore;

import com.classtable.pain.finaldesign.bean.Classbean;
import com.classtable.pain.finaldesign.bean.Studentbean;

import org.xutils.DbManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by pain on 2016/4/4.
 */
public class Constants {
   public static final String[] askArray=new String[]{"没答上来","人不在","回答正确"};
   public static final String[] longClickArray=new String[]{"课程添加","课程修改","课程删除","绑定名单","设置提醒","灵犀一指"};
   public static List<Classbean> classbeans;
   public static boolean findFlag=false;
   public static Classbean findClassBean;
   public static Activity activity;
   public static int idRestore=0;
   public static int weekflag=8;
   public static int clearitime=-1;
   public static int clearsize=-1;
   public static boolean clearflag=false;
   public static int  weekdayflag;
   public static Calendar calendar;
   public static List<Studentbean> studentbeans;
   public static int alarmnumber=0;
   public static int alarmday=0;
   public static boolean alarmabale=true;
   public static int alarmstatus=1;
   public static Studentbean studentbean;
   public static int result=0;
   public static String weekstyle(){
      if (weekflag%2==0){
         return "双";
      }else {
         return "单";
      }
   }

   public static String getFileNameByUri(Context context, Uri uri)
   {
      String fileName="unknown";//default fileName
      Uri filePathUri = uri;
      if (uri.getScheme().toString().compareTo("content")==0)
      {
         Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
         if (cursor.moveToFirst())
         {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);//Instead of "MediaStore.Images.Media.DATA" can be used "_data"
            filePathUri = Uri.parse(cursor.getString(column_index));
            fileName = filePathUri.getLastPathSegment().toString();
         }
      }
      else if (uri.getScheme().compareTo("file")==0)
      {
         fileName = filePathUri.getLastPathSegment().toString();
      }
      else
      {
         fileName = fileName+"_"+filePathUri.getLastPathSegment();
      }
      return fileName;
   }
}
