package com.zmq.realm;

import com.zmq.pojo.User;
import com.zmq.service.PermissionService;
import com.zmq.service.RoleService;
import com.zmq.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

@Setter
public class MyRealm extends AuthorizingRealm {
    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    /***
     * 查询权限信息
     * 何时触发:/user/query=roles["admin"] /user/insert=perms["user:delete"] <shiro:hasRole   <shiro:hasPermission
     * 查询方式:根据用户名查询
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取当前用户名
        String username = (String) principals.getPrimaryPrincipal();
        //查询当前用户的所有权限信息:RoleService:public list<Role> queryAllRoleByUsername(String username)
        //                      permission:pubic list<permission> queryAllPermissionByusername(String username)
        //RoleService roleService = ContextLoader.getCurrentWebApplicationContext().getBean("roleServiceImpl", RoleService.class);
       // PermissionService permissionService = ContextLoader.getCurrentWebApplicationContext().getBean("permissionServiceImpl", PermissionService.class);
        //查询出来的角色信息
        Set<String> roles = roleService.queryAllRoleNameByusername(username);
        //查询出来的权限信息
        Set<String> perms = permissionService.queryAllPermissionNameByusername(username);
        //将用户信息封装在 AuthorizationInfo 子类中的SimpleAuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.setStringPermissions(perms);


        return simpleAuthorizationInfo;
    }

    /***
     * 查询身份信息,并返回即可,不做任何比对
     * 何时触发:subject.login(token)
     * 查询方式:通过用户名查询
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取当前登录用户名
        String username = (String) token.getPrincipal();
        //查询用户信息 :userService:public User queryUserByUsername(String username);
     /*   UserService userService = ContextLoader.getCurrentWebApplicationContext().getBean("userServiceImpl", UserService.class);*/
        //查询到用户信息
        User user = userService.queryAllUserByUsername(username);
        //判断用户信息是不是为空
        if (user == null) {//不存在用户名
            return null;//在后续流程中会抛出异常UnknownAccountException(用户不存在)

        }
        //将用户信息封装在 AuthenticationInfo中的子类SimpleAuthenticationInfo中

        return new SimpleAuthenticationInfo(user.getUsername(),//数据库中的用户名
                user.getPassword(),//数据库中的密码
                ByteSource.Util.bytes(user.getSalt()),//盐
                this.getName());   //realm标识(底层采用className+atomic递增)
    }
}
