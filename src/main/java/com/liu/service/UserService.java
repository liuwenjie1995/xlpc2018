package com.liu.service;

import com.liu.beans.User;

import java.util.List;

public interface UserService {
    public User getuser(String userid,String password);
    public List<User> getalluser();

}
