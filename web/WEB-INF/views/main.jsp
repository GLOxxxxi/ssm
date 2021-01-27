<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/16
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>主页</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bbootstrap 4 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/jqvmap/jqvmap.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.css">
    <!-- 离线 Google 字体: Source Sans Pro -->
    <link href="${pageContext.request.contextPath}/static/adminlte/dist/css/google.css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <!-- 导航栏-->
    <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
    <!-- /.navbar -->
    <jsp:include page="/WEB-INF/common/sidebar.jsp"></jsp:include>
    <!-- 主侧边栏容器 -->
    <div class="content-wrapper">
    <div class="container-fluid">

        <!-- Timelime example  -->
        <div class="row">
            <div class="col-md-12 col-sm-6">
                <!-- The time line -->
                <div class="timeline" >
                    <!-- timeline item -->
                    <div class="col-1 col-sm-2 col-md-2">
                        <i class="fas fa-check bg-green"></i>
                        <div class="timeline-item" style="margin-left: 50px">
                            <h4 style="color: #a7dd9f"style="height: 20px;margin-right: 20px">学院审核:已通过</h4>
                        </div>

                    </div>
                    <div class="col-1 col-sm-2 col-md-2">
                        <i class="fas fa-times bg-red"></i>
                        <div class="timeline-item" style="margin-left: 50px">
                            <h4 style="color: #a7dd9f"style="height: 20px;margin-right: 20px">学院审核:待审核</h4>
                        </div>
                    </div>
                    <div class="col-2 col-sm-2 col-md-2">
                        <i class="fas fa-2x fa-sync-alt fa-spin"></i>
                        <div class="timeline-item" style="margin-left: 50px">
                            <b style="color: #a7dd9f"style="height: 20px;margin-right: 20px">学院审核:待审核</b>
                        </div>
                    </div>
                    <div class="col-1 col-sm-2 col-md-1">
                        <i class="fas fa-clock bg-gray"></i>
                    </div>
                </div>
            </div>
            <!-- /.col -->
        </div>

            <!-- /.col -->
        </div>


    </div>

    <!-- Content Wrapper. 包含页面内容 -->
    <!-- /.content-wrapper -->


    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- 控制侧边栏内容在这里 -->
    </aside>
    <!-- /.control-sidebar -->
</div>
</div>
<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- 解决使用 Bootstrap 提示工具与 jQuery UI 提示工具冲突 -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/moment/moment.min.js"></script><script src="${pageContext.request.contextPath}/static/adminlte/plugins/moment/locale/zh-cn.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.js"></script>
<!-- AdminLTE 仪表盘演示（仅用于演示） -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/pages/dashboard.js"></script>
<!-- 用于演示 AdminLTE  -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
</body>
</html>
