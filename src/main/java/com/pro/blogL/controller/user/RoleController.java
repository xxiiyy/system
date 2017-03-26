package com.pro.blogL.controller.user;

import com.pro.blogL.controller.sys.BaseController;
import com.pro.blogL.entrty.Role;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.RoleServiceImpl;
import com.pro.blogL.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lhd on 2017/3/25.
 * @author lhd
 */
@Controller
@RequestMapping(value = "role")
public class RoleController extends BaseController{

    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping(value = "/roleList")
    public String userList(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "user/roleList";
    }

}
