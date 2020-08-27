package com.wsl.shiro;

import com.wsl.bean.Permission;
import com.wsl.bean.User;
import com.wsl.service.impl.LoginServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    LoginServiceImpl loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Permission> list=loginService.getPermission(username);
        for (int i=0;i<list.size();i++){
            info.addStringPermission(list.get(i).getPermission());
            info.addRole(list.get(i).getRole());
        }
        return info;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        User user=loginService.getUser(userName);
        if (user == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(user.getPassword())) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
    }
}
