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

    public Purchase(Shoe shoe, User user) {
        this.user = user;
        this.shoe = shoe;
    }

    protected Purchase() {

    }


    public long getPurchase_id() {
        return purchase_id;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public User getUser() {
        return user;
    }
}
