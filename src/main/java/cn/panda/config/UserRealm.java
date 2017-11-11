package cn.panda.config;

import cn.panda.dao.UserDao;
import cn.panda.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class UserRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Resource
    UserDao userDao;

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
        logger.info("需要授权的username----------------------->{}",username);

        User user = userDao.findByUsernameIs(username);

        //获取用户的所属的角色名称
        Set<String> roleNames = userDao.getAllRoleNameByUserName(username);
        //获取用户的角色对应的所有的权限字段
        Set<String> privilegePermissions = userDao.getAllPrivilegeByUserName(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        logger.info("--------------------->{}",roleNames);
        logger.info("--------------------->{}",privilegePermissions);

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

        logger.info("---------------------->{}", "doGetAuthenticationInfo token");
        logger.info("userDao--------------------->{}",userDao);

        String username = (String) token.getPrincipal();

        User user = userDao.findByUsernameIs(username);

        logger.info("user------------->{}", user);

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

        logger.info("authenticationInfo-------------->{}", authenticationInfo);

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
