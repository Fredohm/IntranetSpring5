package com.iepscf.fredohm.service.impl;

import com.iepscf.fredohm.dao.RoleDao;
import com.iepscf.fredohm.dao.UserDao;
import com.iepscf.fredohm.entity.Role;
import com.iepscf.fredohm.entity.User;
import com.iepscf.fredohm.service.UserService;
import com.iepscf.fredohm.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    @Transactional
    public void saveUser(UserDto userAddDto) {

        User user = getUser(userAddDto);

        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(UserDto userUpdateDto) {

        User user = getUser(userUpdateDto);

        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userDao.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException(("invalid username or password."));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    private User getUser(UserDto userDto) {

        User user = new User();

        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setRoles(Arrays.asList(roleDao.findRoleByName(userDto.getFormRole().toString())));

        return user;
    }
}
