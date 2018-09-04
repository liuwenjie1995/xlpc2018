<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>大学生心理健康问卷调查系统</title>
    <script src="/loginassert/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="/loginassert/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- for-mobile-apps -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--Google Fonts-->
</head>
<body>
<!--header start here-->
<div class="header">
    <div class="header-main">
        <h1>心理普查系统</h1>
        <div class="header-bottom">
            <div class="header-right w3agile">
                <div class="header-left-bottom agileinfo" style="padding-top: 20dp">
                       <div style="padding-left: 30px">
                           <input id="userid" type="text"  value="用户名" name="userid" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}"/>
                           <input id="password" type="password"  value="    " name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}"/>

                       </div>
                        <div class="remember">

                            <div class="forgot">
                                <h6><a href="/forget">忘记密码?</a></h6>
                            </div>
                            <div class="clear"> </div>
                        </div>

                        <input id="upload" type="submit" value="登录" >
                    <div class="header-left-top">

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<!--header end here-->
<div class="copyright">
    <p>© 2017 北京化工大学心理调查系统. All rights reserved | Design by  <a href="http://www.buct.edu.cn" target="_blank">  BUCT </a></p>
</div>
<!--footer end here-->
<script type="text/javascript">
    $("#upload").click(
        function () {
            var u = $.trim($("#userid").val());
            var p = $.trim($("#password").val());

            if (u==="")
            {
                alert("未填写用户名");
            }
            else if (p==="")
            {
                alert("未填写密码");
            }
            else
            {
                $.ajax(
                        {
                            type:"post",
                            url:"/action/login",
                            dataType:"json",
                            data:
                                    {
                                        userid:u,
                                        password:p
                                    },
                            success:function (data) {
                                if (1===data["data"]["status"])
                                {
                                    window.location.replace("/question1");
                                }
                                else
                                {
                                    alert(data["message"]);
                                }

                            }
                        }
                )
            }
        }
    )

</script>
</body>
</html>