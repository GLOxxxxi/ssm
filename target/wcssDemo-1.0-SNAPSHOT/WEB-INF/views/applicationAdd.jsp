<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>提交申请</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <!-- summernote -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <!-- 离线 Google 字体: Source Sans Pro -->

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <jsp:include page="/WEB-INF/common/header.jsp"/>
    <jsp:include page="/WEB-INF/common/sidebar.jsp"/>

    <!-- Content Wrapper. 包含页面内容 -->
    <div class="content-wrapper">
        <!-- 内容标题（页面标题） -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>通用表单</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">主页</a></li>
                            <li class="breadcrumb-item active">通用表单</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- 主体内容 -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-6">
                        <!-- 竖排表单 -->
                        <div class="card card-info">
                            <!-- /.card-header -->
                            <div class="form-group row">
                                <div class="col-sm-10">
                                    <label class="col-sm-8 col-form-label">补助开放年级：</label>

                                        <label class="col-sm-4 col-form-label" id="grades" readonly></label>

                                </div>
                            </div>
                            <!-- form start -->
                            <form id="appForm" class="form-horizontal">
                                <div class="card-body">
                                    <textarea name="applicationReason" rows="10" style="width: 100%"></textarea>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="button" id="saveApp" class="btn btn-success float-right">保存</button>
                                </div>
                                <!-- /.card-footer -->
                            </form>
                        </div>
                        <!-- /.card -->

                    </div>
                    <!--/.col (left) -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>



        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="/WEB-INF/common/footer.jsp"/>
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
<!-- bs-custom-file-input -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.min.js"></script>
<!-- 用于演示 AdminLTE  -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
<!-- Summernote -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/lang/summernote-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.textarea').summernote({lang: 'zh-CN'})
        bsCustomFileInput.init();
    });
</script>
</body>
</html>
<script>
    $(function () {
        var gradess=[]
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/grade/selectAllGradeBySn",
            dataType:"json",
            success:function (ress) {
                console.log(ress.data)
                $(ress.data).each(function (i, index) {
                    gradess.push(index.gradeName)
                })
                $("#grades").text(gradess)
            }
        })

        $("#saveApp").click(function () {
            var sn = "${loginUser.sn}"
            console.log(sn)
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/grade/selectGradeBySn?sn="+sn,
                dataType:"json",
                success:function (result) {
                    var grades=[]
                    $.ajax({
                        type:"get",
                        url:"${pageContext.request.contextPath}/grade/selectAllGradeBySn",
                        dataType:"json",
                        success:function (ress) {
                            console.log(ress.data)
                            $(ress.data).each(function (i, index) {
                                grades.push(index.gradeName)
                            })
                            console.log(grades);
                            var count = 0;
                            for(var i=0;i<grades.length;i++){
                                if(grades[i]===result.data){
                                    console.log("行")
                                    count++
                                    console.log(count)
                                    break;
                                }
                                else {
                                    console.log("不行")

                                }
                            }
                            if(count>0){
                                $.ajax({
                                    type: "post",
                                    url: "${pageContext.request.contextPath}/application/insert",
                                    data: $("#appForm").serialize(),
                                    dataType: "json",
                                    success: function (res) {
                                        if(res.data){
                                            //如果存在申请
                                            layer.msg("该用户在当前批次已存在申请,无法提交")
                                        }else{
                                            layer.msg("提交成功",{icon:1,time:2000},function () {
                                                window.location = "${pageContext.request.contextPath}/application/listBySn"
                                            })
                                        }
                                    }
                                })
                            }
                            else{
                                layer.msg("您当前年级不符合该批次要求",{title:'提示',time:2000})
                            }
                        }
                    })


                }
            })

        })
    })
</script>
