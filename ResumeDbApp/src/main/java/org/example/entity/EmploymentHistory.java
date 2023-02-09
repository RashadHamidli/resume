package org.example.entity;

import java.util.Date;

public class EmploymentHistory {
    private Integer id;
    private String header;
    private Date beingDate;
    private Date endDate;
    private String jobDescription;
    private User user;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id, String header, Date beingDate, Date endDate, String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beingDate = beingDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", beingDate=" + beingDate +
                ", endDate=" + endDate +
                ", jobDescription='" + jobDescription + '\'' +
                ", user=" + user +
                '}';
    }
}
