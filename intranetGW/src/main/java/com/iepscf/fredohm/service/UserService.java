package com.iepscf.fredohm.service;

import com.iepscf.fredohm.entity.User;
import com.iepscf.fredohm.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String username);

    List<User> getUsers();

    User getUser(int id);

    void saveUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(int id);

}
