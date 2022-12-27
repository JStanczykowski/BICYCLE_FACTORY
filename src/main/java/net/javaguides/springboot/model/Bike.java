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

        public Bike(String serialNumber, String bikeType, String size, String color, Orders orders) {
            this.serialNumber = serialNumber;
            this.bikeType = bikeType;
            this.size = size;
            this.color = color;
            this.orders = orders;
        }
        public static class BikeEntityBuilder {
            private String serialNumber;
            private String bikeType;
            private String size;
            private String color;
            private Orders orders;


            public BikeEntityBuilder() {

            }

            public BikeEntityBuilder setSerialNumber(String serialNumber) {
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
                bike.orders = orders;
                return bike;
            }
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
