package ch.bbzw.shoeStore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Shoe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoe_sequence")
    @SequenceGenerator(allocationSize = 1, name = "shoe_sequence")
    @Column(nullable = false, updatable = false)
    private long shoe_id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Price price;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private Date realse_date;

    @Column(nullable = false)
    private Integer inventory;

    protected Shoe() {
    }

    public Shoe(final String name, final String size, final Date realse_date, final Integer inventory, final Price price) {
        this.name = name;
        this.size = size;
        this.realse_date = realse_date;
        this.inventory = inventory;
        this.price = price;
    }

    public long getShoe_id() {
        return shoe_id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public Date getRealse_date() {
        return realse_date;
    }

    public Integer getInventory() {
        return inventory;
    }

    public Price getPrice() {return  price; }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setRealse_date(Date realse_date) {
        this.realse_date = realse_date;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
