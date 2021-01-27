<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>衣服列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap 4 -->
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.min.js"></script>
    <!-- 用于演示 AdminLTE  -->
    <script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
    <script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <script src="${pageContext.request.contextPath}/static/adminlte/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
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
                    <c:forEach items="${pageInfo.list}" var="pro">
                        <div class="col-lg-2" style="margin: 5px">
                            <div class="card" style="padding: -10px">
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                        <div class="carousel-inner">
                                            <c:forEach items="${pro.images}" var="img" varStatus="status">
                                                <c:if test="${status.index == 0}">
                                                    <div class="carousel-item active">
                                                        <img style="height: 150px;width: auto" class="d-block w-100"
                                                             src="${pageContext.request.contextPath}/static/img/${img.path}" alt="第一张幻灯片">
                                                    </div>
                                                </c:if>
                                                <c:if test="${status.index != 0}">
                                                    <div class="carousel-item">
                                                        <img style="height: 150px;width: auto" class="d-block w-100"
                                                             src="${pageContext.request.contextPath}/static/img/${img.path}" alt="第一张幻灯片">
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                        <p>款式名: ${pro.name} </p>
                                        <p>编码: ${pro.productNumber} </p>
                                        <button id="${pro.id}" class="btn  btn-outline-success btn-block select" style="margin-top: 10px">
                                            查看
                                        </button>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <div class="modal fade" id="productMsg">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">详情</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="card card-info">
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form id="form" class="form-horizontal" action="${pageContext.request.contextPath}/prodcut/insert">
                                <input type="hidden" id="proId">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">所属批次</label>
                                        <div class="col-sm-10">
                                            <input type="text" id="batchName" readonly name="name" readonly
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">款式</label>
                                        <div class="col-sm-10">
                                            <input type="text" id="name" readonly name="name" class="form-control"
                                                   placeholder="款式">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">性别</label>
                                        <div class="col-sm-10">
                                            <div class="form-group clearfix">
                                                <div class="icheck-primary d-inline">
                                                    <label id="gender" readonly>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">补助年级</label>
                                        <div class="col-sm-10">
                                            <div class="form-group clearfix">
                                                <div class="icheck-primary d-inline">
                                                    <label id="grades" readonly>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">编码</label>
                                        <div class="col-sm-10">
                                            <input type="text" id="productNumber" readonly name="productNumber"
                                                   class="form-control" placeholder="编码">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">规格</label>
                                        <div class="col-sm-10">
                                            <div id="skus">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">图片</label>
                                        <div id="imgs" class="col-sm-10">

                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">尺码表</label>
                                        <div class="col-sm-10">
                                            <div class="card-body pad">
                                                <div class="mb-3" id="description">
                                                    <textarea name="description" class="textarea" placeholder="在这里填写内容"
                                                              style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px; display: none;"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" id="choosePro" class="btn btn-success float-right">选择</button>
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
        <%--分页--%>
        <div id="demo1"class="card-body" style="float: bottom"></div>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="/WEB-INF/common/footer.jsp"/>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- 控制侧边栏内容在这里 -->
    </aside>
    <!-- /.control-sidebar -->
</div>
</body>
</html>
<script>
    $(function () {
        //学生提交选择的寒衣
        // $("#choosePro").click(function () {
        //     var id=$(".select").attr("id")
        //     console.log(id)
        // })



        $(document).ready(function () {
            $('.textarea').summernote({lang: 'zh-CN', code: ''})
            bsCustomFileInput.init();
        });
        $(".select").click(function () {
            var id = $(this).attr("id")
            $.get("${pageContext.request.contextPath}/product/selectById?id=" + id, function (res) {
                // console.info(res)
                //加载模态框数据
                $("#proId").val(res.data.id)
                $("#batchName").val(res.data.batch.name)
                $("#name").val(res.data.name)
                $("#gender").text(res.data.sexValue)
                var grades=[]
                $(res.data.gradeName).each(function (i, index) {
                    grades.push(index.gradeName)

                })
                $("#grades").text(grades)
                $("#productNumber").val(res.data.productNumber)
                //<span class="label label-success">Success</span>
                $("#skus").empty()
                $(res.data.skus).each(function (i, index) {
                    $("#skus").append($("<input type='radio' id='bttt"+i+"'  class='skuA ' name='sku' value='" + index.id + "'/><span>" + index.name + "</span>"))
                    $("#skus").append($("<span class='text-white bg-white'>"+ '&nbsp&nbsp' +"</span>"))
                    $("#skus").append($("<span id='bdt'>库存："+ res.data.stocks[i].curStock+"</span><span >/"+res.data.stocks[i].skuTotal +"</span>"))
                    $("#skus").append($("<span class='text-white bg-white'>"+ '&nbsp&nbsp' +"</span>"))
                    if(res.data.stocks[i].curStock === 0){
                        $("#bttt"+i+"").attr("disabled",true)
                    }
                })
                // if($("#bdt").val()<=0){
                //     console.log(11111111)
                //     $("#bttt").attr("disabled","false")
                //     // document.getElementById("bttt").disabled=false
                // }
                $("#imgs").empty()
                $(res.data.images).each(function (i, index) {
                    $("#imgs").append($("<img style='height: 150px;width: auto' src='${pageContext.request.contextPath}/static/img/" + index.path + "'/>"))
                })
                $("#description").html(res.data.description)
                $("#productMsg").modal("show")
            }, "json")
        })
        $("#choosePro").click(function () {
            var proId = $("#proId").val();
            var skuId = ""
            var sn ="${loginUser.sn}"
            $(".skuA").each(function (i, index) {
                if($(index).prop("checked")){
                    skuId=$(index).val()
                }
            })
            if(skuId === ""){
                layer.msg("请选择一个规格",{icon: 2,time: 1000})
                return false
            }

            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/grade/selectGradeBySn?sn="+sn,
                dataType:"json",
                success:function (res) {
                    var grades  =[]
                    var count=0
                    //$("#grades").text()是一整个字符串 用逗号隔开分别插入到grades里
                    grades=$("#grades").text().split(",")
                    for(var i=0;i<grades.length;i++){
                        if(grades[i]===res.data){
                            console.log("行")
                            count++
                            break;
                        }
                        else {
                            console.log("不行")

                        }
                    }
                    if(count>0){
                        $.ajax({
                            type: "post",
                            url: "${pageContext.request.contextPath}/application/update",
                            data: {skuId: skuId, productId: proId},
                            dataType: "json",
                            success: function (result) {
                                if(result.data){
                                    layer.msg("选衣成功,活动结束前尚可修改",{icon: 1,time: 2000},function () {
                                        $("#productMsg").modal("hide")
                                    })
                                }
                            }
                        })
                    }else{
                        layer.msg("您当前年级不符合该批次要求",{title:'提示',time:2000})
                    }


                }
            })

        })
    })
</script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/lang/summernote-zh-CN.min.js"></script>
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
                    window.location="${pageContext.request.contextPath}/product/myList?pageNum="+pageNum+"&pageSize="+pageSize;
                }

            }
        });
    }));
</script>