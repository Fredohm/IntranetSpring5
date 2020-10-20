package com.iepscf.fredohm.dao.impl;

import com.iepscf.fredohm.dao.RoleDao;
import com.iepscf.fredohm.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Role> getRoles() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Role> query = currentSession.createQuery("from Role ");

        return query.getResultList();
    }

    @Override
    public Role findRoleByName(String roleName) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Role> query = currentSession.createQuery("from Role where name=:roleName");
        query.setParameter("roleName", roleName);

        Role role = null;

        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            role = null;
        }

        return role;
    }
}
