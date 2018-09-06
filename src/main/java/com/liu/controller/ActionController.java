package com.liu.controller;

import com.liu.beans.*;
import com.liu.dao.*;
import com.liu.model.LoginStatus;
import com.liu.model.NorResponse;
import com.liu.model.Q2Status;
import com.liu.model.Q4status;
import com.liu.service.AnswerService;
import com.liu.service.UserService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/action")
public class ActionController {
    final
    UserService userService;
    final
    AnswerService answerService;
    final
    A2Dao a2Dao;
    final
    Q2Dao q2Dao;
    final
    A4Dao a4Dao;
    final
    Q4Dao q4Dao;
    final
    InfDao infDao;
    final
    StudentDao studentDao;
    final
    QinfDao qinfDao;
    final
    UserDao userDao;

    @Autowired
    public ActionController(UserService userService, AnswerService answerService, A2Dao a2Dao, Q2Dao q2Dao, A4Dao a4Dao, Q4Dao q4Dao, InfDao infDao, StudentDao studentDao, QinfDao qinfDao, UserDao userDao) {
        this.userService = userService;
        this.answerService = answerService;
        this.a2Dao = a2Dao;
        this.q2Dao = q2Dao;
        this.a4Dao = a4Dao;
        this.q4Dao = q4Dao;
        this.infDao = infDao;
        this.studentDao = studentDao;
        this.qinfDao = qinfDao;
        this.userDao = userDao;
    }

