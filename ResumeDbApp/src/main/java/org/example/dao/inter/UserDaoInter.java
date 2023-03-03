package org.example.dao.inter;

import org.example.entity.User;

import java.util.List;

public interface UserDaoInter {
    public User findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User getById(int id);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(int id);

}
