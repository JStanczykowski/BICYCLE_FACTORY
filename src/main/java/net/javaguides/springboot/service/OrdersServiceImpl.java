package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Orders;
import net.javaguides.springboot.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders saveOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrderById(long id) {
        return ordersRepository.findById(id).get();
    }

    @Override
    public Orders updateOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void deleteOrderById(long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Orders getOrder(long id) {
        Optional<Orders> optionalOrders = ordersRepository.findById(id);
        return optionalOrders.get();
    }
}