    @RequestMapping("/login")
    NorResponse userlogin(@RequestParam Map<String,Object> param, HttpSession session){

        String userid = (String)param.get("userid");
        String password = (String)param.get("password");

        if (userid!=null&&password!=null)
        {
            if (userid.equals("manager")&&password.equals("manager"))
            {
                session.setAttribute("userid","manager");
                return new NorResponse<LoginStatus>(1,"管理员界面",new LoginStatus(6));
            }
        }

        User user = userService.getuser(userid,password);

        if (user!=null)
        {
            int page = 1;
            session.setAttribute("userid",userid);
            session.setAttribute("rank",user.getRank());

            List<AInf> aInfList = infDao.findByUserid(userid);
            List<A2> a2List = a2Dao.findById_Userid(userid);
            List<A4> a4List = a4Dao.findById_Userid(userid);
            if (!aInfList.isEmpty())
                page=2;
            if (a2List.size()>=104)
                page=4;
            if (a4List.size()>=68)
                page=5;

            return new NorResponse<>(1,"login success",new LoginStatus(page));
        }
        else{
            return new NorResponse<>(1,"用户名或密码错误",new LoginStatus(0));
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

    @RequestMapping("/question2start")
    NorResponse question2start(HttpSession session)
    {
        String userid = session.getAttribute("userid").toString();
        if (userid==null)
        {
            return new NorResponse<Integer>(0,"未登陆返回登陆界面",0);
        }
        else
        {
            List<A2> a2List = a2Dao.findById_Userid(userid);
            int sum = a2List.size();
            if(sum>=104)
            {
                return new NorResponse<Integer>(2,"已完成填写，跳转心理介绍界面",0);
            }
            else
            {
                List<Q2> q2List = q2Dao.findAllByQid(sum+1);
                Q2 q2 = q2List.get(0);
                Q2Status q2status = new Q2Status(q2.getQid(),q2.getQcontent());
                return new NorResponse<Q2Status>(1,"返回问题",q2status);
            }
        }
    }

    @RequestMapping("/question2")
    NorResponse question2(@RequestParam Map<String,Object> params,HttpServletRequest request,HttpSession session)
    {
        String userid = session.getAttribute("userid").toString();
        String qid = params.get("qid").toString();
        int mark = Integer.parseInt(params.get("mark").toString());
        A2 a2 = new A2(userid,qid,mark);
        a2Dao.save(a2);

        Q2 q2 = answerService.getnextQ2(qid);

        if (q2==null)
        {
            return new  NorResponse<Integer>(2,"返回成功",1);
        }

        return new NorResponse<Q2Status>(1,"返回成功",new Q2Status(q2.getQid(),q2.getQcontent()));
    }
    @RequestMapping("/question4start")
    NorResponse question4start(HttpSession session)
    {
        String userid = session.getAttribute("userid").toString();
        if (userid==null)
        {
            return new NorResponse<Integer>(0,"未登陆返回登陆界面",0);
        }
        else
        {
            List<A4> a4List = a4Dao.findById_Userid(userid);
            int sum = a4List.size();
            if(sum>=68)
            {
                return new NorResponse<Integer>(2,"已完成填写，跳转心理介绍界面",0);
            }
            else
            {
                List<Q4> q4List = q4Dao.findByQID(sum+1);
                Q4 q4 = q4List.get(0);
                Q4status q4status = new Q4status(q4.getqID(),q4.getqContent());
                return new NorResponse<Q4status>(1,"返回问题",q4status);
            }
        }
    }
    @RequestMapping("/question4")
    NorResponse question4(@RequestParam Map<String ,Object> param,HttpSession session)
    {
        String qid = param.get("qid").toString();
        String answer = param.get("answer").toString();
        String userid = session.getAttribute("userid").toString();
        if (userid==null)
        {
            return new NorResponse<Integer>(0,"未登陆，返回登陆界面",0);
        }
        else
        {
            Userqid userqid = new Userqid(userid,qid);
            A4 a4 = new A4(userqid,Integer.parseInt(answer));
            a4Dao.save(a4);
            List<Q4> q4List = q4Dao.findByQID(Integer.valueOf(qid)+1);
            if (q4List.isEmpty())
            {
                return new NorResponse<Integer>(2,"本页面已经回答完成",1);
            }
            else
            {
                Q4 q4 = q4List.get(0);
                Q4status q4status = new Q4status(q4.getqID(),q4.getqContent());
                return new NorResponse<Q4status>(1,"下一问题",q4status);
            }
        }
    }

    @RequestMapping("/downloadfinisher")
    Boolean downloadfinisher(HttpServletResponse response)
    {
        StringBuffer buf = new StringBuffer();
        String[] colNamesArr = {};
        Iterator<Qinf> qinfs = qinfDao.findAll().iterator();
        Iterator<Q2> q2Iterator = q2Dao.findAll().iterator();
        Iterator<Q4> q4Iterator = q4Dao.findAll().iterator();

        List<String> finisherlist = a4Dao.findfinisher();
        List<List<String>> answerlist = new ArrayList<>();

        for (String userid:finisherlist)
        {
            List<String> useranswerlist = new ArrayList<>();
            List<String> aInflist = infDao.findByUserid(userid).get(0).toList();
            List<A2> a2answerlist = a2Dao.findById_Userid(userid);
            List<A4> a4answerlist = a4Dao.findById_Userid(userid);
                System.out.print(aInflist);
                for (String item:aInflist)
                {
                    if (item.trim().equals(""))
                    {
                        useranswerlist.add("null");
                    }
                    else
                    {
                        useranswerlist.add(item);
                    }
                }
            for (A2 a2:a2answerlist)
            {
                useranswerlist.add(String.valueOf(a2.getMark()));
            }
            for (A4 a4:a4answerlist)
            {
                useranswerlist.add(String.valueOf(a4.getMark()));
            }
            answerlist.add(useranswerlist);
        }

        buf.append("用户id").append(CSV_COLUMN_SEPARATOR);
        while (qinfs.hasNext())
        {
            buf.append(qinfs.next().getQuestion()).append(CSV_COLUMN_SEPARATOR);
        }
        while (q2Iterator.hasNext())
        {
            Q2 it2 = q2Iterator.next();
            buf.append(it2.getQid()+it2.getQcontent()).append(CSV_COLUMN_SEPARATOR);
        }
        while (q4Iterator.hasNext())
        {   Q4 it4 = q4Iterator.next();
            buf.append(it4.getqID()+it4.getqContent()).append(CSV_COLUMN_SEPARATOR);
        }

        buf.append(CSV_RN);

        for (List<String> itemlist:answerlist)
        {
            for (String item:itemlist)
            {
                buf.append(item).append(CSV_COLUMN_SEPARATOR);
            }
            buf.append(CSV_RN);
        }

        try{
            OutputStream os = response.getOutputStream();
            responseSetProperties("finisher",response);
            os.write(buf.toString().getBytes("GBK"));
            os.flush();
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public static void responseSetProperties(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        // 设置文件后缀
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fn = fileName + sdf.format(new Date()) + ".csv";
        // 读取字符编码
        String utf = "UTF-8";

        // 设置响应
        response.setContentType("application/ms-txt.numberformat:@");
        response.setCharacterEncoding(utf);
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control", "max-age=30");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fn, utf));
    }

    private static final String CSV_COLUMN_SEPARATOR = ",";
    /** CSV文件列分隔符 */
    private static final String CSV_RN = "\r\n";
    @RequestMapping("/nofinisher")
    Boolean downloadnofinisher(HttpServletResponse response)
    {
        StringBuffer buf = new StringBuffer();
        String[] colNamesArr = {"学号","班级","姓名","出生日期","性别","学院","录取专业"};
        List<Student> studentList = studentDao.findNotfinisher();

        for (String title:colNamesArr)
        {
            buf.append(title).append(CSV_COLUMN_SEPARATOR);
        }
        buf.append(CSV_RN);
        for (Student student:studentList)
        {
            buf.append(student.getUserid()).append(CSV_COLUMN_SEPARATOR);
            buf.append(student.getClazz()).append(CSV_COLUMN_SEPARATOR);
            buf.append(student.getUsername()).append(CSV_COLUMN_SEPARATOR);
            buf.append(student.getBrith()).append(CSV_COLUMN_SEPARATOR);
            buf.append(student.getSex()).append(CSV_COLUMN_SEPARATOR);
            buf.append(student.getAcademy()).append(CSV_COLUMN_SEPARATOR);
            buf.append(student.getMajor()).append(CSV_COLUMN_SEPARATOR);
            buf.append(CSV_RN);
        }

        try{
            OutputStream os = response.getOutputStream();
            responseSetProperties("nofinisher",response);
            os.write(buf.toString().getBytes("GBK"));
            os.flush();
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
