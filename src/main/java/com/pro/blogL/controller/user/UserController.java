package com.pro.blogL.controller.user;

import com.pro.blogL.controller.sys.BaseController;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by lhd on 2017/3/23.
 * @author lhd
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController{

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/userList")
    public String userList(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startNo",0);
        map.put("pageSize",100);
        List<User> users = userService.queryAllUser(map);
        model.addAttribute("userList",users);
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "user/userList";
    }

}
