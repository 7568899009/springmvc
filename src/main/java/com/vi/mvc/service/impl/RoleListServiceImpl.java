package com.vi.mvc.service.impl;

import com.vi.mvc.dao.RoleListDao;
import com.vi.mvc.entity.Role;
import com.vi.mvc.service.RoleListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleListServiceImpl")
public class RoleListServiceImpl implements RoleListService {
    @Resource(name = "roleListDaoImpl")
    private RoleListDao roleListDao;

    public List<Role> showList() {
        List<Role> all = roleListDao.findAll();
        return all;
    }

    @Override
    public boolean save(Role role) {
        if (role == null) {
            return false;
        }
        int save = roleListDao.save(role);
        if (save == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Role role) {
        roleListDao.deleteRole(role);
        return true;

    }

    @Override
    public List<Role> findByidDesc(Long id) {
        List<Role> roles = roleListDao.findByidDesc(id);
        return roles;
    }
}
