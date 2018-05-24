package cn.panda.config;

import cn.panda.entity.User;
import cn.panda.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 *
 */
@Service
@Slf4j
public class UserRealm extends AuthorizingRealm {


    @Resource
    UserMapper userMapper;

    @Override
    public void setName(String name) {
        super.setName("UserRealm");
    }

    /**
     *  用于授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        String username = (String) principals.getPrimaryPrincipal();
        log.info("需要授权的username----------------------->{}",username);

        User user = userMapper.findByUsernameIs(username);

        //获取用户的所属的角色名称
        Set<String> roleNames = userMapper.getAllRoleNameByUserName(username);
        //获取用户的角色对应的所有的权限字段
        Set<String> privilegePermissions = userMapper.getAllPrivilegeByUserName(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        log.info("--------------------->{}",roleNames);
        log.info("--------------------->{}",privilegePermissions);

        authorizationInfo.setRoles(roleNames);
        authorizationInfo.setStringPermissions(privilegePermissions);

        return authorizationInfo;
    }


    /**
     * 用于认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        log.info("---------------------->{}", "doGetAuthenticationInfo token");
        log.info("userMapper--------------------->{}",userMapper);

        String username = (String) token.getPrincipal();

        User user = userMapper.findByUsernameIs(username);

        log.info("user------------->{}", user);

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()  //realm name
        );

        log.info("authenticationInfo-------------->{}", authenticationInfo);

        return authenticationInfo;
    }


    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
