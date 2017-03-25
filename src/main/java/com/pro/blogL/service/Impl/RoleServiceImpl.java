package com.pro.blogL.service.Impl;

import com.pro.blogL.entrty.Role;
import com.pro.blogL.mapper.RoleMapper;
import com.pro.blogL.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lhd on 2017/3/25.
 * @author lhd
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    public List<Role> queryAllRole() {
        return roleMapper.queryAllRole();
    }

    public int queryRoleIdByRoleType(String roleType) {
        return roleMapper.queryRoleIdByRoleType(roleType);
    }
}
