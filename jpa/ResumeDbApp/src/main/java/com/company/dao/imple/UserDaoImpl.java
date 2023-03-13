package com.company.dao.imple;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.sql.Date;
import java.util.List;


public class UserDaoImpl extends AbstractDAO implements UserDaoInter {


    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profileDesc = rs.getString("profile_description");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");
        String address = rs.getString("address");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthPlaceStr, null);

        return new User(id, name, surname, phone, email, profileDesc,birthdate, nationality, birthplace, address);
    }

    private User getUserSimple(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profileDesc = rs.getString("profile_description");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        Date birthdate = rs.getDate("birthdate");
        String address = rs.getString("address");

        User user = new User(id, name, surname, phone, email, profileDesc, (java.sql.Date) birthdate, null, null, address);
        user.setPassword(rs.getString("password"));
        return user;
    }


    @Override
    public User findByEmailAndPassword(String email, String password) {

        EntityManager em=em();
        Query q=em.createQuery("select u from User u where u.email=:e and u.password=:p ", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);

        List<User> list=q.getResultList();

       if(list.size()==1){
           return list.get(0);
       }
       return null;
    }
    @Override
    public User findByEmail(String email) {
        EntityManager em=em();
        Query q=em.createQuery("select u from User u where u.email=:e ", User.class);
        q.setParameter("e", email);

        List<User> list=q.getResultList();

        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        EntityManager em=em();
        String jpql="select u from User u where 1=1 ";

            if (name != null && name.trim().isEmpty()) {
                jpql += " and u.name=:name ";
            }
            if (surname != null && surname.trim().isEmpty()) {
                jpql += " and u.surname=:surname ";
            }
            if (nationalityId != null) {
                jpql += " and u.nationality.id=:nid ";
            }
            Query query=em.createQuery(jpql, User.class);
            if (name != null && name.trim().isEmpty()) {
                query.setParameter("name", name);
            }
            if (surname != null && surname.trim().isEmpty()) {
                query.setParameter("surname", surname);
            }
            if (nationalityId != null) {
                query.setParameter("nid", nationalityId);
            }

        return query.getResultList();
    }


    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?, surname=?, phone=?, email=?, profile_description=?, birthdate=?, address=?, birthplace_id=?, nationality_id=?, password=?  where id =?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDescription());
            stmt.setDate(6, (Date) u.getBirthdate());
            stmt.setString(7, u.getAddress());
            stmt.setInt(8, u.getBirthplaceId().getId());
            stmt.setInt(9, u.getNationalityId().getId());
            stmt.setInt(10, u.getId());
            stmt.setString(11, u.getPassword());

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

    private static BCrypt.Hasher cyrpt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name, surname, phone, email, password, profile_description, address) values(?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, cyrpt.hashToString(4, u.getPassword().toCharArray()));
            stmt.setString(6, u.getProfileDescription());
            stmt.setString(7, u.getAddress());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }




}
