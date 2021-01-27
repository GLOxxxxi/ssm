<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/16
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>批次申请</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">


    <!--时间选择器-->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <!-- 离线 Google 字体: Source Sans Pro -->
    <link href="${pageContext.request.contextPath}/static/adminlte/dist/css/google.css?family=Source+Sans+Pro:300,400,400i,700"
          rel="stylesheet">
    <!-- summernote -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- 导航栏 -->
    <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
    <!-- /.navbar -->
    <jsp:include page="/WEB-INF/common/sidebar.jsp"></jsp:include>
    <!-- Content Wrapper. 包含页面内容 -->
    <div class="content-wrapper">
        <!-- 内容标题（页面标题） -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>寒衣添加</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">主页</a></li>
                            <li class="breadcrumb-item active">数据表格</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- 主体内容 -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-7">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-body">
                                    <form class="form-horizontal" id="proAdd" action="${pageContext.request.contextPath}/product/insert" method="post" enctype="multipart/form-data">
                                        <input type="hidden" name="pageNum" value="1">
                                        <input type="hidden" name="pageSize" value="5">
                                        <div class="card-body">
                                            <div class="form-group row">
                                                <label for="batch" class="col-sm-2 col-form-label">&nbsp&nbsp批次</label>
                                                <div class="col-sm-10">
                                                    <select class="form-control" id="batch" name="batchId">

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label  class="col-sm-2 col-form-label"><b
                                                        style="color: #ff0000">*</b>款式</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="name" placeholder="款式">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="inputEmail3" class="col-sm-2 col-form-label"><b
                                                        style="color: #ff0000">*</b>性别</label>
                                                <div class="col-sm-10">
                                                    <div class="form-group">
                                                        <!-- 性别 -->
                                                        <div class="form-group row layui-input-block">
                                                            <div class="layui-unselect layui-form-radio layui-form-radioed"
                                                            <%--<div class="layui-input-block"--%>
                                                                 style=" margin-right: 100px; margin-left: 20px;">
                                                                <input type="radio" id="male" class="active"
                                                                       name="gender" value="M" checked>
                                                                <label for="male">男款</label>
                                                            </div>
                                                            <div class="layui-unselect layui-form-radio">
                                                                <input type="radio" id="famale" name="gender"
                                                                       value="F">
                                                                <label for="famale">女款</label>
                                                            </div>
                                                            <div class="icheck-primary d-inline layui-form-radio"
                                                                 style="margin-left: 100px;">
                                                                <input type="radio" id="both" name="gender"
                                                                       value="MF">
                                                                <label for="both">通用款</label>
                                                            </div>

                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="inputEmail3" class="col-sm-2 col-form-label"><b
                                                        style="color: #ff0000">*</b>编码</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputEmail3" name="productNumber"
                                                           placeholder="编码">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label"><b style="color: #ff0000">*</b>规格</label>
                                                <div class="col-sm-10" id="sku">
                                                </div>
                                                <button id="addSkn" class="btn btn-default" type="button"
                                                        style="margin-left: 150px"> 添加
                                                </button>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label"><b style="color: #ff0000">*</b>款式图片</label>

                                                <div class=" col-sm-10">
                                                    <input type="file" class="form-control"  name="file">
                                                    <input type="file" class="form-control"  name="file">
                                                    <input type="file" class="form-control"  name="file">
                                                </div>
                                                <%--</div>--%>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">尺码表</label>
                                                <div class="col-sm-10">
                                                    <div class="mb-3">
                                                        <textarea class="textarea" placeholder="在这里填写内容" name="description"
                                                                  style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px; display: none;"></textarea>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.card-body -->
                                        <div>
                                            <button type="submit" class="btn btn-info float-right">添加</button>
                                        </div>
                                        <!-- /.card-footer -->
                                    </form>
                                </div>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">

                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- 控制侧边栏内容在这里 -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.min.js"></script>
<!-- 用于演示 AdminLTE  -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
<!--时间选择器-->
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap4 Duallistbox -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<!-- InputMask -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/moment/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/moment/locale/zh-cn.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>
<!-- date-range-picker -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap color picker -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Bootstrap 开关 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<!-- Summernote -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/lang/summernote-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
</body>
<script>
    $(function () {
        // 夏天的随笔
        $('.textarea').summernote({lang : 'zh-CN'})
    })
</script>
</html>
<script>
    //编码添加
    $(function () {
        $("#addSkn").click(function () {
            $("#sku").append($("<p><input type='text' name='skuName' class='col-sm-2'><span>总量：</span><input type='text' name='skuTotal' class='col-sm-1'> <button type='button' class='deleteSku'>删除</button></p> "))
            $(".deleteSku").click(function () {
                $(this).parent().remove();
            })
        })

        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/batch/listByAjax",
            dataType:"json",
            success:function (res) {
                $(res.data).each(function (i,index) {
                    $("#batch").append($("<option value='"+index.id+"'>"+index.name+"</option>"))
                })
            }
        })

    })
</script>
<%--<script>--%>
    <%--layui.use('upload', function() {--%>
        <%--var $ = layui.jquery--%>
            <%--, upload = layui.upload;--%>

        <%--//多图片上传--%>
        <%--upload.render({--%>
            <%--elem: '#test2'--%>
            <%--,url: 'https://httpbin.org/post' //改成您自己的上传接口--%>
            <%--,data:$("#proAdd").serialize()--%>
            <%--,multiple: true--%>
            <%--,before: function(obj){--%>
                <%--//预读本地文件示例，不支持ie8--%>
                <%--obj.preview(function(index, file, result){--%>
                    <%--if(index.valueOf()>3){--%>
                        <%--console.log("fg")--%>
                        <%--layer.msg("至多三张照片",{title:'提示'})--%>
                    <%--}--%>
                    <%--$('#demo2').append('<img  src="'+ result +'" style="height:150;px;width:auto" alt="'+ file.name +'" class="layui-upload-img">')--%>
                <%--});--%>
            <%--}--%>
            <%--,done: function(res){--%>
                <%--//上传完毕--%>
            <%--}--%>
        <%--});--%>
    <%--})--%>

<%--</script>--%>