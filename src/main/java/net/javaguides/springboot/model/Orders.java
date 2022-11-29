package net.javaguides.springboot.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "orderNumber")
    private String orderNumber;

    @Column(name = "orderDate")
    private LocalDate orderDate;

    public Orders(String orderNumber, LocalDate orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }

    public Orders() {
    }
}

