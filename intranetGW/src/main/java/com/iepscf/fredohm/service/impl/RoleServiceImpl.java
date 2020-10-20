package com.iepscf.fredohm.service.impl;

import com.iepscf.fredohm.dao.RoleDao;
import com.iepscf.fredohm.entity.Role;
import com.iepscf.fredohm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    @Transactional
    public Role findRoleByName(String roleName) {
        return roleDao.findRoleByName(roleName);
    }
}
