<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>大学生心理普查  问卷（2）</title>
    <link rel="stylesheet"  type="text/css"  href="showassert/css/bootstrap.css"/>

</head>
<body>
<div >
    <div class="container; ">
        <form>
            <label class="col-sm-12 col-md-8 col-md-offset-3" style="margin-top:200px;font-size:20px">(<b id="qid"></b>/68)<b id="qcontent"></b></label>
            <label class="radio-inline col-sm-12 col-md-1 col-md-offset-3" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio1" value="1">非常不符合
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio2" value="2">比较不符合
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio3" value="3"> 难以确定
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio4" value="4"> 比较符合
            </label>
            <label class="radio-inline col-sm-12 col-md-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio5" value="5">非常符合
            </label>

        </form>
    </div>
</div>

<script type="text/javascript" src="/jQuery/jquery-3.2.1.min.js"></script>

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
                    $("body").css("font-size","20px" );
                    $("label").css("font-size","20px" );
                }
            }


    );

    $(document).ready(function(){
        $.ajax(
                {
                    type:"post",
                    url:"/action/question4start",
                    dataType:"json",
                    data:{},
                    success:function (data) {
                        if (data["code"]===2)
                        {
                            window.location.replace("/teacherinf");
                        }
                        var text1 = data["data"]["qid"];
                        var text2 = data["data"]["qcontent"];
                        $("#qid").text(text1+"");
                        $("#qcontent").text(text2+"");
                    }
                }
        );

        $("input").click(function(){
            var qid = $("#qid").text();
            var qcontent = $("#qcontent").text();
            var answer = $('input:radio[name="markdown"]:checked').val();
            $.ajax(
                    {
                        type:"post",
                        url:"/action/question4",
                        dataType:"json",
                        data:
                                {
                                    qid:qid,
                                    answer:answer
                                },
                        success:function (data) {
                            if (data["code"]===2)
                            {
                                window.location.replace("/teacherinf");
                            }
                            else
                            {
                                $('input:radio[name="markdown"]:checked').prop("checked",false);
                                var qid = data["data"]["qid"];
                                var qcontent = data["data"]["qcontent"];
                                $("#qid").text(qid+"");
                                $("#qcontent").text(qcontent+"");
                            }
                        }
                    }
            )
        });
    });
</script>
</body>
</html>