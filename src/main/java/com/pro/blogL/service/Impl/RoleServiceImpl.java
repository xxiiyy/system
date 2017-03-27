package com.pro.blogL.service.Impl;

import com.pro.blogL.entrty.Role;
import com.pro.blogL.mapper.RoleMapper;
import com.pro.blogL.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional
    public int updateNodes(String[] ids, int roleId) {
        Map<String,Object> map = new HashMap<String,Object>();
        roleMapper.deleteRoleMenuByRoleId(roleId);
        for (String id : ids){
            map.put("roleId",roleId);
            map.put("menuId",Integer.parseInt(id));
            roleMapper.insertRoleMenu(map);
        }
        return 0;
    }
}
