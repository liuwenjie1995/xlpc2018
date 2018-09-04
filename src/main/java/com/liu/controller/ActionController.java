package com.liu.controller;

import com.liu.beans.User;
import com.liu.dao.UserDao;
import com.liu.model.LoginStatus;
import com.liu.model.NorResponse;
import com.liu.service.AnswerService;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/action")
public class ActionController {
    @Autowired
    UserService userService;
    @Autowired
    AnswerService answerService;


    @RequestMapping("/login")
    NorResponse userlogin(@RequestParam Map<String,Object> param, HttpSession session){

        String userid = (String)param.get("userid");
        String password = (String)param.get("password");
        User user = userService.getuser(userid,password);
        if (user!=null)
        {
            session.setAttribute("userid",userid);
            session.setAttribute("rank",user.getRank());
            NorResponse<LoginStatus> rightresopnse = new NorResponse<>(1,"login success",new LoginStatus(1));

            return rightresopnse;
        }
        else{
            NorResponse<LoginStatus> falseresponse = new NorResponse<>(1,"用户名或密码错误",new LoginStatus(0));

            return falseresponse;
        }
    }

    @RequestMapping("/question1")
    NorResponse question1(@RequestParam Map<String,Object> params,HttpSession session)
    {
        Object userid = session.getAttribute("userid");
        String q1 = params.get("q1").toString();
        String q2 = params.get("q2").toString();
        int q3 = Integer.parseInt(params.get("q3").toString());
        int q4 = Integer.parseInt(params.get("q4").toString());
        String q5 = params.get("q5").toString();
        int q6 = Integer.parseInt(params.get("q6").toString());
        int q7 = Integer.parseInt(params.get("q7").toString());
        int q8 = Integer.parseInt(params.get("q8").toString());
        int q9 = Integer.parseInt(params.get("q9").toString());
        int q10 = Integer.parseInt(params.get("q10").toString());
        int q11 = Integer.parseInt(params.get("q11").toString());
        int q12 = Integer.parseInt(params.get("q12").toString());
        int q13 = Integer.parseInt(params.get("q13").toString());
        int q14 = Integer.parseInt(params.get("q14").toString());
        int q15 = Integer.parseInt(params.get("q15").toString());
        int q16 = Integer.parseInt(params.get("q16").toString());
        int q17 = Integer.parseInt(params.get("q17").toString());
        int q18 = Integer.parseInt(params.get("q18").toString());

        if (userid==null)
        {
            return new NorResponse<Integer>(1,"您未登陆，无法提交内容",0);
        }
        else
        {
            int status = answerService.SetInfAnswer(userid.toString(),q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18);

            if (status==1)
                return new NorResponse<Integer>(1,"完成填写，跳转下一问卷",1);
            else
                return new NorResponse<Integer>(1,"服务器内部错误，答案提交失败",0);
        }
    }

}
