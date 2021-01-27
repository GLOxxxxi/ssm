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
                        <h1>申请统计</h1>
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
                                    <form action="${pageContext.request.contextPath}/statistics/list" method="get" >
                                        <div class="row">
                                            <div class="col-4">
                                                <select class="form-control" id="collegeSelect" name="collegeName">

                                                </select>
                                            </div>
                                            <div class="col-2">
                                                <button class="btn btn-outline-primary" type="submit" id="select">学院数据查询</button>
                                            </div>

                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-header border-0">
                                    <div class="d-flex justify-content-between">
                                        <h3 class="card-title">申请数据</h3>
                                        <a href="javascript:void(0);">查看报表</a>
                                    </div>
                                </div>
                                <%--主体--%>
                                <section class="content">
                                    <div class="container-fluid">
                                        <!-- Small boxes (Stat box) -->
                                        <div class="row">
                                            <div class="col-lg-3 col-6">
                                                <!-- small box -->
                                                <div class="small-box bg-info">
                                                    <div class="inner">
                                                        <h3>${msg.allCount}</h3>

                                                        <p>总申请数</p>
                                                    </div>
                                                    <div class="icon">

                                                    </div>

                                                </div>
                                            </div>
                                            <!-- ./col -->
                                            <div class="col-lg-3 col-6">
                                                <!-- small box -->
                                                <div class="small-box bg-success">
                                                    <div class="inner">
                                                        <h3>${msg.passCount}</h3>

                                                        <p>通过人数</p>
                                                    </div>
                                                    <div class="icon">

                                                    </div>

                                                </div>
                                            </div>
                                            <!-- ./col -->
                                            <div class="col-lg-3 col-6">
                                                <!-- small box -->
                                                <div class="small-box bg-warning">
                                                    <div class="inner">
                                                        <h3>${msg.waitCount}</h3>

                                                        <p>待审核</p>
                                                    </div>
                                                    <div class="icon">

                                                    </div>

                                                </div>
                                            </div>
                                            <!-- ./col -->
                                            <div class="col-lg-3 col-6">
                                                <!-- small box -->
                                                <div class="small-box bg-danger">
                                                    <div class="inner">
                                                        <h3>${msg.noPassCount}</h3>

                                                        <p>未通过</p>
                                                    </div>
                                                    <div class="icon">

                                                    </div>

                                                </div>
                                            </div>
                                            <!-- ./col -->
                                        </div>
                                        <!-- /.row -->
                                        <!-- Main row -->
                                        <div class="row">
                                            <div class="col-lg-6 col-6">
                                                <div id="myCharts" style="height: 600px"></div>
                                            </div>
                                            <div class="col-lg-6 col-6">
                                                <div id="myCharts1" style="height: 600px"></div>
                                            </div>
                                        </div>
                                        <!-- /.row (main row) -->
                                    </div><!-- /.container-fluid -->
                                </section>
                                <div class="card-body">
                                    <!-- /.d-flex -->

                                    <div class="position-relative mb-4"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                                        <canvas id="visitors-chart" height="200" width="764" class="chartjs-render-monitor" style="display: block; width: 764px; height: 200px;"></canvas>
                                    </div>

                                    <!-- /.content -->
                                </div>

                                </div>
                            </div>

                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            <!-- /.container-fluid -->
        </section>
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
<script src="${pageContext.request.contextPath}/static/echarts/echarts.min.js"></script>
<script>
    $(function () {
         var collegeName="${applications.collegeName==null?99:applications.collegeName}"
        console.log(collegeName)
        //数据回
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/statistics/collegeStatistics",
            dataType:"json",
            success:function (res) {
                $("#collegeSelect").append($("<option value='' >"+"所有学院"+"</option>"));
                $(res.data).each(function (i, index) {
                    //data中包含方法找到的数据index作为数据的集合
                    if(collegeName==index.collegeName){
                    console.log(i)
                    console.log(index)
                    $("#collegeSelect").append($("<option value='"+index.collegeName +"' selected>"+ index.collegeName+"</option>"));
                    }else {
                    $("#collegeSelect").append($("<option value='" + index.collegeName + "'>" + index.collegeName + "</option>"));
                    }
            })
        }
        })

    });
</script>
</body>
</html>
<script>
    $(function () {
        var collegeName="${applications.collegeName==null?'':applications.collegeName}"
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/statistics/getStatisticsVO?collegeName="+collegeName,
            dataType: "json",
            success: function (res) {
                var myChart = echarts.init(document.getElementById("myCharts"));
                // 指定图表的配置项和数据
                option = {
                    //tip
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b}: {c} ({d}%)'
                    },
                    //图标
                    legend: {
                        orient: 'vertical',
                        left: 10,
                        data: ['总申请人数', '待审核人数', '已通过人数', '未通过人数',]
                    },
                    series: [
                        {
                            name: '人数统计',
                            type: 'pie',
                            radius: ['50%', '70%'],
                            avoidLabelOverlap: false,
                            label: {
                                show: false,
                                position: 'center'
                            },
                            //中心字体
                            emphasis: {
                                label: {
                                    show: true,
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            },
                            labelLine: {
                                show: false
                            },
                            data: [
                                {value: res.data.allCount, name: '总申请人数',itemStyle: { color: '#17a2b8' }},
                                {value: res.data.waitCount, name: '待审核人数',itemStyle: { color: '#ffc107' }},
                                {value: res.data.passCount, name: '已通过人数',itemStyle: { color: '#28a745' }},
                                {value: res.data.noPassCount, name: '未通过人数',itemStyle: { color: '#dc3545' }},

                            ]
                        }
                    ]
                };
                // option.series[0].data[0].value=res.data.allCount;
                // option.series[0].data[1].value=res.data.waitCount;
                // option.series[0].data[2].value=res.data.passCount;
                // option.series[0].data[3].value=res.data.noPassCount;
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                var myChart1 = echarts.init(document.getElementById("myCharts1"));
                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b}: {c} '
                    },
                    legend: {
                        orient: 'horizontal',
                        top: 10,
                        data: ['总申请人数', '待审核人数', '已通过人数', '未通过人数',]
                    },
                    xAxis: {
                        type: 'category',
                        data: ['总申请人数', '待审核人数', '已通过人数', '未通过人数']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        name: '人数统计',
                        data: [{value: res.data.allCount, name: '总申请人数',itemStyle: { color: '#17a2b8' }},
                            {value: res.data.waitCount, name: '待审核人数',itemStyle: { color: '#ffc107' }},
                            {value: res.data.passCount, name: '已通过人数',itemStyle: { color: '#28a745' }},
                            {value: res.data.noPassCount, name: '未通过人数',itemStyle: { color: '#dc3545' }},
                        ],
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart1.setOption(option);
            }
        })
    })
</script>