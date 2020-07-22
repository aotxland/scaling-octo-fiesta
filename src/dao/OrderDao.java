package dao;

import pojo.Order;

import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-16 17:58
 */
public interface OrderDao {
    Integer saveOrder(Order order);
    List<Order> queryOrders();
    Order queryOrder(String orderId);
    Integer changeOrderStatus(String orderId, Integer status);
    List<Order> queryOrdersByUserId(Integer userId);
}
