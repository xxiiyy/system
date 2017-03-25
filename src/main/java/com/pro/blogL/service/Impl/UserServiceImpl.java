package com.pro.blogL.service.Impl;

import com.pro.blogL.entrty.User;
import com.pro.blogL.mapper.UserMapper;
import com.pro.blogL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lhd on 2017/3/23.
 * @author lhd
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User queryUserByLoginName(String login_name) {
        return userMapper.queryUserByLoginName(login_name);
    }

    public List<User> queryAllUser(Map<String, Object> map) {
        return userMapper.queryAllUser(map);
    }

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
