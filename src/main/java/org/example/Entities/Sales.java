package org.example.Entities;
import java.time.LocalDate;

public class Sales {

    public String storeId, ordNum,payterms, titleId;
    public LocalDate orderDate;
    public int qty;

    public Sales() {
        this.storeId = "";
        this.ordNum = "";
        this.payterms = "";
        this.titleId = "";
        this.orderDate = null;
        this.qty = 0;
    }

    public Sales(String storeId, String ordNum, String payterms, String titleId, LocalDate orderDate, int qty) {
        this.storeId = storeId;
        this.ordNum = ordNum;
        this.payterms = payterms;
        this.titleId = titleId;
        this.orderDate = orderDate;
        this.qty = qty;
    }
}
