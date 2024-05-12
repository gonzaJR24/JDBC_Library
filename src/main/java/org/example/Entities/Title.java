package org.example.Entities;

import java.time.LocalDate;

public class Title {
    public String titleId, title, type, pubId, notes;
    public double price, advance;
    public int royalty, ytdSales;
    public LocalDate pubDate;

    public Title() {
        this.titleId = "";
        this.title = "";
        this.type = "";
        this.pubId = "";
        this.notes = "";
        this.price = 0;
        this.advance = 0;
        this.royalty = 0;
        this.ytdSales = 0;
        this.pubDate = null;
    }

    public Title(String titleId, String title, String type, String pubId, String notes, double price, double advance, int royalty, int ytdSales, LocalDate pubDate) {
        this.titleId = titleId;
        this.title = title;
        this.type = type;
        this.pubId = pubId;
        this.notes = notes;
        this.price = price;
        this.advance = advance;
        this.royalty = royalty;
        this.ytdSales = ytdSales;
        this.pubDate = pubDate;
    }
}
