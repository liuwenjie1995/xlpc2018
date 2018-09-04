package com.liu.beans;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "q4")
public class Q4 {
    @Id
    private int qID;
    private String qContent;

    public Q4() {
    }

    public Q4(int qID, String qContent) {
        this.qID = qID;
        this.qContent = qContent;
    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    @Override
    public String toString() {
        return "Q4{" +
                "qID=" + qID +
                ", qContent='" + qContent + '\'' +
                '}';
    }
}
