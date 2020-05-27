package cn.com.lg.shiro;

import cn.com.lg.model.User;
import cn.com.lg.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @BelongsProject: springboot_shiro_demo
 * @BelongsPackage: cn.com.lg.shiro
 * @Author: 10122
 * @CreateTime: 2020-05-18 20:16
 * @Description: 自定义的realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 进行授权逻辑操作方法
     *
     * @param principalCollection 主要收集
     * @return {@link AuthorizationInfo}
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权逻辑操作");
        /**给资源进行授权*/
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //添加资源的授权字符串
        info.addStringPermission(user.getPerms());
        return info;
    }

    /**
     * 进行认证（登陆）逻辑操作方法
     *
     * @param authenticationToken 身份验证令牌
     * @return {@link AuthenticationInfo}* @throws AuthenticationException 身份验证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证的逻辑操作！！");
        //模拟登陆的正确的用户名和密码
      /*  String name = "admin";
        String password = "123456";*/
        //定义用户对象
        User user = null;
        //获取用户输入的封装的登陆数据token（用户输入的从页面传来用户名和密码）
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //根据页面输入的用户名查询用户数据
        try {
            user = userService.findUserByName(token.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //进行用户名的判断
        if(user==null){
            //用户名不存在
            return null;
            //shiro底层会抛出异常UnknownAccountException
            //此时的抛出异常会被UserController中的login方法捕获到
        }
        //参数1.认证成功后的用户对象数据，2.此用户的有效密码，3.自定义的realm的名字
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
        //若密码不正确，则shiro底层会抛出异常IncorrectCredentialsException
        //此时的抛出异常会被UserController中的login方法捕获到
    }

}
