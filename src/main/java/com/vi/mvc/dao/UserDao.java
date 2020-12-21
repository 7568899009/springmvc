package com.vi.mvc.dao;

import com.vi.mvc.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    long save(User user);

    void UserRelationship(long userId, Long[] roles);

    void deleteUsers(Long userId);

    void deleteRelation(Long userId);

    User login(User user) throws Exception;
}
