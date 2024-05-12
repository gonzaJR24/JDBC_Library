package org.example.Entities;

public class Discounts {
   public String discountType, storeId;
    public int lowQty, highQty;
    public double discount;

    public Discounts() {
        this.discountType = "";
        this.storeId = "";
        this.lowQty = 0;
        this.highQty = 0;
        this.discount = 0;
    }

    public Discounts(String discountType, String storeId, int lowQty, int highQty, double discount) {
        this.discountType = discountType;
        this.storeId = storeId;
        this.lowQty = lowQty;
        this.highQty = highQty;
        this.discount = discount;
    }
}
