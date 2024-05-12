package org.example.Entities;

import java.time.LocalDate;

public class Employee {
    public String empId, fName, minIt, lName, pubId;
    public int jobId, jobLvl;
    public LocalDate hireDate;

    public Employee() {
        this.empId = "";
        this.fName = "";
        this.minIt = "";
        this.lName = "";
        this.pubId = "";
        this.jobId = 0;
        this.jobLvl = 0;
        this.hireDate = null;
    }

    public Employee(String empId, String fName, String minIt, String lName, String pubId, int jobId, int jobLvl, LocalDate hireDate) {
        this.empId = empId;
        this.fName = fName;
        this.minIt = minIt;
        this.lName = lName;
        this.pubId = pubId;
        this.jobId = jobId;
        this.jobLvl = jobLvl;
        this.hireDate = hireDate;
    }
}
