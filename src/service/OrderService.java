package service;

import pojo.Cart;
import pojo.Order;
import pojo.OrderItem;

import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-16 19:06
 */
public interface OrderService {
    String createOrder(Cart cart,Integer userId);
    List<Order> showAllOrders();
    void sendOrder(String orderId);
    List<OrderItem> showOrderDetail(String orderId);
    List<Order> showMyOrders(Integer userId);
    Order showOrder(String orderId);
    void receiveOrder(String orderId);
}
