package com.liu.controller;

import com.liu.beans.A2;
import com.liu.beans.Q2;
import com.liu.model.AnswerStatus;
import com.liu.model.NorResponse;
import com.liu.model.Q2Status;
import com.liu.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/")
public class LinkController {
    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    String defaulturl(){return "/main/login";}
    @RequestMapping(value = "login",method = RequestMethod.GET)
    String login(){
        return "/main/login";
    }
    @RequestMapping(value = "forget",method = RequestMethod.GET)
    String forget()
    {
        return "/main/forgetpassword";
    }
    @RequestMapping(value = "question1",method = RequestMethod.GET)
    String question1(){return  "/question/question1";}
    @RequestMapping(value = "question2guide",method = RequestMethod.GET)
    String question2guide(){return "/question/question2guide";}
    @RequestMapping(value = "question2",method = RequestMethod.GET)
    String question2(HttpSession session,HttpServletRequest request){

        if(session.getAttribute("userid")==null)
        {
            return "/login";
        }

        String userid = session.getAttribute("userid").toString();

        if (answerService.getQ2(userid)!=null)
        {
            Q2 q2 = answerService.getQ2(userid);
            int qid = q2.getQid();
            String qcontent = q2.getQcontent();
         request.setAttribute("qid",qid);
         request.setAttribute("qcontent",qcontent);
        }
        return "/question/question2";}
    @RequestMapping(value = "question4guide",method = RequestMethod.GET)
    String question4guide(){return "/question/question4guide";}
    @RequestMapping(value = "question4",method = RequestMethod.GET)
    String question4(){return "/question/question4";}
    @RequestMapping(value = "teacherinf",method = RequestMethod.GET)
    String teacherinf(){return "/introduce/teacher";}
}
