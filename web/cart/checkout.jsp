<%--
  Created by IntelliJ IDEA.
  User: Yif
  Date: 2020/6/19
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结算页面</title>
    <%@ include file="/common/header.jsp"%>
</head>
<body>
<div class="header">
    <div class="logo">
        <a href=""><img src="static/img/logo.png"></a>
    </div>
    <%@ include file="/common/user_menu.jsp"%>
</div>

<div class="content">
    <div class="banner">
    </div>
    <div class="table_content">

        <h2>你的订单已结算，订单号为${sessionScope.orderId}</h2>
        <h3><a href="order/orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看订单详情</a></h3>
        <h3><a href="index.jsp">返回首页</a></h3>
        <br/>
        <br/>
        <br/>
        <br/>
    </div>

</div>
<%@ include file="/common/footer.jsp"%>
</body>
</html>
