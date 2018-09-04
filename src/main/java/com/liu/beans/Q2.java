package com.liu.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "q2")
public class Q2 {
    @Id
    @Column(name = "qID")
    private int qid;
    @Column(name = "qContent")
    private String qcontent;

    public Q2() {
    }

    public Q2(int qid, String qcontent) {
        this.qid = qid;
        this.qcontent = qcontent;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQcontent() {
        return qcontent;
    }

    public void setQcontent(String qcontent) {
        this.qcontent = qcontent;
    }

    @Override
    public String toString() {
        return "Q2{" +
                "qid=" + qid +
                ", qcontent='" + qcontent + '\'' +
                '}';
    }
}
