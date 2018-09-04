<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
该网页用于登记学生的个人信息包含以下内容：
本科生：

1.姓名
2.电子邮件
3.男女
4.是否复读
5.手机号
6.是否是独生子女
7.是否第一志愿入学
8.是否想转换专业
9.有无留守经历或儿童期与父母长期分离经历
10.是否是单亲家庭
11，是否有复读经历
12.小学时期是否换过班主任
13.是否有过转学经历

 -->
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>输入个人信息</title>
    <link rel="stylesheet"  type="text/css"  href="/showassert/css/bootstrap.css"/>
    <script type="text/javascript" src="/jQuery/jquery-3.2.1.min.js"></script>
</head>

<body style="text-align:center;">
<h2><strong>填写相关学生信息</strong></h2>
<div class="container" id="Inf_form"  style="width:70%;">
    <form class="form-horizontal"  style="margin:20px; padding-bottom:10px;" >
        <div class="form-group">
            <label class="col-sm-4 control-label">姓名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control"  name="q1" placeholder="姓名">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">手机</label>
            <div class="col-sm-6">
                <input type="text" class="form-control"  name="q2">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">性别</label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q3" id="boy"  value="1"> 男
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q3" id="girl" value="0"> 女
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">总体来说，大学学习、生活是否符合你期待</label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q4"  value="1"> 是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q4"  value="0"> 否
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">你想说明的个人情况（限于20  字以内）</label>
            <div class="col-sm-6">
                <input type="text" class="form-control"  name="q5" id="q5">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">学校是否第一志愿</label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q6"  value="1"> 是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q6"  value="0"> 否
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">所学专业是否是第一志愿</label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q7"  value="1"> 是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q7"  value="0"> 否
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">对所学专业是否满意</label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q8"  value="1"> 是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q8"  value="0"> 否
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">是否有换专业的想法</label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q9"  value="1">有
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q9"  value="0">无
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">高中是否复读过 </label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q10"  value="1">是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q10"  value="0">否
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">中小学是否有过转学经历 </label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q11"  value="1">是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q11"  value="0">否
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">小学时期是否换过班主任 </label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q12"  value="1">是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q12"  value="0">否
                </label>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">是否是独生子女</label>
            <div class="col-sm-8">
                <label class="radio-inline col-sm-4">
                    <input type="radio" name="q13"  value="1">是
                </label>
                <label class="radio-inline col-sm-1">
                    <input type="radio" name="q13"  value="0">否
                </label>
            </div>
        </div>


        <div id="yanform" >
            <div class=" col-sm-12 " style="text-align:left;">
                <h3 style="font-color:blue"></h3>

            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">是否是单亲家庭</label>
                <div class="col-sm-8">
                    <label class="radio-inline col-sm-4">
                        <input type="radio" name="q14"  value="1">是
                    </label>
                    <label class="radio-inline col-sm-1">
                        <input type="radio" name="q14"  value="0">否
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label">是否是重组家庭</label>
                <div class="col-sm-8">
                    <label class="radio-inline col-sm-4">
                        <input type="radio" name="q15"  value="1">是
                    </label>
                    <label class="radio-inline col-sm-1">
                        <input type="radio" name="q15"  value="0">否
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label">有无留守经历或儿童期与父母长期分离经历</label>
                <div class="col-sm-8">
                    <label class="radio-inline col-sm-4">
                        <input type="radio" name="q16"  value="1">是
                    </label>
                    <label class="radio-inline col-sm-1">
                        <input type="radio" name="q16"  value="0">否
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label">是否在多子女（三个或以上）家庭</label>
                <div class="col-sm-8">
                    <label class="radio-inline col-sm-4">
                        <input type="radio" name="q17"  value="1">是
                    </label>
                    <label class="radio-inline col-sm-1">
                        <input type="radio" name="q17"  value="0">否
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label">是否有出国留学打算 </label>
                <div class="col-sm-8">
                    <label class="radio-inline col-sm-4">
                        <input type="radio" name="q18"  value="1">是
                    </label>
                    <label class="radio-inline col-sm-1">
                        <input type="radio" name="q18"  value="0">否
                    </label>
                </div>
            </div>
        </div>
    </form>

    <input id="postbutton" type="submit" class="btn btn-info" text="提交" style="margin-bottom: 20px">
