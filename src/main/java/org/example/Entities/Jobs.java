package org.example.Entities;

public class Jobs {
    public int jobId, minLvl, maxLvl;
    public String jobDesc;

    public Jobs() {
        this.jobId = 0;
        this.minLvl = 0;
        this.maxLvl = 0;
        this.jobDesc = "";
    }

    public Jobs(int jobId, int minLvl, int maxLvl, String jobDesc) {
        this.jobId = jobId;
        this.minLvl = minLvl;
        this.maxLvl = maxLvl;
        this.jobDesc = jobDesc;
    }
}
