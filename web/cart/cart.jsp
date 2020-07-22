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
    <title>购物车</title>
    <%@ include file="/common/header.jsp"%>

    <script type="text/javascript">
        $(function () {
            $("a.delete_item").click(function () {
                return confirm("是否删除《" + $(this).parent().parent().find("td:first").text() + "》");
            });
            $("a.clear_items").click(function () {
                return confirm("是否清空购物车");
            });
            $(".update_count").change(function () {
                let id = $(this).attr("book_id");
                if(confirm("是否修改《" + $(this).parent().parent().find("td:first").text() + "》数量")){
                    location.href = "cartServlet?action=updateItem&id="+ id +"&count=" + this.value;
                }else{
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
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
        <h3>购物车</h3>
        <table>
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <c:if test="${empty sessionScope.cart.items}">
                <tr>
                    <td colspan="5">当前购物车为空！</td>
                </tr>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <c:forEach items="${sessionScope.cart.items}" var="item">
                    <tr>
                        <td>${item.value.name}</td>
                        <td>
                            <input class="update_count" type="text"
                                   value="${item.value.count}"
                                   book_id="${item.value.id}"
                                   style="width: 60px">
                        </td>
                        <td>${item.value.price}</td>
                        <td>${item.value.totalPrice}</td>
                        <td><a class="delete_item" href="cartServlet?action=deleteItem&&id=${item.value.id}">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <c:if test="${not empty sessionScope.cart.items}">
            <div class="cart_info">
                <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
                <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
                <span class="cart_span"><a class="clear_items" href="cartServlet?action=clear">清空购物车</a></span>
                <span class="cart_span"><a href="order/orderServlet?action=createOrder">去结账</a></span>
            </div>
        </c:if>
            <h3><td colspan="5"><a href="index.jsp">返回首页</a></td></h3>
    </div>

</div>
<%@ include file="/common/footer.jsp"%>
</body>
</html>
