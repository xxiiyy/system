package com.pro.blogL.service;

import com.pro.blogL.entrty.User;

import java.util.List;
import java.util.Map;

/**
 * Created by lhd on 2017/3/23.
 * @author lhd
 */
public interface UserService {

    public User queryUserByLoginName(String login_name);
    
    public List<User> queryAllUser(Map<String,Object> map);
    
    public int insertUser(User user);


}
