package com.pro.blogL.service.Impl;

import com.pro.blogL.dto.MenuBar;
import com.pro.blogL.entrty.Menu;
import com.pro.blogL.mapper.MenuMapper;
import com.pro.blogL.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lhd on 2017/3/25.
 * @author lhd
 */
@Service
public class MenuServiceImpl implements MenuService{


    @Resource
    private MenuMapper menuMapper;

    public List<Menu> queryAllMenu() {
        return menuMapper.queryAllMenu();
    }

    public List<MenuBar> queryAllMenuBar() {
        return menuMapper.queryAllMenuBar();
    }


    public List<Integer> queryMenusByRoleType(@Param("roleId") int roleId) {
        return menuMapper.queryMenusByRoleType(roleId);
    }

    public Menu queryMenuByMenuId(Integer menuId) {
        return menuMapper.queryMenuByMenuId(menuId);
    }

    public Menu queryMenuByMenuIdAShow(Integer menuId) {
        return menuMapper.queryMenuByMenuIdAShow(menuId);
    }

    public Integer updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    public Integer insertMenu(Menu menu) {
        return menuMapper.insertMenu(menu);
    }
}
