package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
