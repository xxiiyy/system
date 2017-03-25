package com.pro.blogL.mapper;

import com.pro.blogL.entrty.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
