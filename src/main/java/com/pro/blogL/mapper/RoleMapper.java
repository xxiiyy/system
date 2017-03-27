package com.pro.blogL.mapper;

import com.pro.blogL.entrty.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lhd on 2017/3/24.
 * @author lhd
 */
public interface RoleMapper {

    /**
     * 查询全部的reole
     * @return
     */
    List<Role> queryAllRole();

    /**
     * 根据roletype来查询roleid
     * @param roleType
     * @return
     */
    int queryRoleIdByRoleType(@Param("roleType") String roleType);

    /**
     * 根据roleid来删除对应的rolemenu数据
     * @param roleId
     * @return
     */
    int deleteRoleMenuByRoleId(@Param("roleId") Integer roleId);

    /**
     * 插入rolemenu数据
     * @return
     */
    int insertRoleMenu(Map<String,Object> map);
}
