<%--
  Created by IntelliJ IDEA.
  User: Yif
  Date: 2020/6/13
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="auth">
    <ul>
        <li><a href="cart/cart.jsp">购物车</a></li>
        <c:if test="${not empty sessionScope.user}">
            <li>${sessionScope.user.username}</li>
            <li><a href="order/orderServlet?action=showMyOrders&id=${sessionScope.user.id}">我的订单</a></li>
            <li><a href="userServlet?action=logout">注销</a></li>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <li><a href="user/register.jsp">注册</a></li>
            <li><a href="user/login.jsp?loc=index">登录</a></li>
        </c:if>
    </ul>
</div>