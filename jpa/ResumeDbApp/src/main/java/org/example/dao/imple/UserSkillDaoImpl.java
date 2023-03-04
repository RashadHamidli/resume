package org.example.dao.imple;

import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.UserSkillDaoInter;
import org.example.entity.Skill;
import org.example.entity.User;
import org.example.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userSkillId = rs.getInt("userSkillId");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        UserSkill us = new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
        return us;
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        List<UserSkill> list = new ArrayList<>();
        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("SELECT "
                    + " us.id AS userSkillId, "
                    + " u.*, "
                    + " us.skill_id, s.NAME AS Skill_name , "
                    + " us.power "
                    + " FROM "
                    + " user_skill us "
                    + " LEFT JOIN USER u ON us.user_id = u.id "
                    + " LEFT JOIN skill s ON us.skill_id = s.id "
                    + " WHERE us.user_id=? ");
            stmt.setInt(1, id);
            stmt.execute();
            
            ResultSet rs = stmt.getResultSet();
            
            while (rs.next()) {
                UserSkill us = getUserSkill(rs);
                list.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
        boolean b = true;
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user_skill (skill_id , user_id , power) values (?,?,?) ");
            stmt.setInt(1, u.getSkillId().getId());
            stmt.setInt(2, u.getUserId().getId());
            stmt.setInt(3, u.getPower());
            b = stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        boolean b = true;
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user_skill set skill_id=?, user_id=?, power=? where id=?");
            stmt.setInt(1, u.getSkillId().getId());
            stmt.setInt(2, u.getUserId().getId());
            stmt.setInt(3, u.getPower());
            stmt.setInt(4, u.getId());

            b = stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeUser(int id) {
        boolean b = true;
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from user_skill where id=?");

            stmt.setInt(1, id);

            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
