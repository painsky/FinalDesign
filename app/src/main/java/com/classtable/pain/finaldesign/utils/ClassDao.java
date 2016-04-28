package com.classtable.pain.finaldesign.utils;

import com.classtable.pain.finaldesign.MainApplication;
import com.classtable.pain.finaldesign.bean.Classbean;
import com.classtable.pain.finaldesign.bean.Studentbean;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

/**
 * Created by pain on 2016/4/5.
 */
public class ClassDao  {
    public static void save(Classbean classbean) {
        DbManager.DaoConfig daoConfig= Dbinit.getDaoConfig();
        DbManager db = x.getDb(daoConfig);
        try {
            db.saveOrUpdate(classbean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    public static void save(Studentbean studentbean) {
        DbManager.DaoConfig daoConfig= Dbinit.getDaoConfig();
        DbManager db = x.getDb(daoConfig);
        try {
            db.saveOrUpdate(studentbean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    public static void delete(Classbean classbean){
        DbManager.DaoConfig daoConfig= Dbinit.getDaoConfig();
        DbManager db = x.getDb(daoConfig);
        try {
            db.delete(classbean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param parent
     * 输入父亲id，查找所有学生，并改变studentbeans里面的学生数据
     */
    public static void findStudentBefore(int parent){
        DbManager.DaoConfig daoConfig= Dbinit.getDaoConfig();
        DbManager db = x.getDb(daoConfig);
        try {
//            Constants.classbeans=db.selector(Classbean.class).where("startweek", "<=", Constants.weekflag).and("endweek", ">=", Constants.weekflag).and(
//                    "singleordouble", "in", new String[]{"全", Constants.weekstyle()}).findAll();
           Constants.studentbeans=db.selector(Studentbean.class).where("parent","=",parent).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    public static  void  deleteStudent(Studentbean studentbean){
        DbManager.DaoConfig daoConfig= Dbinit.getDaoConfig();
        DbManager db = x.getDb(daoConfig);
        try {
            db.delete(studentbean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public static void findBefore(int timeid){
        if (Constants.classbeans!=null) {
            for (Classbean classbean : Constants.classbeans) {
                if (classbean.getTimeid() == timeid) {
                    Constants.findFlag = true;
                    Constants.findClassBean = classbean;
                    break;
                }
            }
        }


    }
    public static void initselect(){
        DbManager.DaoConfig daoConfig= Dbinit.getDaoConfig();
        DbManager db = x.getDb(daoConfig);
        try {
            Constants.classbeans=db.selector(Classbean.class).where("startweek", "<=", Constants.weekflag).and("endweek", ">=", Constants.weekflag).and(
                    "singleordouble", "in", new String[]{"全", Constants.weekstyle()}).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }

    }
}
