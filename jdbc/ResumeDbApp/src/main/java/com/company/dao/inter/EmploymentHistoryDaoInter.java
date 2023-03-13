package com.company.dao.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id);
    public boolean insertEmploymentHistory(EmploymentHistory u);
    public boolean updateEmploymentHistory(EmploymentHistory u);
    public boolean removeEmploymentHistory(int id);
}
