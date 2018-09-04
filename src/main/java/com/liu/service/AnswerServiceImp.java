package com.liu.service;

import com.liu.beans.A2;
import com.liu.beans.AInf;
import com.liu.beans.Q2;
import com.liu.dao.A2Dao;
import com.liu.dao.InfDao;
import com.liu.dao.Q2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {
    @Autowired
    InfDao infDao;
    @Autowired
    A2Dao a2Dao;
    @Autowired
    Q2Dao q2Dao;

    @Override
    public Q2 getQ2(String userid) {
        List<A2> a2List = a2Dao.findById_Userid(userid);
        int sum = 1;

        sum+= a2List.size();

        if (sum>104)
        {
            return null;
        }
        else
        {
            List<Q2> q2List = q2Dao.findAllByQid(1);
            return q2List.get(0);
        }
    }

    @Override
    public int SetInfAnswer(String userid,String q1, String q2, int q3, int q4, String q5, int q6, int q7, int q8, int q9, int q10, int q11, int q12, int q13, int q14, int q15, int q16, int q17, int q18) {
        AInf aInf = new AInf(userid,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18);
        try
        {
            infDao.save(aInf);
        }
        catch(Exception e)
        {
         e.printStackTrace();
         return 0;
        }
        return  1;
    }
}
