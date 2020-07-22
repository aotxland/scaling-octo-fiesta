<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yif
  Date: 2020/6/19
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书城</title>
    <%@ include file="/common/header.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("button.cart").click(function () {
                let bookId = $(this).attr("bookId");
                // location.href = "cartServlet?action=addItem&id=" + bookId;
                $.getJSON("${basePath}cartServlet","action=addItem&id=" + bookId, function (data) {
                    // console.log(data);
                    $("#total_count").text("您的购物车中有" + data.totalCount + "件商品");
                    $("#last_name").text("您刚刚将 " +  data.recentBook + " 加入到了购物车中");
                });
            });
        });
    </script>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="static/img/logo.png">
    </div>
    <%@ include file="/common/user_menu.jsp"%>
</div>

<div class="content">
    <div class="banner">
    </div>
    <div class="img_content">
        <ul>
            <div class="book_cond">
                <form action="client/ClientServlet" method="get">
                    <input type="hidden" name="action" value="pageByPrice">
                    价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                    <input id="max" type="text" name="max" value="${param.max}"> 元
                    <input type="submit" value="查询" />
                </form>
            </div>
        </ul>
        <ul>
            <div style="text-align: center">
                <br/><span id="total_count"></span>
                <br/><span id="last_name"></span>
            </div>
        </ul>

        <ul>
            <c:forEach items="${requestScope.page.items}" var="book">
            <li>
                <img src="${book.imgPath}" class="img_li">
                <div class="info">
                    <h3>${book.name}</h3>
                    <p class="book_info">
                        <div class="book_author">
                            <span class="sp1">作者:</span>
                            <span class="sp2">${book.author}</span>
                        </div>
                        <div class="book_sales">
                            <span class="sp1">销量:</span>
                            <span class="sp2">${book.sales}</span>
                        </div>
                        <div class="book_amount">
                            <span class="sp1">库存:</span>
                            <span class="sp2">${book.stocks}</span>
                        </div>
                    </p>
                    <div class="img_btn">
                        <!-- 价格，购买logo -->
                        <div class="price">￥${book.price}</div>
                        <!-- 购物车按钮 -->
                        <div class="btn">
                            <button bookId="${book.id}" class="cart">加入购物车</button>
                        </div>
                    </div>
                </div>
            </li>
            </c:forEach>
        </ul>

    </div>
    <!-- 分页 -->
    <%@include file="/common/page_navigation.jsp"%>

</div>
<%@ include file="/common/footer.jsp"%>
</body>
</html>