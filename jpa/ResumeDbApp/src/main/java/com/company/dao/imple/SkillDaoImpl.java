package com.company.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.AbstractDAO;
import com.company.entity.Skill;

import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    public Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        Skill skill = new Skill(id, name);
        return skill;
    }

    @Override
    public List<Skill> getAll() {

        List<Skill> list = new ArrayList<>();
        try ( Connection connection = connect()) {
            Statement stmt = connection.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Skill skill = getSkill(rs);
                list.add(skill);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }



    @Override
    public Skill getById(int userId) {
        Skill skill = null;
        try ( Connection connection = connect()) {
            PreparedStatement stmt = connection.prepareStatement("select * from skill where id=?");
            stmt.setInt(1, userId);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                skill = new Skill(id, name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skill;
    }

    @Override
    public boolean updateSkill(Skill u) {
        boolean b = true;
        try ( Connection connection = connect()) {
            PreparedStatement stmt = connection.prepareStatement("update skill set name=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setInt(2, u.getId());
            b = stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeSkill(int id) {
        try ( Connection connection = connect()) {
            PreparedStatement stmt = connection.prepareStatement("delete from skill where id=?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Skill> getByName(String sname) {
        List<Skill> list = new ArrayList<>();

        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from skill where name like ?");
            stmt.setString(1, sname);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new Skill(id, name));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insertSkill(Skill skl) {
        boolean b = true;
        try ( Connection connection = connect()) {
            PreparedStatement stmt = connection.prepareStatement("insert skill (name) values (?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, skl.getName());
            b = stmt.execute();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                skl.setId(generatedKeys.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            b= false;
        }
        return b;
    }
}
