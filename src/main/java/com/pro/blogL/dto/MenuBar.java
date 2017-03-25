package com.pro.blogL.dto;

import com.pro.blogL.entrty.Menu;

/**
 * Created by lhd on 2017/3/24.
 * @author lhd
 */
public class MenuBar extends Menu {


    private Menu menu;

    private boolean check;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "MenuBar{" +
                "menu=" + menu +
                ", check=" + check +
                '}';
    }
}
