package com.pro.blogL.service;

import com.pro.blogL.entrty.Role;

import java.util.List;

/**
 * Created by lhd on 2017/3/25.
 * @author lhd
 */
public interface RoleService {

    List<Role> queryAllRole();

    int queryRoleIdByRoleType(String roleType);

}
