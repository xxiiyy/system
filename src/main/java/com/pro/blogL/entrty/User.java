package com.pro.blogL.entrty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lhd on 2017/3/23.
 * @author lhd
 */
public class User implements Serializable{

    //用户id
    private String id;

    //用户名
    private String nickName;

    //登录账号名
    private String loginName;

    //密码
    private String password;

    //角色类别
    private String roleType;

    //盐
    private String salt;

    //性别
    private boolean sex;

    //创建时间
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", roleType='" + roleType + '\'' +
                ", salt='" + salt + '\'' +
                ", sex=" + sex +
                ", createTime=" + createTime +
                '}';
    }
}
