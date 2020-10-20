package com.iepscf.fredohm.dao;

import com.iepscf.fredohm.entity.User;

import java.util.List;

public interface UserDao {

    User findByUserName(String userName);

    List<User> getUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
