package com.liu.beans;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table()
public class A2 {

    @EmbeddedId
    private Userqid id;
    private int mark;

    public A2() {
    }

    public A2(Userqid id, int mark) {
        this.id = id;
        this.mark = mark;
    }

    public A2(String userid,String qid,int mark)
    {
        Userqid userqid = new Userqid(userid,qid);
        this.id = userqid;
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
        return "A2{" +
                "id=" + id +
                ", mark=" + mark +
                '}';
    }



}

