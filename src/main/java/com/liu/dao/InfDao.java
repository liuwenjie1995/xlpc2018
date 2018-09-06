package com.liu.dao;

import com.liu.beans.AInf;
import com.liu.beans.Qinf;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InfDao  extends CrudRepository<AInf,Integer>{
    List<AInf> findByUserid(String userid);
}
