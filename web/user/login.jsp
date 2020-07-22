<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yif
  Date: 2020/6/19
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <%@ include file="/common/auth_header.jsp"%>
</head>
<body>
<h2>用户登录</h2>
<div class="login-page">
    <div class="form">
        <form method='post' action="userServlet">
            <br/>
            <span class="errorMsg">${requestScope.errMsg}</span>
            <c:if test="${not empty param.loc}">
                <input type="hidden" name="loc" value="index">
            </c:if>
            <input type="hidden" name="action" value="login">
            <input type="text" placeholder="用户名" id="username" name='username' maxlength="9"
                   value="${requestScope.username}"
                   required />
            <input type="password" placeholder="密码" id="password" name='password' required/>
            <a href="pages/user/register.jsp">立即注册</a>
            <button type="submit">登　录</button>
        </form>
    </div>
</div>
</body>
</html>
