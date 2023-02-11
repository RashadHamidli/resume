package org.example.dao.inter;

import org.example.entity.Country;
import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAll();

    public Country getById(int id);

    public boolean updateCountry(Country u);

    public boolean removeCountry(int id);
}
