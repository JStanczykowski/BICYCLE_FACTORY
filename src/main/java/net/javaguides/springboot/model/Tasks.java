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

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Column(name="done")
    private Boolean done;
    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private TypeTask type;
    public Tasks() {
    }

    public Tasks(Long id, String orderNumber, String time, String instruction, Boolean done, TypeTask type) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.time = time;
        this.instruction = instruction;
        this.done = done;
        this.type = type;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public TypeTask getType() {
        return type;
    }

    public void setType(TypeTask type) {
        this.type = type;
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
