package com.pro.blogL.mapper;

import com.pro.blogL.entrty.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lhd on 2017/3/23.
 * @author lhd
 */
public interface UserMapper {

    /**
     * 根据登录使用的用户名来获取获取对象
     * @param login_name 登录用户名
     * @return 返回user对象
     */
    public User queryUserByLoginName(@Param("login_name") String login_name);

    /**
     * 获取一个list集合的user，分页获取
     * @param map 里面有起始点startNo，和分页每一页大小pageSize
     * @return
     */
    public List<User> queryAllUser(Map<String,Object> map);

    /**
     * 添加一个用户
     * @param user
     * @return 插入是否成功0（失败），1
     */
    public int insertUser(User user);

    /**
     * 使用登陆用户名更新用户
     * @param user
     * @return
     */
    public int updateUserByLoginName(User user);

    /**
     * 根据loginName删除user
     * @param loginName
     * @return
     */
    public int deleteUserByLoginName(@Param("loginName") String loginName);


}
