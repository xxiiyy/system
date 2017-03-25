package com.pro.blogL.entrty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lhd on 2017/3/24.
 * @author lhd
 */
public class Menu {

    private List<Menu> childMenus;

    private int id;

    private int pid;

    private String name;

    private String href;

    private String icon;

    private boolean show;

    private Date createTime;



    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "childMenus=" + childMenus +
                ", id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                ", icon='" + icon + '\'' +
                ", show=" + show +
                ", createTime=" + createTime +
                '}';
    }
}
