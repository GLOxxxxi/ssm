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
    <title>待我审核</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <!-- daterange picker -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">

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
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>所属批次</th>
                                        <th>姓名</th>
                                        <th>申请困难等级</th>
                                        <th>申请理由</th>
                                        <th>审核意见</th>
                                        <th>审核状态</th>
                                        <th>操作</th>
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
                                            <td>${app.statusValue}</td>
                                            <td>
                                                <button id="${app.id}" class="btn btn-success auditBtn">审核</button>
                                            </td>
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
        <%--审核模态框--%>
        <div class="modal fade" id="audit">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">审核</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="card card-info">
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form id="auditForm" class="form-horizontal" action="${pageContext.request.contextPath}/prodcut/update" method="post"
                                  enctype="multipart/form-data">
                                <input type="hidden" id="applicationId" name="applicationId">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">结果</label>
                                        <div class="col-sm-10">
                                            <div class="form-group clearfix">
                                                <div class="icheck-primary d-inline layui-form">
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio"class="layui-form-item"  name="status" value="TG" title="通过" >
                                                    </div>
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio"class="layui-form-item" name="status" value="BTG" title="不通过">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">审核意见</label>
                                        <div class="col-sm-10">
                                            <textarea name="auditComment" class="form-control"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" id="saveAudit" class="btn btn-success float-right">保存</button>
                                </div>
                            </form>
                        </div>
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
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.min.js"></script>
<!-- 用于演示 AdminLTE  -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
<%--<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>--%>
<!-- 页面脚本 -->
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    $(function () {

            $(".auditBtn").click(function () {
                var appId = $(this).attr("id")
                $("#applicationId").val(appId)
                $("#audit").modal("show")
            })
            $("#saveAudit").click(function () {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/application/audit",
                    data: $("#auditForm").serialize(),
                    dataType: "json",
                    success: function (res) {
                        layer.msg("审核成功",{icon: 1, time: 1000},function () {
                            window.location = "${pageContext.request.contextPath}/application/waitAudit"
                        })
                    }
                })
            })
        //重新刷新layui的表单信息将模板更新出来
        layui.form.render()
        })

</script>
</body>
</html>
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
                    window.location="${pageContext.request.contextPath}/application/waitAudit?pageNum="+pageNum+"&pageSize="+pageSize;
                }

            }
        });
    }));
</script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //表单赋值
        layui.$('#LAY-component-form-setval').on('click', function(){
            form.val('example', {
                "username": "贤心" // "name": "value"
                ,"password": "123456"
                ,"interest": 1
                ,"like[write]": true //复选框选中状态
                ,"close": true //开关状态
                ,"sex": "女"
                ,"desc": "我爱 layui"
            });
        });

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function(){
            var data = form.val('example');
            alert(JSON.stringify(data));
        });

    });
</script>