</div>
</body>

<!--  这里添加JavaScript代码
	  在网页中添加判断，若某个信息未填写会变成红色，并且不能提交
 -->
<script type="text/javascript">
                $("#postbutton").click(
                        function()
                        {
                            var sum=0;
                            $("input[type=text]").each(
                                    function()
                                    {
                                        var text = $(this).val();
                                        if(text=="")
                                        {
                                            $(this).addClass("alert-danger");
                                            flag=1;
                                        }
                                        else
                                        {
                                            $(this).removeClass("alert-danger");
                                            sum=sum+1;
                                        }
                                    }

                            );

                            var list3= $('input:radio[name="q3"]:checked').val();
                            if(list3!=null)
                                sum=sum+1;
                            var list4= $('input:radio[name="q4"]:checked').val();
                            if(list4!=null)
                                sum=sum+1;
                            var list6= $('input:radio[name="q6"]:checked').val();
                            if(list6!=null)
                                sum=sum+1;
                            var list7= $('input:radio[name="q7"]:checked').val();
                            if(list7!=null)
                                sum=sum+1;
                            var list8= $('input:radio[name="q8"]:checked').val();
                            if(list8!=null)
                                sum=sum+1;
                            var list9= $('input:radio[name="q9"]:checked').val();
                            if(list9!=null)
                                sum=sum+1;
                            var list10= $('input:radio[name="q10"]:checked').val();
                            if(list10!=null)
                                sum=sum+1;
                            var list11= $('input:radio[name="q11"]:checked').val();
                            if(list11!=null)
                                sum=sum+1;
                            var list12= $('input:radio[name="q12"]:checked').val();
                            if(list12!=null)
                                sum=sum+1;
                            var list13= $('input:radio[name="q13"]:checked').val();
                            if(list13!=null)
                                sum=sum+1;
                            var list14= $('input:radio[name="q14"]:checked').val();
                            if(list14!=null)
                                sum=sum+1;
                            var list15= $('input:radio[name="q15"]:checked').val();
                            if(list15!=null)
                                sum=sum+1;
                            var list16= $('input:radio[name="q16"]:checked').val();
                            if(list16!=null)
                                sum=sum+1;
                            var list17= $('input:radio[name="q17"]:checked').val();
                            if(list17!=null)
                                sum=sum+1;
                            var list18= $('input:radio[name="q18"]:checked').val();
                            if(list18!=null)
                                sum=sum+1;


                                if(sum===18)
                                {
                                    $.ajax({
                                        type:"post",
                                        url:"action/question1",
                                        dataType:"json",
                                        data:
                                                {
                                                    q1:$("input[name='q1']").val(),
                                                    q2:$("input[name='q2']").val(),
                                                    q3:list3,
                                                    q4:list4,
                                                    q5:$("input[name='q5']").val(),
                                                    q6:list6,
                                                    q7:list7,
                                                    q8:list8,
                                                    q9:list9,
                                                    q10:list10,
                                                    q11:list11,
                                                    q12:list12,
                                                    q13:list13,
                                                    q14:list14,
                                                    q15:list15,
                                                    q16:list16,
                                                    q17:list17,
                                                    q18:list18
                                                },
                                        success:function (data) {
                                            if (1===data["data"])
                                            {
                                                window.location.replace("/question2guide");
                                            }
                                            else
                                            {
                                                alert(data["message"]);
                                            }
                                            },
                                        error:function () {

                                            alert("upload fail");
                                            alert("与服务器失去连接，未能上传答案")
                                        }
                                        })
                                }
                                else
                                {
                                    alert("未填完18道题");
                                }
                            });

</script>

</html>