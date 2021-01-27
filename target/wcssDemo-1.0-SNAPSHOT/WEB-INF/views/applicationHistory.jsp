<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/16
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>申请历史</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- daterange picker -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">

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
                        <h1>数据表格</h1>
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
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <a href="${pageContext.request.contextPath}/application/export" class="btn btn-success">导出</a>
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>所属批次</th>
                                        <th>姓名</th>
                                        <th>申请困难等级</th>
                                        <th>申请理由</th>
                                        <th>审核意见</th>
                                        <th>审核状态</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="app">
                                        <tr>
                                            <td>${app.batch.name}</td>
                                            <td>${app.name}</td>
                                                <%--<td><fmt:formatDate value="${batch.applicationStartDate}" type="date"/></td>--%>
                                            <td>${app.difValue}</td>
                                            <td>${app.applicationReason}</td>
                                            <td>${app.auditComment}</td>
                                            <td>${app.statusValue}<button class="btn-sm btn-default details" id="${app.id}" style="float: right">详情</button></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div id="demo1"></div>
                            </div>
                            <!-- /.card-body -->
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <%--模态框--%>
        <div class="modal fade" id="examine">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">审核详情</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="row">
                                <div class="col-md-12 col-sm-6">
                                    <!-- The time line -->
                                    <div class="timeline" id="Batchsave" >
                                        <!-- timeline item -->

                                        <div class="col-1 col-sm-2 col-md-3"id="num1" style="height: 50px">
                                        </div>
                                        <div class="col-1 col-sm-2 col-md-3"id="num2"style="height: 50px">
                                        </div>
                                        <div class="col-2 col-sm-2 col-md-3"id="num3"  style="height: 50px">
                                        </div>
                                        <div class="col-1 col-sm-2 col-md-1"id="num4">

                                        </div>
                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.card-footer -->
                        </form>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
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
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap4 Duallistbox -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<!-- InputMask -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/moment/moment.min.js"></script><script src="${pageContext.request.contextPath}/static/adminlte/plugins/moment/locale/zh-cn.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>
<!-- date-range-picker -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap color picker -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Bootstrap 开关 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.min.js"></script>
<!-- 用于演示 AdminLTE  -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
<!-- 页面脚本 -->
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>

<script language='javascript'>
    layui.use(['laypage', 'layer'],(function(){
        var laypage = layui.laypage
            ,layer = layui.layer;
        var count=${pageInfo.getTotal()};
        var pageNum=${pageInfo.pageNum};
        var pageSize=${pageInfo.pageSize};
        laypage.render({
            elem: 'demo1'
            ,count: count
            ,curr:pageNum
            ,limit:pageSize
            ,limits:[5,10,15,20,25]
            ,theme:'#00a1d6'
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj,first){
                var pageNum=obj.curr;
                pageSize=obj.limit;
                if(!first){
                    window.location="${pageContext.request.contextPath}/application/listBySn?pageNum="+pageNum+"&pageSize="+pageSize;
                }

            }
        });
    }));
</script>
<script>
    $(function () {
        $(".details").click(function () {
            //获取申请的id
            var id=$(this).attr("id");
            //清空 样式
            $("#num1").empty();
            $("#num2").empty();
            $("#num3").empty();
            $("#num4").empty();
            $("#examine").modal("show")
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/application/details?id="+id,
                dataType:"json",
                success:function (res) {
                    var status = res.data.status
                    var currentNodeCode = res.data.currentNodeCode
                    //根据下一个审核代码 和 当前审核状态动态 渲染流程图
                    switch (currentNodeCode) {
                        case 1:switch (status) {
                            case "DSH":$("#num1").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:待审核</b></div>"));
                            $("#num2").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学院审核:待审核</b></div>"));
                            $("#num3").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学校审核:待审核</b></div>"));
                            $("#num4").append($(" <i class='fas fa-clock bg-gray'></i>"));
                            break;
                            case "TG":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                            $("#num2").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学院审核:待审核</b></div>"));
                            $("#num3").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学校审核:待审核</b></div>"));
                            $("#num4").append($(" <i class='fas fa-clock bg-gray'></i>"));
                            break;
                            case "BTG":$("#num1").append($("<i class='fas fa-times bg-red'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:不通过</b></div>"));
                            $("#num2").append($("<i class='fas fa-clock bg-gray'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:</b></div>"));
                            $("#num3").append($("<i class='fas fa-clock bg-gray'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:</b></div>"));
                            $("#num4").append($(" <i class='fas fa-times bg-red'></i>"));
                            break;}
                            break;
                        case 2:switch (status) {
                            case "DSH":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num2").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学院审核:待审核</b></div>"));
                                $("#num3").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学校审核:待审核</b></div>"));
                                $("#num4").append($(" <i class='fas fa-clock bg-gray'></i>"));
                                break;
                            case "TG":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num2").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学院审核:已通过</b></div>"));
                                $("#num3").append($("<i class='fas fa-2x fa-sync-alt fa-spin'><div class=‘timeline-item’  style='margin-left:50px'></i><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学校审核:待审核</b></div>"));
                                $("#num4").append($(" <i class='fas fa-clock bg-gray'></i>"));
                                break;
                            case "BTG":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num2").append($("<i class='fas fa-times bg-red'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:不通过</b></div>"));
                                $("#num3").append($("<i class='fas fa-clock bg-gray'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:</b></div>"));
                                $("#num4").append($(" <i class='fas fa-times bg-red'></i>"));
                                break;}
                            break;
                        case 3:switch (status) {
                            case "DSH":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num2").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学院审核:已通过</b></div>"));
                                $("#num3").append($("<i class='fas fa-2x fa-sync-alt fa-spin'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学校审核:待审核</b></div>"));
                                $("#num4").append($(" <i class='fas fa-clock bg-gray'></i>"));
                                break;
                            case "TG":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num2").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学院审核:已通过</b></div>"));
                                $("#num3").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学校审核:已通过</b></div>"));
                                $("#num4").append($(" <i class='fas fa-clock bg-gray'></i>"));
                                break;
                            case "BTG":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’ style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num2").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num3").append($("<i class='fas fa-times bg-red'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:不通过</b></div>"));
                                $("#num4").append($(" <i class='fas fa-times bg-red'></i>"));
                                break;}
                                break;
                        case 4:switch (status) {
                            case "TG":$("#num1").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’  style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>导员审核:已通过</b></div>"));
                                $("#num2").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’ style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学院审核:已通过</b></div>"));
                                $("#num3").append($("<i class='fas fa-check bg-green'></i><div class=‘timeline-item’ style='margin-left:50px'><b style='color: #a7dd9f'style='height: 20px;margin-right: 20px;font-size: 105%;'>学校审核:已通过</b></div>"));
                                $("#num4").append($("<i class='fas fa-check bg-green'></i>"));
                                break;}
                                break;
                        default:break;
                    }
                }
            })


        })
    })
</script>
</body>
</html>

