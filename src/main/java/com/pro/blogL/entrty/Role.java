package com.pro.blogL.entrty;

import java.util.Date;

/**
 * Created by lhd on 2017/3/24.
 * @author lhd
 */
public class Role {

    private int id;

    private String roleName;

    private String roleType;

    private Date createTime;

    private boolean use;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleType='" + roleType + '\'' +
                ", createTime=" + createTime +
                ", use=" + use +
                '}';
    }
}
