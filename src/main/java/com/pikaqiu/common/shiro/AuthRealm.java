package com.pikaqiu.common.shiro;

import com.pikaqiu.bbs.entity.Permission;
import com.pikaqiu.bbs.entity.Role;
import com.pikaqiu.bbs.entity.User;
import com.pikaqiu.bbs.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lvls on 2018/3/16.
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user=(User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> userPermissions = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(roles.size()>0) {
            for(Role role : roles) {
                Set<Permission> permissions = role.getPermissions();
                if(permissions.size()>0) {
                    for(Permission permission : permissions) {
                        userPermissions.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(userPermissions);//将权限放入shiro中.
        return info;
    }

    /**
     * 验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) authenticationToken;//获取用户输入的token
        String loginName = utoken.getUsername();
        User user = userService.findRoleByLoginName(loginName);
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
}
