package com.liu.dao;

import com.liu.beans.Q4;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Q4Dao extends CrudRepository<Q4,Integer> {
    List<Q4> findByQID(int qid);
}
