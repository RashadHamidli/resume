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

        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName=rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);

    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("SELECT\n" +
                    "\tu.*,\n" +
                    "\tus.skill_id,\n" +
                    "\ts.NAME AS skill_name,\n" +
                    "\tus.power \n" +
                    "FROM\n" +
                    "\tuser_skill us\n" +
                    "\tLEFT JOIN USER u ON us.user_id = u.id\n" +
                    "\tLEFT JOIN skill s ON us.skill_id = s.id \n" +
                    "WHERE\n" +
                    "\tus.user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
