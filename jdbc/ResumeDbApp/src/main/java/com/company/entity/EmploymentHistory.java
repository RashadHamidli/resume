package com.company.entity;

import java.util.Date;

public class EmploymentHistory {
    private Integer id;
    private String companyName;
    private String position;
    private Date beingDate;
    private Date endDate;
    private String jobDescription;
    private User user;

    public EmploymentHistory() {
    }
    
    

    public EmploymentHistory(Integer id, String companyName, String position, Date beingDate, Date endDate, String jobDescription, User user) {
        this.id = id;
        this.companyName = companyName;
        this.position = position;
        this.beingDate = beingDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user = user;
    }

    public EmploymentHistory(String companyName, String position, Date beingDate, Date endDate, String jobDescription) {
        this.companyName = companyName;
        this.position = position;
        this.beingDate = beingDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBeingDate() {
        return beingDate;
    }

    public void setBeingDate(Date beingDate) {
        this.beingDate = beingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" + "id=" + id + ", companyName=" + companyName + ", position=" + position + ", beingDate=" + beingDate + ", endDate=" + endDate + ", jobDescription=" + jobDescription + ", user=" + user + '}';
    }

    

   

   
}
