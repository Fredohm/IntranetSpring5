package com.iepscf.fredohm.service;

import com.iepscf.fredohm.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role findRoleByName(String roleName);
}
