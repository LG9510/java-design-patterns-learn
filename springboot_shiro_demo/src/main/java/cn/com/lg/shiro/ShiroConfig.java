package cn.com.lg.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: springboot_shiro_demo
 * @BelongsPackage: cn.com.lg.shiro
 * @Author: 10122
 * @CreateTime: 2020-05-18 19:57
 * @Description: shiro的配置
 */
public class ShiroConfig {
    /**
     * shiro过滤器工厂bean
     * @Qualifier 将对象注入到方法中
     * @param securityManager 安全管理器
     * @return {@link ShiroFilterFactoryBean}
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        System.out.println("执行了ShiroConfig中ShiroFilterFactoryBean方法");
        //创建ShiroFilterFactoryBean对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //1.将shiro的核心安全关联组件设置到shiroFilterFactoryBean对象中
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        //新建要被设置的内置过滤器集合
        Map<String, String> filterMap = new HashMap<String, String>();
        //往集合中设置路径的具体要被执行的过滤器
       /* filterMap.put("/user/toDemo","anon");
        filterMap.put("/user/toAdd","authc");
        filterMap.put("/user/toUpdate","anon");*/
        //使用通配符的方式配置路径要执行的过滤器
        //无需认证
        filterMap.put("/user/toDemo","anon");
        filterMap.put("/user/login","anon");

        //需要授权
        filterMap.put("/user/toAdd","perms[user:toAdd]");
        filterMap.put("/user/toUpdate","perms[user:toUpdate]");

        //需要认证
        filterMap.put("/user/*","authc");

        //如果必须认证的过滤器不通过，shiro默认会去到login.jsp
        //也可以自定义去到的路径
        shiroFilterFactoryBean.setLoginUrl("/user/loginUI");

        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/noAuth");
        //将自定义的过滤器集合设置到过滤器工厂中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        System.out.println("执行了ShiroConfig中getDefaultWebSecurityManager方法。。");
        //创建DefaultWebSecurityManager核心组件对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //securityManager对象关联userRealm对象，把桥梁搭建起来
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm") //Bean将此方法返回的对象实例化
    public UserRealm getUserRealm(){
        System.out.println("执行了ShiroConfig中getUserRealm方法。。");
        return new UserRealm();
    }
}
