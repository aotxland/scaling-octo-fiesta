package web;

import pojo.Cart;
import pojo.Order;
import pojo.OrderItem;
import pojo.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.JDBCUtils;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-16 19:37
 */
public class OrderServlet extends BaseServlet{
    OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if(user == null){
//            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            resp.sendRedirect(req.getContextPath() + "/user/login.jsp");

        }else{
            String orderId = orderService.createOrder(cart, user.getId());
            req.getSession().setAttribute("orderId",orderId);
            resp.sendRedirect(req.getContextPath() + "/cart/checkout.jsp");
            System.out.println("订单生成" + orderId);
        }
    }

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/admin/order_manager.jsp").forward(req,resp);
    }

    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        List<Order> orders = orderService.showMyOrders(id);
        req.setAttribute("orders",orders);
        req.getRequestDispatcher( "/order/order.jsp").forward(req,resp);
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
//        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/admin/orderServlet?action=showAllOrders");
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiveOrder(orderId);
//        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
        User user = (User) req.getSession().getAttribute("user");
        resp.sendRedirect(req.getContextPath() + "/order/orderServlet?action=showMyOrders&id=" + user.getId());
    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        Order order = orderService.showOrder(orderId);
        List<OrderItem> items = orderService.showOrderDetail(orderId);
        req.setAttribute("items",items);
        req.setAttribute("order",order);
        req.getRequestDispatcher("/order/order_item.jsp").forward(req,resp);
    }
}
