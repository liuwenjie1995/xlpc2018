package com.liu.model;

public class Q2Status {
    private int qid;
    private String qcontent;

    public Q2Status() {
    }

    public Q2Status(int qid, String qcontent) {
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
        return "Q2Status{" +
                "qid=" + qid +
                ", qcontent='" + qcontent + '\'' +
                '}';
    }
}
