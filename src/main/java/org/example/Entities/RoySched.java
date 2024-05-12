package org.example.Entities;

public class RoySched {
    public String titleId;
    public int lorange, hirange, royalty;

    public RoySched() {
        this.titleId = "";
        this.lorange = 0;
        this.hirange = 0;
        this.royalty = 0;
    }

    public RoySched(String titleId, int lorange, int hirange, int royalty) {
        this.titleId = titleId;
        this.lorange = lorange;
        this.hirange = hirange;
        this.royalty = royalty;
    }
}
