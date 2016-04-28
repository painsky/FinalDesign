package com.classtable.pain.finaldesign.bean;

import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;

/**
 * Created by pain on 2016/3/28.
 */
@Table(name="studentall")
public class Studentbean {
    @Column(name="studentclassid",isId = true,autoGen = true)
    private int studentclassid;
    @Column(name="studentnumber")
    private String studentnumber;
    @Column(name="studentname")
    private String studentname;
    @Column(name="studentclass")
    private String studentclass;
    @Column(name="studentlatertimes")
    private int studentlatertimes=0;
    @Column(name="studentanswertimes")
    private int studentanswertimes=0;
    @Column(name="parent")
    private int parentid;

    public Classbean getParent(DbManager db) throws DbException {
        return db.findById(Classbean.class, parentid);
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }
    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass;
    }

    public int getStudentlatertimes() {
        return studentlatertimes;
    }

    public void setStudentlatertimes(int studentlatertimes) {
        this.studentlatertimes = studentlatertimes;
    }

    public int getStudentanswertimes() {
        return studentanswertimes;
    }

    public void setStudentanswertimes(int studentanswertimes) {
        this.studentanswertimes = studentanswertimes;
    }
}
