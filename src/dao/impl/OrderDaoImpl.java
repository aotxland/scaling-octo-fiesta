package dao.impl;

import dao.OrderDao;
import pojo.Order;

import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-16 18:03
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public Integer saveOrder(Order order) {
        String sql = "insert into t_order (`order_id`,`create_time`,`total_money`,`status`,`user_id`) " +
                "values(?, ?, ?, ?, ?)";
        return update(sql,
                order.getOrderId(),
                order.getCreateTime(),
                order.getPrice(),
                order.getStatus(),
                order.getUserId()
        );
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "SELECT `order_id` orderId, `create_time` createTime, `total_money` price, `status`, `user_id` userId FROM `t_order`";
        return queryForList(Order.class,sql);
    }

    @Override
    public Integer changeOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set `status` = ? where `order_id` = ?";
        return update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "SELECT `order_id` orderId, `create_time` createTime, `total_money` price, `status`, `user_id` userId FROM `t_order` where `user_id` = ?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public Order queryOrder(String orderId) {
        String sql = "SELECT `order_id` orderId, `create_time` createTime, `total_money` price, `status`, `user_id` userId FROM `t_order` where `order_id` = ?";
        return queryForOne(Order.class, sql, orderId);
    }
}
