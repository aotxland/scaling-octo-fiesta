package test;

import org.junit.Test;
import pojo.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author AoTxLand
 * @date 2020-06-16 19:31
 */
public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
    }

    @Test
    public void showAllOrders() {
        List<Order> list = orderService.showAllOrders();
        for (Order order : list) {
            order.toString();
        }
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("1");
    }

    @Test
    public void showOrderDetail() {
    }

    @Test
    public void showMyOrders() {
    }

    @Test
    public void receiveOrder() {
    }
}