<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/16
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 3 | 登录</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <!-- 离线 Google 字体: Source Sans Pro -->
    <link href="${pageContext.request.contextPath}/static/adminlte/dist/css/google.css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="${pageContext.request.contextPath}/static/adminlte/index2.html"><b>Admin</b>LTE</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">帐户登录</p>

            <form action="${pageContext.request.contextPath}/user/login" method="get">
                <div class="input-group mb-3">
                    <input id="sn" name="sn" class="form-control" placeholder="学号或工号" value="0121401100336">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>

                </div>
                <div><span  style="color: #ff0000;font-size: xx-small;display: none" id="msg">请输入学号或者工号</span></div>

                <div class="input-group mb-3">
                    <input type="password" class="form-control" placeholder="密码">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="remember">
                            <label for="remember">
                                记住我
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" id="login" class="btn btn-primary btn-block">登录</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.min.js"></script>

</body>
<script>
    $(function () {
        var sn=$("#sn").val()
        $("#login").click(function () {
            if(sn == ""||sn == null){
                document.getElementById("msg").style="color: #ff0000;font-size: xx-small";
            }else{
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/user/login"
                })
            }
        })
    })
</script>
</html>

