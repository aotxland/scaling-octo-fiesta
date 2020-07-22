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
    <title>订单详情</title>
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
        <h3>订单详情</h3>
        <table>
            <tr>
                <td colspan="4">订单号：${requestScope.order.orderId}</td>
            </tr>
            <tr>
                <td colspan="2">下单时间：${requestScope.order.createTime}</td>
                <td colspan="2">订单状态：
                    <c:choose>
                        <c:when test="${order.status == 0}">
                            已支付
                        </c:when>
                        <c:when test="${order.status == 1}">
                            已发货
                        </c:when>
                        <c:when test="${order.status == 2}">
                            已签收
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td>名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>总价</td>
            </tr>
            <c:forEach items="${requestScope.items}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.count}</td>
                    <td>${item.price}</td>
                    <td>${item.totalPrice}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">合计：${requestScope.order.price}</td>
            </tr>
        </table>
            <h3><td colspan="5"><a href="index.jsp">返回首页</a></td></h3>
    </div>

</div>
<%@ include file="/common/footer.jsp"%>
</body>
</html>
