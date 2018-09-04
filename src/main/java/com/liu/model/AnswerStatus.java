package com.liu.model;

public class AnswerStatus {
    private int status;

    public AnswerStatus() {
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AnswerStatus{" +
                "status=" + status +
                '}';
    }
}
