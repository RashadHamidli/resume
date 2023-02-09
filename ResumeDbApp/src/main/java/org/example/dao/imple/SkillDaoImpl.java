package org.example.dao.imple;

import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.SkillDaoInter;
import org.example.entity.Skill;

import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        return null;
    }
}
