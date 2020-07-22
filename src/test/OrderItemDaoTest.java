package test;

import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import org.junit.Test;
import pojo.OrderItem;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author AoTxLand
 * @date 2020-06-16 18:29
 */
public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(
                1,
                "看杂志",
                2,
                new BigDecimal(20),
                new BigDecimal(40),
                "1"));
    }

    @Test
    public void queryOrderItemByOrderId() {
        List<OrderItem> items = orderItemDao.queryOrderItemByOrderId("1");
        for (OrderItem item : items) {
            System.out.println(item);
        }
    }
}