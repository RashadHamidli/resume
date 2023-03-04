/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mr_rashad
 */
@Entity
@Table(name = "employment_history")
@NamedQueries({
    @NamedQuery(name = "EmploymentHistory.findAll", query = "SELECT e FROM EmploymentHistory e"),
    @NamedQuery(name = "EmploymentHistory.findById", query = "SELECT e FROM EmploymentHistory e WHERE e.id = :id"),
    @NamedQuery(name = "EmploymentHistory.findByCompanyName", query = "SELECT e FROM EmploymentHistory e WHERE e.companyName = :companyName"),
    @NamedQuery(name = "EmploymentHistory.findByPosition", query = "SELECT e FROM EmploymentHistory e WHERE e.position = :position"),
    @NamedQuery(name = "EmploymentHistory.findByBeginDate", query = "SELECT e FROM EmploymentHistory e WHERE e.beginDate = :beginDate"),
    @NamedQuery(name = "EmploymentHistory.findByEndDate", query = "SELECT e FROM EmploymentHistory e WHERE e.endDate = :endDate")})
public class EmploymentHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "job_description")
    private String jobDescription;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id) {
        this.id = id;
    }


    public EmploymentHistory(Integer id, String companyName, String position, Date beginDate, Date endDate, String jobDescription, User userId) {
        this.id = id;
        this.companyName = companyName;
        this.position = position;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.userId = userId;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmploymentHistory)) {
            return false;
        }
        EmploymentHistory other = (EmploymentHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.example.entity.EmploymentHistory[ id=" + id + " ]";
    }
    
}
