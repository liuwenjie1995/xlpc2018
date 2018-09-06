<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>大学生心理普查  问卷（1）</title>
    <link rel="stylesheet"  type="text/css"  href="showassert/css/bootstrap.css"/>
    <script type="text/javascript" src="jQuery/jquery-3.2.1.min.js"></script>


</head>
<body>
<div >
    <div class="container; ">
        <form >
            <label class="col-sm-12  col-md-8  col-md-offset-3" style="margin-top:200px;font-size:20px">
                (<b id="qid"></b>/104)<b id="qcontent"></b></label>
            <label class="radio-inline col-sm-12 col-md-1 col-md-offset-3" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio1" value="1"> 没有
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio2" value="2"> 偶尔
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio3" value="3"> 有时
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio4" value="4"> 经常
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio5" value="5"> 总是
            </label>

        </form>
    </div>
</div>
</body>
<script type="text/javascript">

    $(document).ready(
            function () {
                var user = "${Session["userid"]}"+"";
                if(user==="manager")
                {
                    window.location.replace("/login");
                }
            }
    );
    function isMobile() {
        var userAgentInfo = navigator.userAgent;

        var mobileAgents = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];

        var mobile_flag = false;

        //根据userAgent判断是否是手机
        for (var v = 0; v < mobileAgents.length; v++) {
            if (userAgentInfo.indexOf(mobileAgents[v]) > 0) {
                mobile_flag = true;
                break;
            }
        }
        return mobile_flag;
    }

    $(document).ready(
            function(){

                var mobile_flag = isMobile(); // true为PC端，false为手机端

                if(mobile_flag){
                    $("body").css("font-size","50px" );
                    $("label").css("font-size","50px" );
                }
            }


    );
    $(document).ready(
        function () {
            $.ajax({
                type:"post",
                url:"/action/question2start",
                dataType:"json",
                success:function (data) {
                    if (data["code"]===2)
                    {
                        window.location.replace("/question4guide");
                    }
                    else if (data["code"]===0)
                    {
                        window.location.replace("/login");
                    }
                    else
                    {
                        var qid = data["data"]["qid"];
                        var qcontent = data["data"]["qcontent"];

                        $("#qid").text(qid+"");
                        $("#qcontent").text(qcontent+"");
                    }
                }
            })
        }
    );

    $(document).ready(function(){
        $("input").click(function(){
            var qid = $("#qid").text();
            var qcontent = $("#qcontent").text();
            var answer = $('input:radio[name="markdown"]:checked').val();
            $.ajax(
                    {
                        type:"post",
                        url:"/action/question2",
                        dataType:"json",
                        data:
                                {
                                    qid : qid,
                                    mark :answer
                                },
                        success:function (data) {
                            if (data["code"]===2)
                            {window.location.replace("/question4guide")}
                            else if (data["code"]===1)
                            {
                                $('input:radio[name="markdown"]:checked').prop("checked",false);
                                var text1 = data["data"]["qid"]+"";
                                $("#qid").text(text1);
                                var text2 = data["data"]["qcontent"]+"";
                                $("#qcontent").text(text2);
                            }

                        }

                    }
            )
        });
    });
</script>
</html>