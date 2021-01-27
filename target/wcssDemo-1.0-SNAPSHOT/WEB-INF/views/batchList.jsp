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

    <!--时间选择器-->
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
    <!-- 离线 Google 字体: Source Sans Pro -->
    <link href="${pageContext.request.contextPath}/static/adminlte/dist/css/google.css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
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
                        <h1>批次申请</h1>
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
                            <div class="card-header">
                                <div class="card-body">
                                    <form action="${pageContext.request.contextPath}/batch/list" method="get">
                                    <input type="hidden" name="pageNum" value="1">
                                    <input type="hidden" name="pageSize" value="5">
                                        <div class="row">
                                        <div class="col-2">
                                            <input type="text" name="name" class="form-control" id="selectName" placeholder="批次名称">
                                        </div>
                                        <div class="col-2">
                                            <select class="form-control" id="dif" name="difficultyLevel">

                                            </select>
                                        </div>
                                        <div class="col-2">
                                                <select class="form-control" name="active" id="active">
                                                    <option value="">所有</option>
                                                    <option value="1">进行中</option>
                                                    <option value="0">已结束</option>
                                                </select>
                                        </div>
                                        <div class="col-1">
                                            <button class="btn btn-outline-success" type="submit" id="select">查询操作</button>
                                        </div>
                                            <div class="col-1">
                                            <button class="btn btn-outline-info " type="button" id="clear">重置查询</button>
                                        </div>
                                        <div class="col-1">
                                            <button class="btn btn-outline-primary" id="createBatch" type="button">新建申请</button>
                                        </div>
                                            <div class="col-1">
                                                <button class="btn btn-outline-danger" id="deletes" type="button">批量删除</button>
                                            </div>
                                    </div>
                                    </form>
                                </div>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr style="text-align: center">
                                        <th><input type="checkbox" id="checkAll">全选</th>
                                        <th>批次名称</th>
                                        <th>补助年级</th>
                                        <th>申请开始时间</th>
                                        <th>申请结束时间</th>
                                        <th>选衣开始时间</th>
                                        <th>选衣结束时间</th>
                                        <th>困难等级</th>
                                        <th>批次状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="batch" >
                                        <tr style="text-align: center">
                                            <td><input type="checkbox" class="mycheck" id="${batch.id}"></td>
                                            <td>${batch.name}</td>
                                            <td >
                                                <%--<select class=" col-4 grade"></select>--%>

                                                <button class="btn btn-info toastsDefaultInfo" type="button" id="${batch.id}">查看年级</button>
                                            </td>
                                            <td>${batch.applicationStartDate}</td>
                                            <td>${batch.applicationEndDate}</td>
                                            <td>${batch.registerStartDate}</td>
                                            <td>${batch.registerEndDate}</td>
                                            <td>${batch.difVal}</td>
                                            <%--bg-gray color-palette--%>
                                            <%--bg-lightblue color-palette--%>
                                            <c:if test="${batch.active ==0}"><th class="bg-gray color-palette">已结束</th></c:if>
                                            <c:if test="${batch.active ==1}"><th class="bg-lightblue color-palette">进行中</th></c:if>
                                            <%--<th> ${batch.active ==0?"已结束":"进行中"}</th>--%>
                                            <td>
                                                <button class="btn btn-success end" type="button" id="${batch.id}">结束活动</button>
                                                <button class="btn btn-danger delete" id="${batch.id}" type="button">批次删除</button>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div id="demo1"></div>
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
        <!--弹窗模态框 -->
        <div class="modal fade" id="newBatch">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">批次申请</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="Batchsave">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label for="name" class="col-sm-2 col-form-label">批次名称</label>
                                    <div class="form-group">
                                        <div class="input-group date"  data-target-input="nearest">
                                            <input type="text" name="name" id="name" class="form-control datetimepicker-input" placeholder="批次名称">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="name" class="col-sm-2 col-form-label">参与年级</label>
                                    <div class="form-group">
                                        <div class="form-group row" id="gradeName">

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="applicationStartDate" class="col-sm-2 col-form-label">申请开始时间</label>
                                    <div class="form-group">
                                        <div class="input-group date"  data-target-input="nearest">
                                            <input type="text" name="applicationStartDate" id="applicationStartDate" class="form-control datetimepicker-input" data-target="#applicationStartDate"placeholder="申请开始时间">
                                            <div class="input-group-append" data-target="#applicationStartDate" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="applicationEndDate" class="col-sm-2 col-form-label">申请结束时间</label>
                                    <div class="form-group">
                                        <div class="input-group date"  data-target-input="nearest">
                                            <input type="text" name="applicationEndDate"id="applicationEndDate" class="form-control datetimepicker-input" data-target="#applicationEndDate"placeholder="申请结束时间">
                                            <div class="input-group-append" data-target="#applicationEndDate" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="registerStartDate" class="col-sm-2 col-form-label">选衣开始时间</label>
                                    <div class="form-group">
                                        <div class="input-group date"  data-target-input="nearest">
                                            <input type="text" name="registerStartDate"id="registerStartDate" class="form-control datetimepicker-input" data-target="#registerStartDate"placeholder="选衣开始时间">
                                            <div class="input-group-append" data-target="#registerStartDate" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="registerEndDate" class="col-sm-2 col-form-label">选衣结束时间</label>
                                    <div class="form-group ">
                                        <div class="input-group date "  data-target-input="nearest">
                                            <input type="text" name="registerEndDate"id="registerEndDate" class="form-control datetimepicker-input" data-target="#registerEndDate" placeholder="选衣结束时间">
                                            <div class="input-group-append" data-target="#registerEndDate" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label">困难等级</label>
                                    <div class="form-group">
                                        <div class="col-sm-6 " >
                                            <!-- radio -->
                                            <div class="row">
                                                <div class="icheck-primary d-inline">
                                                <input type="radio" class="active" id="difficultyLevel" name="difficultyLevel" value="BKN" checked>
                                                <label for="difficultyLevel">
                                                    不困难
                                                </label>
                                            </div>
                                                <div class="icheck-primary d-inline">
                                                    <input type="radio" id="radioPrimary2" name="difficultyLevel" value="YBKN">
                                                    <label for="radioPrimary2">
                                                        一般困难
                                                    </label>
                                                </div>
                                                <div class="icheck-primary d-inline">
                                                    <input type="radio" id="radioPrimary3" name="difficultyLevel" value="TSKN">
                                                    <label for="radioPrimary3">
                                                        特殊困难
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.card-footer -->
                        </form>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="saveBatch">添加批次</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
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
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    $(function () {
        //回显补助年级
        $('.toastsDefaultInfo').click(function() {
            var id=$(this).attr("id")
            var grades=[]
            var batchName =""
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/grade/selectById?id="+id,
                dataType:"json",
                success:function (res) {
                    $(res.data).each(function (i,index) {
                        console.log(index.gradeName)
                        grades.push(index.gradeName)
                        // grades.push("||")
                    })
                    $(res.data).each(function (i, index) {
                       batchName = index.batchName
                    })
                    $(document).Toasts('create', {
                        class: 'bg-info',
                        title: '批次名称：'+batchName,
                        // autohide:true,
                        position: 'bottomRight',
                        // delay:3000,
                        subtitle: '',
                        body: '补助年级:'+grades
                    })
                }
            })

        });
        //初始化状态和苦难等级 不判断会页面报错
        var activeInit =${batch.active==null?999:batch.active};
        var difL ="${batch.difficultyLevel==null||batch.difficultyLevel==""?99:batch.difficultyLevel}";
        var nameInit ="${batch.name==null?99:batch.name}";
        $("#selectName").val(nameInit)
        //查询后的批次状态数据回显
        var active=document.getElementById("active");
        for(var i=0;i<active.length;i++) {
            if (active[i].value == activeInit) {
                active[i].selected = true;
            }
        }
        //重置查询
        $("#clear").click(function () {
            $("#selectName").val("");
            $("#active").val("");
            $("#dif").val("");

        })

        $("#example1").DataTable({
            "language": {"url": "/AdminLTE/AdminLTE-3.x/plugins/datatables/Chinese.json"},
            "language": {"url": "/AdminLTE/AdminLTE-3.x/plugins/datatables/Chinese.json"},
            "responsive": true,
            "autoWidth": false,
        });
        //模态框开关
        $("#createBatch").click(function () {
            //清空表单
            $("#Batchsave")[0].reset();
            $("#newBatch").modal("show");
            $("#gradeName").empty()
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/knrd/selectGrade",
                dataType:"json",
                success:function (res) {
                    $(res.data).each(function (i, index) {
                        console.log(index.gradeName)
                        $("#gradeName").append($(" <div class='form-check'>" +
                            "<input class='form-check-input' type='checkbox' name='gradeName' value='"+index.gradeName+"' >" +
                            "<label class='form-check-label' >"+index.gradeName+"</label>" +
                            "</div>"))
                    })
                }
            })
        })
        // 日期范围选择器
        $(function () {
            $('#applicationStartDate').datetimepicker({
                format: 'YYYY-MM-DD'
            });
            $('#applicationEndDate').datetimepicker({
                format: 'YYYY-MM-DD'
            });
            $('#registerStartDate').datetimepicker({
                format: 'YYYY-MM-DD'
            });
            $('#registerEndDate').datetimepicker({
                format: 'YYYY-MM-DD'
            });
        })
        //新建批次
        $("#saveBatch").click(function () {
            var name=$("#name").val()
            var applicationStartDate=$("#applicationStartDate").val()
            var applicationEndDate=$("#applicationEndDate").val()
            var registerStartDate=$("#registerStartDate").val()
            var registerEndDate=$("#registerEndDate").val()
            var difficultyLevel=$("#difficultyLevel").val()


            if(name==""||name==null){
                alert("批次名称")
            }else
            if(applicationStartDate==""||applicationStartDate==null){
                alert("活动开始时间")
            }else
            if(applicationEndDate==""||applicationEndDate==null){
                alert("活动结束时间")
            }else
            if(registerStartDate==""||registerStartDate==null){
                alert("选衣开始时间")
            }else
            if(registerEndDate==""||registerEndDate==null){
                alert("选衣结束时间")
            }else
            if(difficultyLevel==""||difficultyLevel==null){
                alert("困难等级")
            }else{
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/batch/getActiveBatch?name="+name,
                    success:function (data) {
                        if(data.data!=null){
                            layer.msg("该批次已存在，请确认后添加",{icon:7,time:3000});
                        }else {
                            $.ajax({
                                type:"post",
                                url:"${pageContext.request.contextPath}/batch/save",
                                data:$("#Batchsave").serialize(),
                                success:function (res) {
                                    if(res=="succ"){
                                        layer.msg("添加成功",{icon:6,time:2000},function () {
                                            $("#newBatch").modal("hide");
                                            window.location.reload();
                                        })
                                    }else if(res=="fail"){
                                        layer.msg("添加失败",{icon:5,time:2000});
                                    }else{
                                        layer.msg("未知错误，联系管理员",{icon:7,time:2000});
                                    }
                                }
                            })
                        }
                    }
                })
            }

        })
        $("#pageSize").val(${pageInfo.pageSize})
        $("#pageSize").change(function () {
            window.location="${pageContext.request.contextPath}/batch/list?pageNum=1&pageSize="+$(this).val();
        })
        //数据回显
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/dictionary/getDictionary",
            data:{type:"DIFFICULTY"},
            dataType:"json",
            success:function (res) {
                $("#dif").append($("<option value=''>"+"所有"+"</option>"));
                $(res.data).each(function (i, index) {
                    //查询后的困难等级数据回显
                   if(difL==index.itemValue){
                        $("#dif").append($("<option value='"+index.itemValue +"' selected>"+ index.itemName+"</option>"));
                    }else {
                       $("#dif").append($("<option value='" + index.itemValue + "'>" + index.itemName + "</option>"));
                   }
                })

            }
        })
        //结束活动事件
        $(".end").click(function () {

            var id=$(this).attr("id")
            layer.confirm("是否确认结束该批次",{icon:3,title:'提示'},function (index) {
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/batch/end?id="+id,
                    dataType:"json",
                    success:function (res) {
                        if(res.data){
                            window.location.reload();
                        }
                    }
                })
                layer.close(index);
            },function (index) {
                layer.close(index);
            })
        })
        //删除单个批次
        $(".delete").click(function () {
            //class获取当前选择的id 唯一
            var id=$(this).attr("id");
            var ids=[];
            //将单个的id放到ids里 共用同一方法
            ids.push(id);
            console.log(ids)
            layer.confirm("是否删除该批次",{icon:7,title:'提示'},function (index) {
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/batch/deletes",
                    data:{ids:ids},
                    dataType:"json",
                    success:function (res) {
                        if(res.code==200){
                            layer.msg("删除成功",{icon:1,time:2000},function () {
                                window.location.reload();
                            })
                        }
                    }
                })
                layer.close(index);
            },function (index) {
                layer.close(index)
            })
        })
        //全选标签
        $("#checkAll").click(function () {
            var flag = $(this).prop("checked")

            $(".mycheck").prop("checked",flag);

        })
        //反选
        var checkbox = document.querySelector("tbody").querySelectorAll("input");
        $(".mycheck").click(function () {
            for(var i=0; i<checkbox.length;i++){
                if(!checkbox[i].checked){
                    //check标签两个参数 “checked” 和 ture 选中 false 反之
                    $("#checkAll").prop("checked",false)
                }
            }
        })

        //批量删除
        $("#deletes").click(function () {
            var ids=[]
            $(".mycheck").each(function (i,index) {
                if($(index).prop("checked")){
                    ids.push($(index).attr("id"))
                }
            })
            if(ids.length == 0){
                layer.msg("请至少选择一条数据");
                return false;
            }
            layer.confirm("是否删除当前选择批次",{icon:7,title:'提示'},function (index) {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/batch/deletes",
                data:{ids:ids},
                dataType:"json",
                success:function (res) {
                    if(res.code==200){
                        layer.msg("删除成功",{icon:1,time:2000},function () {
                            window.location.reload();
                        })
                    }
                }
            })
                layer.close(index);
            },function (index) {
                layer.close(index)
            })
        })

        <%--$("#active")[0].value=${batch.active};--%>


    });
</script>
<script language='javascript'>
    layui.use(['laypage', 'layer'],(function(){
        var laypage = layui.laypage
            ,layer = layui.layer;
        var count=${pageInfo.getTotal()};
        var pageNum=${pageInfo.pageNum};
        var pageSize=${pageInfo.pageSize};
        var activeInit = $("#active").val();
        var difL ="${batch.difficultyLevel==null?"":batch.difficultyLevel}";
        var nameInit ="${batch.name==null?"":batch.name}";
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

                    window.location="${pageContext.request.contextPath}/batch/list?pageNum="+pageNum+"&pageSize="+pageSize+"&active="+activeInit+"&difficultyLevel="+difL+"&name="+nameInit;
                }

            }
        });
    }));
</script>
</body>
</html>
