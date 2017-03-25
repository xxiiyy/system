package com.pro.blogL.controller.sys;

import com.pro.blogL.entrty.Menu;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.MenuServiceImpl;
import com.pro.blogL.service.Impl.RoleServiceImpl;
import com.pro.blogL.service.Impl.UserServiceImpl;
import com.pro.blogL.util.EncryptUtil;
import com.pro.blogL.util.MenuUtils;
import com.pro.blogL.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by lhd on 2017/3/23.
 * @author lhd
 */
@Controller
public class BaseController {

    @Autowired
    private UserServiceImpl userService;

    @Resource
    private RoleServiceImpl roleService;

    @Resource
    private MenuServiceImpl menuService;



    /**
     * 测试数据
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public User test(){
        User user = userService.queryUserByLoginName("root");
        return user;
    }

    /**
     * 首路径
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String base(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("menus",getMenus(user.getLoginName()));
        model.addAttribute("user", user);
        return "index";
    }



    /**
     * 判断shiro是否验证抛出异常，没异常就认证成功
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request){
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if(exceptionClassName != null){
            if(UnknownAccountException.class.getName().equals(exceptionClassName)){
                model.addAttribute("errorMsg", "用户名不存在");
            }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
                model.addAttribute("errorMsg", "用户名/密码不正确");
            }else {
                model.addAttribute("errorMsg", "未知异常");
            }
        }
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        return "login";
    }

    /**
     * 跳到注册页面
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        return "register";
    }

    /**
     * 跳到忘记密码页面
     * @return
     */
    @RequestMapping(value = "/forgot",method = RequestMethod.GET)
    public String forgot(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        return "forgot";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/logout",method = {RequestMethod.GET,RequestMethod.POST})
    public String logout(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        return "login";
    }

    /**
     * 注册用户：自己注册默认是游客，对于后台没有操作权限
     *
     * @return
     */
    @RequestMapping(value = "/registerMethod")
    public String registerMethod(Model model, User user){
        Subject subject = SecurityUtils.getSubject();
        User user1 = (User) subject.getPrincipal();
        model.addAttribute("user",user1);
        user.setCreateTime(new Date());
        user.setId(StringUtils.getUUID());
        user.setRoleType("customer");
        user.setSalt(StringUtils.getUUID());
        String passwordSalt = EncryptUtil.md5(user.getPassword(),user.getSalt());
        user.setPassword(passwordSalt);
        userService.insertUser(user);
        return "login";
    }

    /**
     * 进入首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "index";
    }

    /**
     * 转到tables页面
     * @param model
     * @return
     */
    @RequestMapping(value = "tables")
    public String tables(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "tables";
    }

    /**
     * 转到charts页面
     * @param model
     * @return
     */
    @RequestMapping(value = "charts")
    public String charts(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "charts";
    }

    /**
     * 转到forms页面
     * @param model
     * @return
     */
    @RequestMapping(value = "forms")
    public String forms(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "forms";
    }

    /**
     * 转到panels页面
     * @param model
     * @return
     */
    @RequestMapping(value = "panels")
    public String panels(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "panels";
    }
    /**
     * 转到widgets页面
     * @param model
     * @return
     */
    @RequestMapping(value = "widgets")
    public String widgets(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("menus",getMenus(user.getLoginName()));
        return "widgets";
    }


    /**
     * 获取整个menu菜单
     * @param loginName
     * @return
     */
    public List<Menu> getMenus(String loginName){
        User user = userService.queryUserByLoginName(loginName);
        int roleId = roleService.queryRoleIdByRoleType(user.getRoleType());
        List<Integer> menuId = menuService.queryMenusByRoleType(roleId);
        List<Menu> menus = new ArrayList<Menu>();
        for (Integer id : menuId){
            Menu menu = menuService.queryMenuByMenuId(id);
            if(menu!=null) menus.add(menu);
        }
        List<Menu> pMenus = MenuUtils.init(menus);
        MenuUtils.recursion(pMenus,menus);
        return pMenus;
    }


}
