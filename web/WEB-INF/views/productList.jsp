<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>衣服列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/dist/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"  media="all">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/adminlte/plugins/summernote/summernote-bs4.css">
    <script src="${pageContext.request.contextPath}/static/adminlte/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- 导航栏 -->
    <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
    <!-- /.navbar -->
    <jsp:include page="/WEB-INF/common/sidebar.jsp"></jsp:include>
    <!-- 内容标题（页面标题） -->
    <div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>寒衣列表</h1>
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

            <div class="row" style="padding: 20px">
                <c:forEach items="${pageInfo.list}" var="pro">
                    <div class="col-lg-2" style="margin: 10px">
                        <div class="card" style="padding: -10px">
                            <!-- /.card-header -->
                            <div class="card-body">
                                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                    <div class="carousel-inner">
                                        <c:forEach items="${pro.images}" var="img" varStatus="status">
                                            <c:if test="${status.index == 0}">
                                                <div class="carousel-item active">
                                                    <img style="height: 150px;width: auto" class="d-block w-100" src="${pageContext.request.contextPath}/static/img/${img.path}" alt="${img.name}">
                                                </div>
                                            </c:if>
                                            <c:if test="${status.index != 0}">
                                                <div class="carousel-item ">
                                                    <img style="height: 150px;width: auto" class="d-block w-100" src="${pageContext.request.contextPath}/static/img/${img.path}" alt="${img.name}">
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <p>款式名:${pro.name}</p>
                                    <p>编码:${pro.productNumber}</p>
                                    <button class="btn  btn-outline-success btn-block select" id="${pro.id}">查看</button>
                                    <button class="btn  btn-outline-primary btn-block update" id="${pro.id}">修改</button>
                                    <button class="btn  btn-outline-danger btn-block delete" id="${pro.id}">删除</button>
                                </div>
                            </div>
                            <!-- /.card-body -->
                        </div>
                    </div>
                </c:forEach>
                <!-- /.col -->
            </div>
            <div class="card-footer">
                <div id="demo1"></div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </section>
        <%--寒衣查看--%>
        <div class="modal fade" id="proMsg">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">寒衣详情</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="form" action="${pageContext.request.contextPath}/product/insert" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="pageNum" value="1">
                            <input type="hidden" name="pageSize" value="5">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label">所属批次</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" readonly id="batchName" placeholder="款式">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label"><b
                                            style="color: #ff0000">*</b>款式</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="name" readonly name="name" placeholder="款式">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label" readonly=""><b
                                            style="color: #ff0000">*</b>性别</label>
                                    <div class="col-sm-10">
                                        <div class="form-group">
                                            <!-- 性别 -->
                                            <div class="form-group row">
                                                <div class="icheck-primary d-inline"
                                                     style=" margin-right: 100px; margin-left: 20px;">
                                                    <label id="gender">
                                                        男款
                                                    </label>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label"><b
                                            style="color: #ff0000">*</b>编码</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="productNumber" readonly name="productNumber"
                                               placeholder="编码">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label"><b style="color: #ff0000">*</b>规格</label>
                                    <div class="col-sm-10" id="skus"></div>

                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label"><b style="color: #ff0000">*</b>款式图片</label>
                                    <%--<div class="col-sm-10">--%>
                                    <%--<input type="file" class=" custom-file-input" name="file">--%>
                                    <%--</div>--%>
                                    <div class=" col-sm-10" id="imgs">

                                    </div>

                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">尺码表</label>
                                    <div class="col-sm-10">
                                        <div class="mb-3" id="description">
                                            <textarea class="textarea" placeholder="在这里填写内容" name="description" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px; display: none;"><div></div></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.card-body -->
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
        <%--寒衣修改--%>
        <div class="modal fade" id="proUpdate">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">寒衣修改</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="updateForm" action="${pageContext.request.contextPath}/product/update" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="pageNum" value="1">
                            <input type="hidden" name="pageSize" value="5">
                            <input type="hidden" name="id" id="proId">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label">所属批次</label>
                                    <div class="col-sm-10">
                                        <select class="form-control" id="batchId" name="batchId">

                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label"><b
                                            style="color: #ff0000">*</b>款式</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="nameUpdate"  name="name" placeholder="款式">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label" readonly=""><b
                                            style="color: #ff0000">*</b>性别</label>
                                    <div class="col-sm-10">
                                        <div class="form-group">
                                            <!-- 性别 -->
                                            <div class="form-group row">
                                                <div class="icheck-primary d-inline"
                                                     style=" margin-right: 100px; margin-left: 20px;">
                                                    <input type="radio" id="male" class="active"
                                                           name="gender" value="M" >
                                                    <label for="male">
                                                        男款
                                                    </label>
                                                </div>
                                                <div class="icheck-primary d-inline">
                                                    <input type="radio" id="famale" name="gender"
                                                           value="F">
                                                    <label for="famale">
                                                        女款
                                                    </label>
                                                </div>
                                                <div class="icheck-primary d-inline"
                                                     style="margin-left: 100px;">
                                                    <input type="radio" id="both" name="gender"
                                                           value="MF">
                                                    <label for="both">
                                                        通用款
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label  class="col-sm-2 col-form-label"><b
                                            style="color: #ff0000">*</b>编码</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="productNumberUpdate"  name="productNumber"
                                               placeholder="编码">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label"><b style="color: #ff0000">*</b>规格</label>
                                    <div class="col-sm-10" id="skusUpdateP">
                                        <div id="skusUpdate">

                                        </div>
                                        <button type="button" id="addSku" class="btn btn-info ">添加</button>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label"><b style="color: #ff0000">*</b>款式图片</label>
                                    <%--<div class="col-sm-10">--%>
                                    <%--<input type="file" class=" custom-file-input" name="file">--%>
                                    <%--</div>--%>
                                    <div class=" col-sm-10" id="imgsUpdateP">
                                        <div id="imgsUpdate">

                                        </div>
                                        <button type="button" id="addImg" class="btn btn-info ">添加</button>
                                    </div>

                                </div>
                                <%--<div class="form-group row">--%>
                                    <%--<label class="col-sm-2 col-form-label">尺码表</label>--%>
                                    <%--<div class="col-sm-10">--%>
                                        <%--<div class="mb-3" id="descriptionUpdate">--%>
                                            <%--<textarea id="dd" class="textarea" placeholder="在这里填写内容" name="description" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px; display: none;"></textarea>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">尺码表</label>
                                    <div class="col-sm-10">
                                        <div class="card-body pad">
                                            <div class="mb-3" id="descriptionUpdate">
                                                    <textarea name="description" class="textarea"  placeholder="在这里填写内容"
                                                              style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px; display: none;"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.card-body -->
                            <!-- /.card-footer -->
                            <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-success" id="updatabtn">保存</button>
                        </div>
                        </form>
                    </div>

                </div>
                <!-- /.modal-content -->
            </div>

            <!-- /.modal-dialog -->
        </div>


       </div>

    <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<%--<script src="${pageContext.request.contextPath}/static/bootstrap/dist/js/bootstrap.min.js"></script>--%>

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

