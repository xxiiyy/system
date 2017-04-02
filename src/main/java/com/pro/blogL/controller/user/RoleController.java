package com.pro.blogL.controller.user;

import com.pro.blogL.controller.sys.BaseController;
import com.pro.blogL.dto.MenuBar;
import com.pro.blogL.entrty.Menu;
import com.pro.blogL.entrty.Role;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.MenuServiceImpl;
import com.pro.blogL.service.Impl.RoleServiceImpl;
import com.pro.blogL.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping(value = "/roleList")
    public String userList(Model model){
        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        return "user/roleList";
    }

    @RequestMapping(value = "/menus/{roleType}")
    @ResponseBody
    public List<MenuBar> roleType(@PathVariable("roleType") String roleType){
        int roleId = roleService.queryRoleIdByRoleType(roleType);
        List<Integer> ids = menuService.queryMenusByRoleType(roleId);
        List<MenuBar> menuBars = menuService.queryAllMenuBar();
        for (MenuBar menuBar : menuBars){
            for (Integer id : ids){
                if(id.intValue() == menuBar.getId()){
                    menuBar.setChecked(true);
                }
            }
        }
        return menuBars;
    }

    @RequestMapping(value = "/updateNodes/{roleType}")
    @ResponseBody
    public void updateNodes(@RequestBody String nodess,@PathVariable String roleType){
        int roleId = roleService.queryRoleIdByRoleType(roleType);
        String[] ids = nodess.substring(1,nodess.length()-1).split(",");
        roleService.updateNodes(ids,roleId);
    }

}
