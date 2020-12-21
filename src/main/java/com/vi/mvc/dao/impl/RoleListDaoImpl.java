package com.vi.mvc.dao.impl;

import com.vi.mvc.dao.RoleListDao;
import com.vi.mvc.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleListDaoImpl")
public class RoleListDaoImpl implements RoleListDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));


        return roleList;
    }

    @Override
    public int save(Role role) {
        int update = jdbcTemplate.update("insert  into sys_role values(?,?,?)", null, role.getRoleName(), role.getRoleDesc());
        return update;
    }

    @Override
    public int deleteRole(Role role) {
        int update = jdbcTemplate.update("delete from sys_role where id=?", role.getId());
        return update;
    }



    @Override
    public List<Role> findByidDesc(Long id) {
        List<Role> roles = jdbcTemplate.query("select sr.roleName from sys_user as su join sys_user_role as sur on su.id=sur.userId join sys_role as sr on sur.roleId=sr.id WHERE su.id=?",
                new BeanPropertyRowMapper<Role>(Role.class),id);
        return roles;
    }


}
