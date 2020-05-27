package cn.com.lg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: springboot_shiro_demo
 * @BelongsPackage: cn.com.lg.controller
 * @Author: 10122
 * @CreateTime: 2020-05-18 19:20
 * @Description: 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * @Author: 10122
     * @param model
     * 去到测试主页面
     */
    @RequestMapping("/toDemo")
    public String toDemo(Model model){
        return "demo";
    }
    /**
     * 去到添加页面
     */
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/add";
    }


    /**
     * 更新
     *
     * @return {@link String}
     */
    @RequestMapping("toUpdate")
    public String toUpdate(){
        return "user/update";
    }

    /**
     * 登录界面
     *
     * @return {@link String}
     */
    @RequestMapping("/loginUI")
    public String loginUI(){
        return "user/login";
    }
    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        /**
         *使用shiro编写认证操作
         */
        /**
         * 获取shiro的subject对象
         */
        Subject subject = SecurityUtils.getSubject();
        /**创建封装用户的登录数据*/
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        subject.login(token);
        return "demo";

    }
}
