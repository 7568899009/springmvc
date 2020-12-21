package com.vi.mvc.dao;

import com.vi.mvc.entity.Role;

import java.util.List;

public interface RoleListDao {
    List<Role> findAll();

    int save(Role role);

    int deleteRole(Role role);


    List<Role> findByidDesc(Long id);
}
