package net.javaguides.springboot.model;

import net.javaguides.springboot.decorator.BikeInterface;

import javax.persistence.*;

@Entity
@Table(name = "Bike")
public class Bike implements BikeInterface {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "serialNumber")
        private int serialNumber;
        @Column(name = "numberOwner")
        private String numberOwner;
        @Column(name = "bikeType")
        private String bikeType;
        @Column(name = "anotherPrice")
        private String anotherPrice;

    public String getAnotherPrice() {
        return anotherPrice;
    }

    public void setAnotherPrice(String anotherPrice) {
        this.anotherPrice = anotherPrice;
    }

    public String getNumberOwner() {
        return numberOwner;
    }

    public void setNumberOwner(String numberOwner) {
        this.numberOwner = numberOwner;
    }

    @Column(name="active")
    private String active;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Column(name = "color")
        private String color;

        @Column(name = "price")
        private double price;

        @Column(name = "addextend")
        private String addextend;

        @Column(name = "currentValue")
        private String currentValue;
        @Column(name = "size")
        private String size;
//        @ManyToOne(cascade = CascadeType.ALL, optional = false)
//        @JoinColumn(name = "order_id", nullable = false)
//        private Orders orders;

    public void setAnotherCurrent(String value){

        setAnotherPrice(value+getCurrent());
    }
    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddextend() {
        return addextend;
    }

    public void setAddextend(String addextend) {
        this.addextend = addextend;
    }

    public Bike() {

        }
    public void changeCurrent(current cur,String name){

    }
        public Bike(int serialNumber, String bikeType, String size, String color, double price,String numberOwner) {
            this.serialNumber = serialNumber;
            this.bikeType = bikeType;
            this.size = size;
            this.color = color;
            this.numberOwner = numberOwner;
            this.price = price;
        }

    @Override
    public void dodaj() {
        this.setAddextend("");
    }

    public static class BikeEntityBuilder {
            private int serialNumber;
            private String bikeType;
            private String size;
            private String color;
            private Orders orders;
            private String current;

            private int price;


        private String addextend;

            public BikeEntityBuilder() {

            }



        public BikeEntityBuilder setCurrentValue(String currentValue) {
            this.current = currentValue;
            return this;
        }

        public BikeEntityBuilder setSerialNumber(int serialNumber) {
                this.serialNumber = serialNumber;
                return this;
            }

            public BikeEntityBuilder setBikeType(String bikeType) {
                this.bikeType = bikeType;
                return this;
            }
            public BikeEntityBuilder setSize(String size) {
                this.size = size;
                return this;
            }
            public BikeEntityBuilder setColor(String color) {
                this.color = color;
                return this;
            }
            public BikeEntityBuilder setPrice(int price) {
                this.price = price;
                return this;
            }
            public BikeEntityBuilder setAddExtend(String addextend) {
                this.addextend = addextend;
                return this;
            }
            public BikeEntityBuilder setOrder(Orders orders) {
                this.orders = orders;
                return this;
            }

            public Bike build() {
                Bike bike = new Bike();
                bike.serialNumber = this.serialNumber;
                bike.bikeType = this.bikeType;
                bike.size = size;
                bike.color = color;
                bike.currentValue = current;
                bike.price = price;
                bike.addextend = addextend;
                return bike;
            }
        }
        public Long getId() {
            return id;
        }

        public int getSerialNumber() {
            return serialNumber;
        }

        public String getBikeType() {
            return bikeType;
        }

        public String getSize() {
            return size;
        }
        public String getCurrent() {
            return currentValue;
        }

        public String getColor() {
            return color;
        }



        public void setId(Long id) {
            this.id = id;
        }

        public void setSerialNumber(int serialNumber) {
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
