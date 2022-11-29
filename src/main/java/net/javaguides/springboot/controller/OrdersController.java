package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Orders;
import net.javaguides.springboot.service.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("")
    public List<Orders> getOrders() {
        return ordersService.getAllOrders();
    }

    @PostMapping("/save")
    public void addNewOrder(@RequestBody Orders orders) {
        ordersService.saveOrder(orders);
    }
}
