package com.nb.wukong.utils.config.shiro;

import com.nb.jingubang.entity.SysMenu;
import com.nb.jingubang.entity.SysRole;
import com.nb.jingubang.entity.SysUser;
import com.nb.jingubang.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.alibaba.dubbo.config.annotation.Reference;



/**
 * shiro Realm
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Reference(version="0.0.1")
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser userInfo  = (SysUser)principals.getPrimaryPrincipal();
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRoleName());
            for(SysMenu menu:role.getMenuList()){
                authorizationInfo.addStringPermission(menu.getMenuName());
            }
        }
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("哈哈哈哈哈哈哈哈哈哈");
        //获得当前用户的用户名
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //根据用户名找到对象
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        System.out.println("userService is : "+userService);
        SysUser userInfo = userService.getByUserName(username);
        if(userInfo == null){
            return null;
        }
        //这里会去校验密码是否正确
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassWord(),//密码
                getName()
        );
        return authenticationInfo;
    }
}
