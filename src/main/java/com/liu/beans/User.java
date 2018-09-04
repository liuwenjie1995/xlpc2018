package com.liu.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class User {
    @Id
    private String userid;
    private String password;
    private Integer rank;

    public User() {
    }

    public User(String userid, String password, Integer rank) {
        this.userid = userid;
        this.password = password;
        this.rank = rank;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", rank=" + rank +
                '}';
    }
}
