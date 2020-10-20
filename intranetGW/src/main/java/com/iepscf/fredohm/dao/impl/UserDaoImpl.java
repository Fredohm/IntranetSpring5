package com.iepscf.fredohm.dao.impl;

import com.iepscf.fredohm.dao.UserDao;
import com.iepscf.fredohm.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getUsers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> query = currentSession.createQuery("from User ");

        return query.getResultList();
    }

    @Override
    public User getUser(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> query = currentSession.createQuery("select u from User u join fetch u.roles where u.id=:id");

        query.setParameter("id", id);

        User user = query.getSingleResult();

        return user;
    }

    @Override
    public User findByUserName(String userName) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> query = currentSession.createQuery("from User where username=:uName");
        query.setParameter("uName", userName);

        User user = null;

        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }

    @Override
    public void saveUser(User user) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(user);
    }

    @Override
    public void updateUser(User user) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.update(user);
    }

    @Override
    public void deleteUser(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from User where id=:userId");

        query.setParameter("userId", id);

        query.executeUpdate();
    }
}
