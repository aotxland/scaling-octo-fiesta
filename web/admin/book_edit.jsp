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
    <title>编辑图书</title>
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
        <h3>编辑图书</h3>
        <form action="admin/bookServlet" method="get">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <c:if test="${empty param.id}">
                <input type="hidden" name="action" value="add">
            </c:if>
            <c:if test="${not empty param.id}">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${param.id}">
            </c:if>
            <table>
                <tr>
                    <td>名称</td>
                    <td>价格</td>
                    <td>作者</td>
                    <td>销量</td>
                    <td>库存</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                    <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                    <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                    <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                    <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                    <td><input name="stocks" type="text" value="${requestScope.book.stocks}"/></td>
                    <td><input type="submit" value="提交"/></td>
                </tr>
            </table>
        </form>
            <h3><td colspan="5"><a href="index.jsp">返回首页</a></td></h3>
    </div>

</div>
<%@ include file="/common/footer.jsp"%>
</body>
</html>
