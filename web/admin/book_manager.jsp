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
    <title>图书管理</title>
    <%@ include file="/common/header.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("是否删除《" + $(this).parent().parent().find("td:first").text() + "》");
            });
        });
    </script>
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
        <h3>图书管理</h3>
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.author}</td>
                    <td>${book.sales}</td>
                    <td>${book.stocks}</td>
                    <td><a href="admin/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                    <td><a class="deleteClass" href="admin/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="admin/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
            </tr>
        </table>
        <%@include file="/common/page_navigation.jsp"%>
            <h3><td colspan="5"><a href="index.jsp">返回首页</a></td></h3>
    </div>

</div>
<%@ include file="/common/footer.jsp"%>
</body>
</html>
