package com.zq.commons.shiro;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zq.entity.system.User;
import com.zq.service.system.IRoleService;
import com.zq.service.system.IUserService;


public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger logger = Logger.getLogger(ShiroDbRealm.class);

    @Autowired
    IUserService iUserService;
    @Autowired
    IRoleService iRoleService;
    
    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }  
    /* (非 Javadoc) 
    * <p>Title: doGetAuthenticationInfo</p> 
    * <p>Description: Shiro登录认证
    * (原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 
    * ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )</p> 
    * @param authcToken
    * @return
    * @throws AuthenticationException 
    * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken) 
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    	logger.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User login_user = new User();
        login_user.setLoginName(token.getUsername());
        List<User> list = iUserService.selectByLoginName(login_user);
        // 账号不存在
        if (list == null || list.isEmpty()) {
            return null;
        }
        User user = list.get(0);
        // 账号未启用
        if (user.getStatus() == 1) {
            return null;
        }
        // 读取用户的url和角色
        Map<String, Set<String>> resourceMap = iRoleService.selectResourceMapByUserId(user.getId());
        Set<String> urls = resourceMap.get("urls");
        Set<String> roles = resourceMap.get("roles");
        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getLoginName(), user.getName(), urls);
        shiroUser.setRoles(roles);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), 
        ShiroByteSource.of(user.getSalt()), getName());
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(shiroUser.getRoles());
        info.addStringPermissions(shiroUser.getUrlSet());
        
        return info;
    }
    
    @Override
    public void onLogout(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        removeUserCache(shiroUser);
    }

    /**
     * 清除用户缓存
     * @param shiroUser
     */
    public void removeUserCache(ShiroUser shiroUser){
        removeUserCache(shiroUser.getLoginName());
    }

    /**
     * 清除用户缓存
     * @param loginName
     */
    public void removeUserCache(String loginName){
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(principals);
    }
}
