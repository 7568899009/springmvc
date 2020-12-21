package com.vi.mvc.service;

import com.vi.mvc.entity.Role;
import com.vi.mvc.entity.User;

import java.util.List;

public interface UserService {
    List<User> showList();

    List<Role> showUI();

    void save(User user, Long[] roles);

    void deleteUser(Long userId);


    User login(User user);
}
