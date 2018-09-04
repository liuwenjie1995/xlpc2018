package com.liu.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stuinf")
public class AInf {
    @Id
    private String userid;

    private String q1;
    private String q2;
    private int q3;
    private int q4;
    private String q5;
    private int q6;
    private int q7;
    private int q8;
    private int q9;
    private int q10;
    private int q11;
    private int q12;
    private int q13;
    private int q14;
    private int q15;
    private int q16;
    private int q17;
    private int q18;

    public AInf() {
    }

    public AInf(String userid, String q1, String q2, int q3, int q4, String q5, int q6, int q7, int q8, int q9, int q10, int q11, int q12, int q13, int q14, int q15, int q16, int q17, int q18) {
        this.userid = userid;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
        this.q10 = q10;
        this.q11 = q11;
        this.q12 = q12;
        this.q13 = q13;
        this.q14 = q14;
        this.q15 = q15;
        this.q16 = q16;
        this.q17 = q17;
        this.q18 = q18;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public int getQ6() {
        return q6;
    }

    public void setQ6(int q6) {
        this.q6 = q6;
    }

    public int getQ7() {
        return q7;
    }

    public void setQ7(int q7) {
        this.q7 = q7;
    }

    public int getQ8() {
        return q8;
    }

    public void setQ8(int q8) {
        this.q8 = q8;
    }

    public int getQ9() {
        return q9;
    }

    public void setQ9(int q9) {
        this.q9 = q9;
    }

    public int getQ10() {
        return q10;
    }

    public void setQ10(int q10) {
        this.q10 = q10;
    }

    public int getQ11() {
        return q11;
    }

    public void setQ11(int q11) {
        this.q11 = q11;
    }

    public int getQ12() {
        return q12;
    }

    public void setQ12(int q12) {
        this.q12 = q12;
    }

    public int getQ13() {
        return q13;
    }

    public void setQ13(int q13) {
        this.q13 = q13;
    }

    public int getQ14() {
        return q14;
    }

    public void setQ14(int q14) {
        this.q14 = q14;
    }

    public int getQ15() {
        return q15;
    }

    public void setQ15(int q15) {
        this.q15 = q15;
    }

    public int getQ16() {
        return q16;
    }

    public void setQ16(int q16) {
        this.q16 = q16;
    }

    public int getQ17() {
        return q17;
    }

    public void setQ17(int q17) {
        this.q17 = q17;
    }

    public int getQ18() {
        return q18;
    }

    public void setQ18(int q18) {
        this.q18 = q18;
    }

    @Override
    public String toString() {
        return "AInf{" +
                "userid='" + userid + '\'' +
                ", q1='" + q1 + '\'' +
                ", q2='" + q2 + '\'' +
                ", q3=" + q3 +
                ", q4=" + q4 +
                ", q5='" + q5 + '\'' +
                ", q6=" + q6 +
                ", q7=" + q7 +
                ", q8=" + q8 +
                ", q9=" + q9 +
                ", q10=" + q10 +
                ", q11=" + q11 +
                ", q12=" + q12 +
                ", q13=" + q13 +
                ", q14=" + q14 +
                ", q15=" + q15 +
                ", q16=" + q16 +
                ", q17=" + q17 +
                ", q18=" + q18 +
                '}';
    }
}
