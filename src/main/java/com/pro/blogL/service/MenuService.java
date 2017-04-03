package com.pro.blogL.service;

import com.pro.blogL.dto.MenuBar;
import com.pro.blogL.entrty.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lhd on 2017/3/25.
 * @author lhd
 */
public interface MenuService {

    public List<Menu> queryAllMenu();

    public List<MenuBar> queryAllMenuBar();

    List<Integer> queryMenusByRoleType(int roleId);

    Menu queryMenuByMenuId(Integer menuId);

    Menu queryMenuByMenuIdAShow(Integer menuId);

    Integer insertMenu(Menu menu);

    Integer updateMenu(Menu menu);

}
