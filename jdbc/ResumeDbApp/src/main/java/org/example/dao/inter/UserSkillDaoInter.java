package org.example.dao.inter;

import org.example.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int id);
    public boolean insertUserSkill(UserSkill u);
    public boolean updateUserSkill(UserSkill u);
    public boolean removeUser(int id);
}
