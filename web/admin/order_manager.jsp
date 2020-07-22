<%--
  Created by IntelliJ IDEA.
  User: Yif
  Date: 2020/6/20
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <%@ include file="/common/header.jsp"%>
</head>
<body>
<div class="header">
    <div class="logo">
        <a href=""><img src="static/img/logo.png"></a>
    </div>
    <%@ include file="/common/manager_menu.jsp"%>
</div>

<div class="content">
    <div class="banner">
    </div>
    <div class="table_content">
        <h3>订单管理</h3>
        <table>
            <tr>
                <td>日期</td>
                <td>金额</td>
                <td>详情</td>
                <td>发货</td>

            </tr>
            <c:forEach items="${requestScope.orders}" var="order">
                <tr>
                    <td>${order.createTime}</td>
                    <td>${order.price}</td>
                    <td><a href="order/orderServlet?action=showOrderDetail&orderId=${order.orderId}&o=true">查看详情</a></td>
                    <td>
                        <c:choose>
                            <c:when test="${order.status == 0}">
                                已支付<a href="admin/orderServlet?action=sendOrder&orderId=${order.orderId}">发货</a>
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
            </c:forEach>
        </table>
            <h3><td colspan="5"><a href="index.jsp">返回首页</a></td></h3>
    </div>

</div>
<%@ include file="/common/footer.jsp"%>
</body>
</html>
