package com.liu.service;

import com.liu.beans.User;
import com.liu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    final
    UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getuser(String userid, String password) {
        Iterable<User> userList= userDao.findUser(userid,password);
        if (!userList.iterator().hasNext())
        {

            return null;
        }
        else return userList.iterator().next();
    }

    @Override
    public List<User> getalluser() {
        Iterable<User> userIterable = userDao.findAll();
        List<User> userList = new ArrayList<User>();
        userIterable.forEach(single->{userList.add(single);});
        return userList;
    }
}
