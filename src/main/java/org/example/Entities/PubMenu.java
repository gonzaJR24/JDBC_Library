package org.example.Entities;

public class PubMenu {
    public int mnuNum, mnuMaster;
    public String MNU_NAME;

    public PubMenu() {
        this.mnuNum = 0;
        this.mnuMaster = 0;
        this.MNU_NAME = "";
    }

    public PubMenu(int mnuNum, int mnuMaster, String MNU_NAME) {
        this.mnuNum = mnuNum;
        this.mnuMaster = mnuMaster;
        this.MNU_NAME = MNU_NAME;
    }
}
