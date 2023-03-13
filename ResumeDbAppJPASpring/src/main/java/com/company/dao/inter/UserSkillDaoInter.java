package com.company.dao.inter;

import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int id);
    public boolean insertUserSkill(UserSkill u);
    public boolean updateUserSkill(UserSkill u);
    public boolean removeUser(int id);
}
