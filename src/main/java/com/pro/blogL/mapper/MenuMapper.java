package com.pro.blogL.mapper;

import com.pro.blogL.dto.MenuBar;
import com.pro.blogL.entrty.Menu;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lhd on 2017/3/24.
 * @author lhd
 */

public interface MenuMapper {

    /**
     * 获取可以使用的menu
     * @return
     */
    public List<Menu> queryAllMenu();

    /**
     * ztree权限管理数据
     * @return
     */
    public List<MenuBar> queryAllMenuBar();

    /**
     * 根据roletype查询menu
     * @param roleId
     * @return
     */
    List<Integer> queryMenusByRoleType(@Param("roleId") int roleId);

    /**
     * 根据menuid查询menu
     * @param menuId
     * @return
     */
    Menu queryMenuByMenuId(@Param("menuId") Integer menuId);

    /**
     * 可以获取到数据menu is_show为false的数据
     * @param menuId
     * @return
     */
    Menu queryMenuByMenuIdAShow(@Param("menuId") Integer menuId);

    /**
     * 添加menu
     * @param menu
     * @return
     */
    Integer insertMenu(Menu menu);

    /**
     * 更新整个menu
     * @param menu
     * @return
     */
    Integer updateMenu(Menu menu);
}
