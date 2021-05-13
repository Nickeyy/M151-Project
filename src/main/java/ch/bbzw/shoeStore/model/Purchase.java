package ch.bbzw.shoeStore.model;

import javax.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_sequence")
    @SequenceGenerator(allocationSize = 1, name = "purchase_sequence")
    @Column(nullable = false, updatable = false)
    private long purchase_id;

    @ManyToOne()
    private Shoe shoe;

    @ManyToOne()
    private User user;

    protected Purchase() {
    }

    public long getPurchase_id() {
        return purchase_id;
    }
}
