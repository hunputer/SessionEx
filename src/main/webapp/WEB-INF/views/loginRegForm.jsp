<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title>
</head>
<body>
아이디 : <textarea id="id"></textarea>
비번 : <textarea id="passwd"></textarea>
<button id="login">로그인</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
    $("#login").click(function(){
        let id = $("#id").val();
        let passwd = $("#passwd").val();

        $.ajax({
            type: "post",
            url: "/login",
            dataType: "json",
            data:JSON.stringify({"id":id,"passwd":passwd}),
            contentType : "application/json; charset=utf-8",
            error: function() {
                console.log('통신실패!!');
            },
            success: function(data) {
                let code = data.code;

                if(code == 200){
                    location.href = "/"
                }else{
                    alert("계정 정보가 다릅니다");
                }
            }
        });
    });
</script>
</body>
</html>