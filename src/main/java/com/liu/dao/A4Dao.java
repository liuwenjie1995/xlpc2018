package com.liu.dao;

import com.liu.beans.A4;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface A4Dao extends CrudRepository<A4,Long> {
    List<A4> findById_Userid(String userid);

    @Query(value = "select userid from A4 where A4.qid=68",nativeQuery = true)
    List<String> findfinisher();
}
