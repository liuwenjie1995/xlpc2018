package com.liu.dao;

import com.liu.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer>{
    @Query("select o from User o where o.userid=?1 and o.password=?2")
    List<User> findUser(String userid,String password);
    @Query("select o from  User o where o.userid=?1")
    List<User> getNameById(String useid);
}
