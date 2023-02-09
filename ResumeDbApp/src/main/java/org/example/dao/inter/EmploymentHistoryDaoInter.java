package org.example.dao.inter;

import org.example.entity.EmploymentHistory;
import org.example.entity.UserSkill;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
}
