package com.liu.model;

public class Q4status {

    private int qid;
    private String qcontent;

    public Q4status() {
    }

    public Q4status(int qid, String qcontent) {
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
        return "Q4status{" +
                "qid=" + qid +
                ", qcontent='" + qcontent + '\'' +
                '}';
    }
}
