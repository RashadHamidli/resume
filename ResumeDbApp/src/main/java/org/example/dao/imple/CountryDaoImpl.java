package org.example.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.CountryDaoInter;
import org.example.entity.Country;

import java.util.List;
import org.example.entity.User;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    public Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        Country country = new Country(id, name, nationality);
        System.out.println(country);
        return country;
    }

    @Override
    public List<Country> getAll() {
        List<Country> list = new ArrayList<>();
        Connection connection;
        try {
            connection = connect();
            Statement stmt = connection.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country country = getCountry(rs);
                list.add(country);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Country getById(int userId) {
        Country country = null;
        Connection connection;
        try {
            connection = connect();
            PreparedStatement stmt = connection.prepareStatement("select * from country where id=?");
            stmt.setInt(1, userId);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                country = getCountry(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return country;
    }

    public boolean updateCountry(Country u) {
        Connection connection;
        boolean b = true;
        try {
            connection = connect();
            PreparedStatement stmt = connection.prepareStatement("update country set name=?, nationality=?, where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getNationality());
            stmt.setInt(3, u.getId());
            b = stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeCountry(int id) {
        Connection connection;
        try {
            connection = connect();
            PreparedStatement stmt = connection.prepareStatement("delete from country where id=?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
