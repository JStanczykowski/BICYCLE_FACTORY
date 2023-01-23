package net.javaguides.springboot.service;


import net.javaguides.springboot.model.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> getAllOrders();
    Orders saveOrder(Orders orders);
    Orders getOrderById(long id);
    Orders updateOrder(Orders orders);
    void deleteOrderById(long id);
    Orders getOrder(long id);
}
