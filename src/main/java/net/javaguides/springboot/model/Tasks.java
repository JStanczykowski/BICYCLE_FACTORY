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
    private int orderNumber;
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
    public Tasks(int orderNumber,Boolean done){
        this.orderNumber=orderNumber;
        this.done = done;
    }
    public Tasks(Long id, int orderNumber, String time, String instruction, Boolean done, TypeTask type) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.time = time;
        this.instruction = instruction;
        this.done = done;
        this.type = type;
    }

    public static class TaskEntityBuilder {
        private int orderNumber;
        private String time;
        private String instruction;
        private Boolean done;
        private TypeTask typeTask;

        public TaskEntityBuilder setOrderNumber(int orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public TaskEntityBuilder setTime(String time) {
            this.time = time;
            return this;
        }

        public TaskEntityBuilder setInstruction(String instruction) {
            this.instruction = instruction;
            return this;
        }

        public TaskEntityBuilder setDone(Boolean done) {
            this.done = done;
            return this;
        }

        public TaskEntityBuilder setTypeTask(TypeTask typeTask) {
            this.typeTask = typeTask;
            return this;
        }

        public Tasks build() {
            Tasks tasks = new Tasks();
            tasks.orderNumber = this.orderNumber;
            tasks.time = this.time;
            tasks.instruction = this.instruction;
            tasks.done = this.done;
            tasks.type = this.typeTask;
            return tasks;
        }
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
