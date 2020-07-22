package service.impl;

import dao.BookDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import pojo.*;
import service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-16 19:13
 */
public class OrderServiceImpl implements OrderService {
    private BookDao bookDao = new BookDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        Order order = new Order();
        order.setCreateTime(new Date());
        String orderId = System.currentTimeMillis()+ "" +userId;
        order.setOrderId(orderId);
        order.setPrice(cart.getTotalPrice());
        order.setStatus(0);
        order.setUserId(userId);
        orderDao.saveOrder(order);
        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(item.getCount());
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setTotalPrice(item.getTotalPrice());
            orderItem.setOrderId(orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStocks(book.getStocks() - item.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,2);
    }

    @Override
    public Order showOrder(String orderId) {
        return orderDao.queryOrder(orderId);
    }
}
