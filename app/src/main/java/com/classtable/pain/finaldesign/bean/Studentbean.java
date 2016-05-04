package com.classtable.pain.finaldesign.bean;

import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;
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
    @Column(name="studentabsenttimes")
    private int studentabsenttimes=0;
    @Column(name="studentlaterdetail")
    private String studentlaterdetail="";
    @Column(name="studentanswerdetail")
    private String studentanswerdetail="";
    @Column(name="studentabsentdetail")
    private String studentabsentdetail="";
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

    public String getStudentabsentdetail() {
        return studentabsentdetail;
    }

    public void setStudentabsentdetail(String studentabsentdetail) {
        this.studentabsentdetail = studentabsentdetail;
    }

    public int getStudentabsenttimes() {
        return studentabsenttimes;
    }

    public void setStudentabsenttimes(int studentabsenttimes) {
        this.studentabsenttimes = studentabsenttimes;
    }

    public String getStudentlaterdetail() {
        return studentlaterdetail;
    }

    public void setStudentlaterdetail(String studentlaterdetail) {
        this.studentlaterdetail = studentlaterdetail;
    }

    public String getStudentanswerdetail() {
        return studentanswerdetail;
    }

    public void setStudentanswerdetail(String studentanswerdetail) {
        this.studentanswerdetail = studentanswerdetail;
    }
}
