package cn.panda.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        if (principalCollection == null) {
            throw new AuthorizationException("Principal对象不能为空");
        }

        String username=(String) principalCollection.fromRealm(getName()).iterator().next();

        if(username!=null&&username.equals("user")){
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //登录的用户有多少个角色
            info.addRole("admin");
            info.addRole("testRole");
            //权限
            info.addStringPermission("user:create");
            info.addStringPermission("user:edit");
            info.addStringPermission("user:menu");
            return info;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken upt = (UsernamePasswordToken) authenticationToken;
        if(upt.getUsername().equals("user")){
            return new SimpleAuthenticationInfo(upt.getUsername(), "123", getName());
        }
        return null;

    }
}
