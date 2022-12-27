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

    @Column(name="active")
    private Boolean active;


    public Bike() {

    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Bike(String serialNumber, String bikeType, String size, String color, Boolean active) {
        this.serialNumber = serialNumber;
        this.bikeType = bikeType;
        this.size = size;
        this.color = color;
        this.active = active;
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


}
