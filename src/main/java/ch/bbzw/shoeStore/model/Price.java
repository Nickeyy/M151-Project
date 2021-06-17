package ch.bbzw.shoeStore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Price implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_sequence")
    @SequenceGenerator(allocationSize = 1, name = "price_sequence")
    @Column(nullable = false, updatable = false)
    private long price_id;

    @Column(nullable = false)
    private float price;

    protected Price() {
    }

    public Price(final float price) {
        this.price = price;
    }

    public long getPrice_id() {
        return price_id;
    }

    public float getPrice() {
        return price;
    }
}
