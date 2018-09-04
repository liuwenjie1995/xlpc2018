<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>大学生心理普查  问卷（1）</title>
    <link rel="stylesheet"  type="text/css"  href="/showassert/css/bootstrap.css"/>
    <script type="text/javascript" src="/jQuery/jquery-3.2.1.min.js"></script>


</head>
<body>
<div >
    <div class="container; ">
        <form >
            <label class="col-sm-8 col-sm-offset-3" style="margin-top:200px;font-size:20px">
                (<b id="qid"></b>/104)<b id="qcontent"></b></label>
            <label class="radio-inline col-sm-1 col-sm-offset-3" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio1" value="1"> 没有
            </label>
            <label class="radio-inline col-sm-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio2" value="2"> 偶尔
            </label>
            <label class="radio-inline col-sm-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio3" value="3"> 有时
            </label>
            <label class="radio-inline col-sm-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio4" value="4"> 经常
            </label>
            <label class="radio-inline col-sm-1" style="margin-top:50px;">
                <input type="radio" name="markdown" id="radio5" value="5"> 总是
            </label>

        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(
        function () {
            if(${Request["qid"]}!=null)
            {
                var text1 = "${Request["qid"]}"+"";
                $("#qid").text(text1);
                var text2 = "${Request["qcontent"]}"+"";
                $("#qcontent").text(text2);
            }

        }
    );

    $(document).ready(function(){
        $("input").click(function(){
            var qid = ${Request["qid"]};
            var answer = $('input:radio[name="markdown"]:checked').val();
            $.ajax(
                    {
                        type:"post",
                        url:"action/question2",
                        dataType:"json",
                        data:
                                {
                                    qid : qid,
                                    mark :answer
                                },
                        success:function (data) {
                            var text1 = "${Request["qid"]}"+"";
                            $("#id").text(text1);
                            var text2 = "${Request["qcontent"]}"+"";
                            $("#qcontent").text(text2);
                        }

                    }
            )
        });
    });
</script>
</html>