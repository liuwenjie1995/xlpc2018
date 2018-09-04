package com.liu.beans;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Userqid implements Serializable {
    private String userid;
    private String qid;

    public Userqid() {
    }

    public Userqid(String userid) {
        this.userid = userid;
    }


    public Userqid(String userid, String qid) {
        this.userid = userid;
        this.qid = qid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    @Override
    public String toString() {
        return "Userqid{" +
                "userid='" + userid + '\'' +
                ", qid='" + qid + '\'' +
                '}';
    }
}