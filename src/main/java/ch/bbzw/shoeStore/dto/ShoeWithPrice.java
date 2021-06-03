package ch.bbzw.shoeStore.dto;

import ch.bbzw.shoeStore.model.Price;
import ch.bbzw.shoeStore.model.Shoe;

import java.util.Date;

public class ShoeWithPrice {
    private final String name;
    private final String size;
    private final Date realse_date;
    private final Integer inventory;
    private final Price price;

    public ShoeWithPrice(final String name, final String size, final Date realse_date, final Integer inventory, final Price price) {
        this.name = name;
        this.size = size;
        this.realse_date = realse_date;
        this.inventory = inventory;
        this.price = price;
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

    public Price getPrice() {
        return price;
    }
}
