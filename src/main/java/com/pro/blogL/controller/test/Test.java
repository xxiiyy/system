package com.pro.blogL.controller.test;


import com.pro.blogL.dto.MenuBar;
import com.pro.blogL.entrty.Menu;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.MenuServiceImpl;
import com.pro.blogL.service.Impl.RoleServiceImpl;
import com.pro.blogL.service.Impl.UserServiceImpl;
import com.pro.blogL.util.MenuUtils;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhd on 2017/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-mvc.xml","classpath:spring/spring-service.xml"})
public class Test {

    @Resource
    private RoleServiceImpl roleService;

    @Resource
    private MenuServiceImpl menuService;

    @Resource
    private UserServiceImpl userService;

    @org.junit.Test
    public void test(){
        User user = userService.queryUserByLoginName("admin");
        int roleid = roleService.queryRoleIdByRoleType(user.getRoleType());
        List<Integer> menuid = menuService.queryMenusByRoleType(roleid);
        List<Menu> menus = new ArrayList<Menu>();
        for (Integer id:menuid){
            Menu menu = menuService.queryMenuByMenuId(id);
            menus.add(menu);
        }
        List<Menu> pMenus = MenuUtils.init(menus);
        MenuUtils.recursion(pMenus,menus);
        System.out.println(menus);
        System.out.println(pMenus);
    }

    @org.junit.Test
    public void test1(){

        String nodes = "z1,2,3,4,5,6,7,1001,10021";
        String[] ids = nodes.substring(1,nodes.length()-1).split(",");
        roleService.updateNodes(ids,2);
    }




}
