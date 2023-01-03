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

    @Column(name="ilosc")
    private int ilosc;

    @Enumerated(EnumType.STRING)
    @Column(name="stat")
    private status stat;


    public status getStat() {
        return stat;
    }

    public void setStat(status stat) {
        this.stat = stat;
    }

    public Part() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(int catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getPartProducer() {
        return partProducer;
    }

    public void setPartProducer(String partProducer) {
        this.partProducer = partProducer;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Part(String partName, int catalogNumber, String partProducer, int ilosc,status stat) {
        this.partName = partName;
        this.catalogNumber = catalogNumber;
        this.partProducer = partProducer;
        this.ilosc = ilosc;
        this.stat = stat;
    }
}
