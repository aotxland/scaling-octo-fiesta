package test;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import org.junit.Test;
import pojo.Order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author AoTxLand
 * @date 2020-06-16 18:29
 */
public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        System.out.println(orderDao.saveOrder(new Order("1",
                new Date(),
                new BigDecimal(100),
                1,
                1
        )));
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {
        System.out.println(orderDao.changeOrderStatus("1", 2));
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDao.queryOrdersByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}