<%--<script src="${PATH}/static/adminlte/plugins/summernote/summernote-bs4.min.js"></script>--%>
<%--<script src="${PATH}/static/adminlte/plugins/summernote/lang/summernote-zh-CN.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
<script>
    $(function () {
        $(document).ready(function () {
            $('.textarea').summernote({lang: 'zh-CN', code: ' '})
            bsCustomFileInput.init();
        });

    })
</script>
</body>
</html>
<script>
    $(function () {
        //寒衣删除
        $(".delete").click(function () {
            var id = $(this).attr("id");
            layer.confirm("确定删除该款式吗？",{icon:7,title:'提示'},function (index) {
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/product/deleteById?id="+ id,
                    dataType:"json",
                    success:function (res) {
                        if(res.data){
                            layer.msg("删除成功！",{icon:3,time:2000},function () {
                                window.location = "${pageContext.request.contextPath}/product/list?pageNum=1&pageSize=5";
                            })
                        }else{
                            layer.msg("该批次已经开始选择无法删除！",{icon:0,title:'提示'},function (index) {
                               layer.close(index);
                            })
                        }

                    }
                })
            },function (index) {
                layer.close(index);
            })
        })
        //寒衣查看
        $(".select").click(function () {
            var id = $(this).attr("id");
            $.get("${pageContext.request.contextPath}/product/selectById?id="+ id,function (res) {
                //加载模态框数据
                $("#batchName").val(res.data.batch.name);
                $("#name").val(res.data.name);
                $("#gender").text(res.data.sexValue);
                $("#productNumber").val(res.data.productNumber);
                $("#skus").empty()
                $(res.data.skus).each(function (i, index) {
                    $("#skus").append($("<span class='text-white bg-info'>"+ index.name +"</span>"))
                    $("#skus").append($("<span class='text-white bg-white' >"+ '&nbsp&nbsp' +"</span>"))
                    $("#skus").append($("<span>库存："+ res.data.stocks[i].curStock+"/"+res.data.stocks[i].skuTotal +"</span>"))
                    $("#skus").append($("<span class='text-white bg-white'>"+ '&nbsp&nbsp' +"</span>"))
                })
                $("#imgs").empty()
                $(res.data.images).each(function (i, index) {
                    $("#imgs").append($("<img  style='height: 150px;width: auto' src='${pageContext.request.contextPath}/static/img/"+index.path+"'/>"))

                })
                $("#description").html(res.data.description)
                $("#proMsg").modal("show")
            },"json")
        })
        //寒衣修改
        /*规格添加 */
        $("#addSku").click(function () {
            $("#skusUpdate").append($("<p><input type='text' name='skuName'> <button type='button' class='deleteSku'>删除</button></p> "))
            $(".deleteSku").click(function () {
                $(this).parent().remove();
            })
        })
        /*图片添加 */
        $("#addImg").click(function () {
            $("#imgsUpdate").append($(" <input type='file' class='form-control'  name='file'>"))
        })
        $(".update").click(function () {
            var id = $(this).attr("id");
            $.get("${pageContext.request.contextPath}/product/selectById?id="+ id,function (res) {
                //加载模态框数据
                //批次下拉
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/batch/listByAjax",
                    dataType:"json",
                    success:function (result) {
                        $(result.data).each(function (i,index) {
                            $("#batchId").append($("<option value='"+index.id+"'>"+index.name+"</option>"))
                        })
                    //    回显当前批次
                        $("#batchId").val(res.data.batchId)

                    }
                })
                $("#proId").val(res.data.id)
                //款式名
                $("#nameUpdate").val(res.data.name);
                //性别
                $("input[type=radio]").each(function () {
                   if( $(this).val()=== res.data.gender){
                       $(this).prop("checked",true)
                   }
                })
                //规格
                $("#skusUpdate").empty()
                $(res.data.skus).each(function (i, index) {
                    $("#skusUpdate").append($("<p><input type='text' name='skuName' value='"+index.name+"'> <button type='button' class='deleteSku'>删除</button></p>"))
                    $(".deleteSku").click(function () {
                        $(this).parent().remove()
                    })
                })
                //图片
                $("#imgsUpdate").empty()
                $(res.data.images).each(function (i, index) {
                    $("#imgsUpdate").append($("<p><img style='height: 150px;width: auto' src='${pageContext.request.contextPath}/static/img/"+index.path+"'/><button type='button' class='btn btn-danger deleteImg'>删除</button><input type='hidden' name='oldImg' value='"+index.path+"'/></p>"))
                    $(".deleteImg").click(function () {
                        $(this).parent().remove();
                    })
                })

                //编码
                $("#productNumberUpdate").val(res.data.productNumber);
                //尺码表
                $('.textarea').val(res.data.description)

                // var innerHtml=res.data.description.val();
                // $('#dd').summernote('editor.insertText',res.data.description)
                $("#proUpdate").modal("show")
            },"json")

        })
    })
</script>
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
                    window.location="${pageContext.request.contextPath}/product/list?pageNum="+pageNum+"&pageSize="+pageSize;
                }

            }
        });
    }));
</script>