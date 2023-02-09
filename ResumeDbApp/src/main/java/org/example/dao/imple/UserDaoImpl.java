package org.example.dao.imple;

import org.example.entity.Country;
import org.example.entity.Skill;
import org.example.entity.User;
import org.example.entity.UserSkill;
import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profileDesc=rs.getString("profile_description");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");
        String address=rs.getString("address");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthPlaceStr, null);

        return new User(id, name, surname, phone, email, profileDesc, (java.sql.Date) birthdate, nationality, birthplace, address);
    }


    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select \n" +
                    "\tu.*,\n" +
                    "\tc.name as birthplace, \n" +
                    "\tn.nationality \n" +
                    "from user u\n" +
                    "left join country n on u.nationality_id=n.id\n" +
                    "left join country c on u.birthplace_id=c.id");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?, surname=?, phone=?, email=?, profile_description=?, birthdate=?, address=?  where id =?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setDate(6, u.getBirthDate());
            stmt.setString(7, u.getAddress());
            stmt.setInt(8, u.getId());
            
            stmt.execute();
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect();) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id =" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }




    @Override
    public User getById(int userId) {

        User result = null;

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select  "
                    + "   u. *,  "
                    + "   n.nationality,  "
                    + "   c.name as birthplace  "
                    + "from user u  "
                    + "left join country n on u.nationality_id=n.id  "
                    + "left join country c on u.birthplace_id=c.id where u.id =" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name, surname, phone, email, profile_description) values(?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
