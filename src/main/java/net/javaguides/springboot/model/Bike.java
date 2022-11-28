package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "Bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serialNumber")
    private String serialNumber;

    @Column(name = "bikeType")
    private String bikeType;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    public Bike() {

    }

    public Bike(String serialNumber, String bikeType, String size, String color) {
        this.serialNumber = serialNumber;
        this.bikeType = bikeType;
        this.size = size;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBikeType() {
        return bikeType;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
