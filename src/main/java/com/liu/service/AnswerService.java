package com.liu.service;

import com.liu.beans.Q2;

public interface AnswerService {
    public int SetInfAnswer(String userid,
                            String q1,
                            String q2,
                            int q3,
                            int q4,
                            String q5,
                            int q6,
                            int q7,
                            int q8,
                            int q9,
                            int q10,
                            int q11,
                            int q12,
                            int q13,
                            int q14,
                            int q15,
                            int q16,
                            int q17,
                            int q18);
    public Q2 getQ2(String userid);
    public Q2 getnextQ2(String qid);
}
