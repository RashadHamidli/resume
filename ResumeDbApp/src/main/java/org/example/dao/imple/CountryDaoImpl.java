package org.example.dao.imple;

import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.CountryDaoInter;
import org.example.entity.Country;

import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        return null;
    }
}
