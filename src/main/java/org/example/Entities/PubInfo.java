package org.example.Entities;

public class PubInfo {
    public String pubId;
    public byte[] lo;
    public String prInfo;

    public PubInfo() {
        this.pubId = "";
        this.lo=null;
        this.prInfo = "";
    }

    public PubInfo(String pubId, byte[] lo, String prInfo) {
        this.pubId = pubId;
        this.lo = lo;
        this.prInfo = prInfo;
    }
}
