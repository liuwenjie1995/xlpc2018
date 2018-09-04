package com.liu.beans;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table()
public class A4 {
    @EmbeddedId
    private Userqid id;
    private int mark;

    public A4() {
    }

    public A4(Userqid id, int mark) {
        this.id = id;
        this.mark = mark;
    }

    public Userqid getId() {
        return id;
    }

    public void setId(Userqid id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "A4{" +
                "id=" + id +
                ", mark=" + mark +
                '}';
    }

    @Embeddable
    class Userqid implements Serializable{
        private String userid;
        private int qid;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public int getQid() {
            return qid;
        }

        public void setQid(int qid) {
            this.qid = qid;
        }
    }
}
