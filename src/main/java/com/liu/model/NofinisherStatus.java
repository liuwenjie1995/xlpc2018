package com.liu.model;

import com.liu.beans.Student;

import java.util.List;

public class NofinisherStatus {
    public NofinisherStatus(List<Student> list) {
        this.list = list;
    }

    public NofinisherStatus() {
    }

    private List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "NofinisherStatus{" +
                "list=" + list +
                '}';
    }
}
