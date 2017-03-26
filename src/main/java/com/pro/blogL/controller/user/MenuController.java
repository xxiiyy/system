package com.pro.blogL.controller.user;

import com.pro.blogL.controller.sys.BaseController;
import com.pro.blogL.entrty.Menu;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.MenuServiceImpl;
import com.pro.blogL.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lhd on 2017/3/25.
 * @author lhd
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController extends BaseController{


    @Resource
    private MenuServiceImpl menuService;

    @RequestMapping(value = "/menuList")
    public String userList(Model model){
        List<Menu> menuList = menuService.queryAllMenu();
        model.addAttribute("user",getNowUser());
        model.addAttribute("menuList",menuList);
        model.addAttribute("menus",getMenus(getNowUser().getLoginName()));
        return "user/menuList";
    }

}
