package com.pro.blogL.controller.user;

import com.pro.blogL.controller.sys.BaseController;
import com.pro.blogL.entrty.Role;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.RoleServiceImpl;
import com.pro.blogL.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping(value = "/userList")
    public String userList(Model model){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startNo",0);
        map.put("pageSize",100);
        List<User> users = userService.queryAllUser(map);
        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("userList",users);
        return "user/userList";
    }

    @RequestMapping(value = "/update/{loginName}")
    @ResponseBody
    public User update(@PathVariable("loginName") String loginName){
        User user = userService.queryUserByLoginName(loginName.trim());
        return user;
    }

    @RequestMapping(value = "/updateSubmit")
    public String updateSubmit(Model model,User user){
        userService.updateUserByLoginName(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startNo",0);
        map.put("pageSize",100);
        List<User> users = userService.queryAllUser(map);
        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("userList",users);
        return "user/userList";
    }

    @RequestMapping(value = "/deleteUser/{loginName}")
    public String deleteUser(Model model,@PathVariable("loginName") String loginName){
        userService.deleteUserByLoginName(loginName);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startNo",0);
        map.put("pageSize",100);
        List<User> users = userService.queryAllUser(map);
        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("userList",users);
        return "user/userList";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(Model model,User user){
        user = insert(user,user.getRoleType());
        userService.insertUser(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startNo",0);
        map.put("pageSize",100);
        List<User> users = userService.queryAllUser(map);
        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("userList",users);
        return "user/userList";
    }


}
