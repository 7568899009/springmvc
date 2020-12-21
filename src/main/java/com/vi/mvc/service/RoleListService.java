package com.vi.mvc.service;

import com.vi.mvc.entity.Role;

import java.util.List;

public interface RoleListService {

    List<Role> showList();

    boolean save(Role role);

    boolean delete(Role role);

    List<Role> findByidDesc(Long id);
}
