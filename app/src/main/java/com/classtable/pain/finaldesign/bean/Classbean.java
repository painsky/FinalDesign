package com.classtable.pain.finaldesign.bean;

import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pain on 2016/3/28.
 */
@Table(name="classall")
public class Classbean {
    @Column(name="classid",isId = true,autoGen = true)
    private int classid;
    @Column(name="timeid")
    private int timeid;
    @Column(name="singleordouble")
    private String singleordouble="全";
    @Column(name="classname")
    private String classname="暂未设置";
    @Column(name="startweek")
    private int startweek=1;
    @Column(name="endweek")
    private int endweek=18;
    @Column(name="classlocation")
    private String classlocation="暂未设置";
    public List<Studentbean> getStudents(DbManager db) throws DbException{
        return db.selector(Studentbean.class).where("parentid", "=", this.classid).findAll();
    }
    public int getTimeid() {
        return timeid;
    }

    public void setTimeid(int timeid) {
        this.timeid = timeid;
    }

    public int getClassid() {
        return classid;
    }

    @Override
    public String toString() {
        return "Classbean{" +
                "classid=" + classid +
                ", timeid=" + timeid +
                ", singleordouble='" + singleordouble + '\'' +
                ", classname='" + classname + '\'' +
                ", startweek=" + startweek +
                ", endweek=" + endweek +
                ", classlocation='" + classlocation + '\'' +
                '}';
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSingleordouble() {
        return singleordouble;
    }

    public void setSingleordouble(String singleordouble) {
        this.singleordouble = singleordouble;
    }

    public int getStartweek() {
        return startweek;
    }

    public void setStartweek(int startweek) {
        this.startweek = startweek;
    }

    public String getClasslocation() {
        return classlocation;
    }

    public void setClasslocation(String classlocation) {
        this.classlocation = classlocation;
    }

    public int getEndweek() {
        return endweek;
    }

    public void setEndweek(int endweek) {
        this.endweek = endweek;
    }
}
