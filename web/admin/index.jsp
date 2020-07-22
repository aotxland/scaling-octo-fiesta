<%--
  Created by IntelliJ IDEA.
  User: Yif
  Date: 2020/6/20
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <%@ include file="/common/auth_header.jsp"%>
</head>
<body>
<h2>后台管理系统</h2>
<div class="login-page">
    <div class="form">
        <form>
            <br/>
            <button onclick="window.open('admin/bookServlet?action=page')">图书管理</button>
            <br/>
            <br/>
            <button onclick="window.open('admin/orderServlet?action=showAllOrders')">订单管理</button>
            <br/>
            <br/>
            <button onclick="window.open('#')">返回首页</button>
        </form>
    </div>
</div>
</body>
</html>
