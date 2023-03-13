package com.company.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    public Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        Country country = new Country(id, name, nationality);
        return country;
    }

    @Override
    public List<Country> getAll() {
        List<Country> list = new ArrayList<>();
        try(Connection connection=connect()){
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
        try(Connection connection=connect()){
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
        boolean b = true;
       try(Connection connection=connect()){ 
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
        try(Connection connection=connect()) {
            PreparedStatement stmt = connection.prepareStatement("delete from country where id=?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
