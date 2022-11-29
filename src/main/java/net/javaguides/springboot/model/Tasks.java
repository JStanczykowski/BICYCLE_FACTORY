package net.javaguides.springboot.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name =  "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderNumber")
    private String orderNumber;
    @Column(name="time")
    private String time;
    @Column(name="instruction")
    private String instruction;

    public Tasks() {
    }

    public Tasks(Long id, String orderNumber, String time,String instruction) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.time = time;
        this.instruction = instruction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
