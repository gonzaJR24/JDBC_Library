package org.example.Entities;

import java.io.StringReader;

public class TitleAuthor {
    public String auId, titleId;
    public int auOrd, royalTyper;

    public TitleAuthor() {
        this.auId = "";
        this.titleId = "";
        this.auOrd = 0;
        this.royalTyper = 0;
    }

    public TitleAuthor(String auId, String titleId, int auOrd, int royalTyper) {
        this.auId = auId;
        this.titleId = titleId;
        this.auOrd = auOrd;
        this.royalTyper = royalTyper;
    }
}
