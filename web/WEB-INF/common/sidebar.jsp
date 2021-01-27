<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--c:if--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/16
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- 品牌 Logo -->
    <a href="index3.html" class="brand-link">
        <img src="${pageContext.request.contextPath}/static/adminlte/dist/img/ok.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">寒衣补助官网</span>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">
        <!-- 侧边栏用户面板（可选） -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="${pageContext.request.contextPath}/static/adminlte/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="用户头像">
            </div>
            <div class="info">
                <a href="#" class="d-block">欢迎,用户 ${loginUser.name}</a>
            </div>
        </div>

        <!-- 侧边栏菜单 -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- 使用 .nav-icon 类添加图标，
                     或使用 font-awesome 或其他任何图标字体库 -->
                <%--学校用户--%>
                <c:if test="${sessionScope.loginUser != null && sessionScope.loginUser.roleId==2}">
                    <li class="nav-item has-treeview menu-open">
                        <%--menu-open--%>
                        <a href="#" class="nav-link ">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                款式管理
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/product/list?pageNum=1&pageSize=5" class="nav-link ">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>寒衣管理</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/product/toAdd" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>寒衣添加</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/batch/list?pageNum=1&pageSize=5&active=&difficultyLevel=&name=" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>批次设置</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/application/listBySn" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>申请管理</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/application/waitAudit" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>待我审核</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/statistics/list" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>申请总览</p>
                        </a>
                    </li>
                </c:if>
                <%--学生用户--%>
                <c:if test="${sessionScope.loginUser != null && sessionScope.loginUser.roleId == 1}">
                    <%--学生--%>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/product/myList" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>查看寒衣</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/application/toApplicationAdd" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>提交申请</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/application/listBySn" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>我的申请</p>
                        </a>
                    </li>
                </c:if>
                <%--辅导员用户--%>
                <c:if test="${sessionScope.loginUser != null && sessionScope.loginUser.roleId == 4}">
                    <%--<li class="nav-item">--%>
                        <%--<a href="${pageContext.request.contextPath}/application/listBySn" class="nav-link">--%>
                            <%--<i class="fas fa-circle nav-icon"></i>--%>
                            <%--<p>申请管理</p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/application/waitAudit" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>待我审核</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/statistics/list" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>申请总览</p>
                        </a>
                    </li>
                </c:if>
                <%--学院用户--%>
                <c:if test="${sessionScope.loginUser != null && sessionScope.loginUser.roleId == 3}">
<%--9693--%>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/application/listBySn" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>申请管理</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/application/waitAudit" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>待我审核</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/statistics/list" class="nav-link">
                            <i class="fas fa-circle nav-icon"></i>
                            <p>申请统计</p>
                        </a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/user/main" class="nav-link">

                        <i class="fas fa-circle nav-icon"></i>
                        <p>主页</p>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->

</aside>
