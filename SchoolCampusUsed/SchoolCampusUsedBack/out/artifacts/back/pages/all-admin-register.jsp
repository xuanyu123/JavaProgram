<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>山西农业大学校园二手系统 - 管理员注册</title>


    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
    <style>
        .register-my-body{
            height: 100px;
            background: url("https://i.loli.net/2019/12/10/lxwjBNcptaRQrv1.jpg");
            background-size: cover;
        }
    </style>
</head>

<body class="hold-transition register-page register-my-body">
    <%
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            response.sendRedirect("./admin.jsp?index=0");
        }
    %>

    <div class="register-box">
        <div class="register-logo">
            <b style="color: ghostwhite;">校园二手交易后台管理注册</b>
        </div>

        <div class="register-box-body">
            <p class="login-box-msg">用户注册</p>

            <form action="${pageContext.request.contextPath}/rigisterServlet" method="post" onsubmit="return formCheck()">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="昵称" name="name" id="name">
                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="email" class="form-control" placeholder="Email" name="email" id="email">
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="用户名" name="username" id="usernameInput">
                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" placeholder="密码" name="password" id="password">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-3">

                    </div>
                    <!-- /.col -->
                    <div class="col-xs-6">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>
            <div style="text-align: center;">
                <p style="color: red">
                    ${msg}
                </p>
            </div>
            <div style="text-align: center;">
                <a href="all-admin-login.jsp" class="text-center">我有账号，现在就去登录</a>
            </div>
        </div>
        <!-- /.form-box -->
    </div>
    <!-- /.register-box -->

    <!-- jQuery 2.2.3 -->
    <!-- Bootstrap 3.3.6 -->
    <!-- iCheck -->
    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../plugins/iCheck/icheck.min.js"></script>
    <script>
        $(function() {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
        });

        let checkUsername = false;
        $("#usernameInput").keypress(function () {
            let pattern = /^[A-Za-z]+$/;
            if(pattern.test($("#usernameInput").val())){
                $("#usernameInput").removeClass("text-red").addClass("text-black");
                checkUsername = true;
            }else{
                $("#usernameInput").removeClass("text-black").addClass("text-red");
                checkUsername = false;
            }
        });

        function formCheck() {
            if(checkUsername){
                if($("#password").val() === "" || $("#name").val() === "" || $("#email").val() === ""){
                    return false;
                }
                return true;
            }else{
                return false;
            }
        }
    </script>
</body>
</html>