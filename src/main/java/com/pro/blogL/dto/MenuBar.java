package com.pro.blogL.dto;

import com.pro.blogL.entrty.Menu;

/**
 * Created by lhd on 2017/3/24.
 * @author lhd
 */
public class MenuBar extends Menu {

    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "MenuBar{" +
                "checked=" + checked +
                '}';
    }
}
