package dao.impl;

import dao.OrderItemDao;
import pojo.OrderItem;

import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-16 18:22
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public Integer saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (`id`,`name`,`count`,`price`,`total_money`,`order_id`) " +
                "values(?, ?, ?, ?, ?, ?)";
        return update(sql,
                orderItem.getId(),
                orderItem.getName(),
                orderItem.getCount(),
                orderItem.getPrice(),
                orderItem.getTotalPrice(),
                orderItem.getOrderId()
        );
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select `id`,`name`,`count`,`price`,`total_money` totalPrice,`order_id` orderId from t_order_item where `order_id` = ?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}
