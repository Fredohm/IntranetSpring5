package com.iepscf.fredohm.dao;

import com.iepscf.fredohm.entity.Role;

import java.util.List;

public interface RoleDao  {

    List<Role> getRoles();

    Role findRoleByName(String roleName);
}
