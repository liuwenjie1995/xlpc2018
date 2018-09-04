package com.liu.dao;

import com.liu.beans.Q2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Q2Dao extends CrudRepository<Q2,Integer>{
    List<Q2> findAllByQid(int qid);
}
