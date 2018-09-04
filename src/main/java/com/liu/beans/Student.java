package com.liu.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class Student {

    public Student() {
    }

    public Student(String userid, String clazz, String username, String brith, String sex, String academy, String major) {
        this.userid = userid;
        this.clazz = clazz;
        this.username = username;
        this.brith = brith;
        this.sex = sex;
        this.academy = academy;
        this.major = major;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBrith() {
        return brith;
    }

    public void setBrith(String brith) {
        this.brith = brith;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Id
    @Column(name = "学号")
    private String userid;
    @Column(name = "班级")
    private String clazz;
    @Column(name = "考生姓名")
    private String username;
    @Column(name = "出生日期")
    private String brith;
    @Column(name = "性别")
    private String sex;
    @Column(name = "学院")
    private String academy;
    @Column(name = "录取专业名称")
    private String major;

    @Override
    public String toString() {
        return "Student{" +
                "userid='" + userid + '\'' +
                ", clazz='" + clazz + '\'' +
                ", username='" + username + '\'' +
                ", brith='" + brith + '\'' +
                ", sex='" + sex + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
