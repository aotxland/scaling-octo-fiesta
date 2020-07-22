package dao;

import pojo.Order;
import pojo.OrderItem;

import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-16 18:01
 */
public interface OrderItemDao {
    Integer saveOrderItem(OrderItem orderItem);
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
