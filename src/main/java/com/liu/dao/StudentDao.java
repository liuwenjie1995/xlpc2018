package com.liu.dao;

import com.liu.beans.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student,Long> {
    @Query(value = "select * FROM student WHERE student.`学号` not in (SELECT A4.userid FROM a4 WHERE A4.qid=68)",nativeQuery = true)
    List<Student> findNotfinisher();
}
