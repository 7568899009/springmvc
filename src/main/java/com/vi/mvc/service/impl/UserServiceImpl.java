package com.vi.mvc.service.impl;

import com.vi.mvc.dao.UserDao;
import com.vi.mvc.entity.Role;
import com.vi.mvc.entity.User;
import com.vi.mvc.service.RoleListService;
import com.vi.mvc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDaoImpl")
    private UserDao userDao;
    @Resource(name = "roleListServiceImpl")
    private RoleListService roleListService;
    @Resource(name = "userEntity")
    private User user;
    @Override
    public List<User> showList() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            List<Role> roles = roleListService.findByidDesc(user.getId());
            user.setRoles(roles);
        }
        return users;
    }

    @Override
    public List<Role> showUI() {
        List<Role> roles = roleListService.showList();
        return roles;
    }

    @Override
    public void save(User user, Long[] roles) {
        long userId = userDao.save(user);
        userDao.UserRelationship(userId,roles);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteRelation(userId);
        userDao.deleteUsers(userId);
    }

    @Override
    public User login(User user) {
        if (user == null) {
            return null;
        }
        User users = null;
        try {
            users = userDao.login(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }


}
