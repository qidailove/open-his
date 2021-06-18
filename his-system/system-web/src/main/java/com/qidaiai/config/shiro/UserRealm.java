package com.qidaiai.config.shiro;

import com.qidaiai.domain.User;
import com.qidaiai.service.UserService;
import com.qidaiai.vo.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


/**
 * 自定义realm规则去匹配用户和密码
 * @author qidaiai
 * @date 2021/06/18
 */
@Configuration
public class UserRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private UserService userService;

    @Override
    public String getName(){
        return this.getClass().getName();
    }

    /**
     * 认证信息  即登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户登陆名
        String phone = token.getPrincipal().toString();
        //根据用户电话号码查询是否存在
        User user = userService.queryUserByPhone(phone);
        if (user != null){//说明用户存在，但是密码可能不正确
            //组装存放到redis里面的对象
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(user);
            //匹配密码
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activerUser,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
            return simpleAuthenticationInfo;
        }else {
            return null;//表示用户不存在
        }
    }


    /**
     * 做授权  --登陆成功之后判断用户是否有某个菜单或按钮的权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        ActiverUser activerUser = (ActiverUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }
}
