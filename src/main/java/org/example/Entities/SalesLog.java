package org.example.Entities;

import java.time.LocalDate;

public class SalesLog {
    public String storeId, ordNum, titleId, auId;
    public int salesLogId, quantity;
    public double price;
    public LocalDate logFecha;

    public SalesLog() {
    }

    public SalesLog(String storeId, String ordNum, String titleId, String auId, int salesLogId, int quantity, double price, LocalDate logFecha) {
        this.storeId = "";
        this.ordNum = "";
        this.titleId = "";
        this.auId = "";
        this.salesLogId = 0;
        this.quantity = 0;
        this.price = 0;
        this.logFecha = null;
    }
}
