package com.liu.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class Qinf {
    @Id
    private int num;
    private String Question;

    public Qinf() {
    }

    public Qinf(int num, String question) {
        this.num = num;
        Question = question;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    @Override
    public String toString() {
        return "Qinf{" +
                "num=" + num +
                ", Question='" + Question + '\'' +
                '}';
    }
}
