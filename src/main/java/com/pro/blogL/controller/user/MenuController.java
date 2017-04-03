package com.pro.blogL.controller.user;

import com.pro.blogL.controller.sys.BaseController;
import com.pro.blogL.dto.Message;
import com.pro.blogL.dto.ResultMessage;
import com.pro.blogL.entrty.Menu;
import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.MenuServiceImpl;
import com.pro.blogL.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String menuList(Model model){
        List<Menu> menuList = menuService.queryAllMenu();
        ResultMessage<Menu> rm = new ResultMessage<Menu>();
        rm.setList(menuList);
        model.addAttribute("rm",rm);
        return "user/menuList";
    }

    @RequestMapping(value = "/menuAdd",method = RequestMethod.POST)
    public String menuAdd(){

        return "user/menuList";
    }

    @RequestMapping(value = "/menuUpdateInfo/{menuId}",method = RequestMethod.POST)
    @ResponseBody
    public Message menuUpdateInfo(@PathVariable("menuId") int menuId){
        Message message = new Message();
        Menu menu = menuService.queryMenuByMenuId(menuId);
        if(menu != null){
            message.setResult(true);
            message.setObject(menu);
        }else {
            message.setResult(false);
        }
        return message;
    }

    @RequestMapping(value = "/menuUpdate")
    public String menuUpdate(Model model,Menu menu){
        menuService.updateMenu(menu);
        List<Menu> menuList = menuService.queryAllMenu();
        ResultMessage<Menu> rm = new ResultMessage<Menu>();
        rm.setList(menuList);
        model.addAttribute("rm",rm);
        return "user/menuList";
    }




}
