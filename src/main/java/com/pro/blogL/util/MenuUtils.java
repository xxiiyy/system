package com.pro.blogL.util;

import com.pro.blogL.entrty.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhd on 2017/3/25.
 * @author lhd
 */
public class MenuUtils {

    /**
     * 初始化获取到的菜单数据
     * @param menus
     * @return
     */
    public static List<Menu> init(List<Menu> menus){
        List<Menu> pmenus = new ArrayList<Menu>();
        for (Menu menu:menus){
            if(menu.getpId() == 0){
                pmenus.add(menu);
            }
        }
        menus.removeAll(pmenus);
        return pmenus;
    }

    /**
     * 递归将初始化的menu，组合到一起
     * @param pmenus
     * @param menus
     * @return
     */
    public static List<Menu> recursion(List<Menu> pmenus,List<Menu> menus){
        for (Menu pmenu : pmenus){
            List<Menu> list = new ArrayList<Menu>();
            for (Menu menu : menus){
                if(pmenu.getId() == menu.getpId()){
                    list.add(menu);
                }
            }
            menus.removeAll(list);
            list = recursion(list,menus);
            if(list.size()!=0)
                pmenu.setChildMenus(list);
        }
        return pmenus;
    }

}
