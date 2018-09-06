package com.liu.dao;

import com.liu.beans.A2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface A2Dao extends CrudRepository<A2,Integer> {
    List<A2> findById_Userid(String userid);
    @Query(value = "delete * from A2 where A2.userid='manager'",nativeQuery = true)
    Boolean cleanmanager2();
}
