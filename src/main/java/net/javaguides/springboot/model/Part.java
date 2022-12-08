package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "Part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "partName")
    private String partName;

    @Column(name = "catalogNumber")
    private int catalogNumber;

    @Column(name = "partProducer")
    private String partProducer;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    public Part() {

    }

    public Part(String partName, int catalogNumber, String partProducer) {
        this.partName = partName;
        this.catalogNumber = catalogNumber;
        this.partProducer = partProducer;
    }
}
