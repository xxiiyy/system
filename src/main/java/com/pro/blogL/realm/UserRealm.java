package com.pro.blogL.realm;

import com.pro.blogL.entrty.User;
import com.pro.blogL.service.Impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lhd on 2017/3/23.
 * @author lhd
 */

public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserServiceImpl userService;

    /**
     * shiro授权过程
     * @param principalCollection 用户名
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * shiro过滤器认证过程
     * @param token 含有凭证和信息
     * @return 返回一个带认证信息的对象
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        String login_name = (String)token.getPrincipal();
        User user = userService.queryUserByLoginName(login_name);
        String password = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo authenticationInfo = new
                SimpleAuthenticationInfo(user,password, ByteSource.Util.bytes(salt),this.getName());
        return authenticationInfo;
    }

    /**
     * realm的名字
     * @param name
     */
    @Override
    public void setName(String name) {
        super.setName("userRealm");
    }
}
