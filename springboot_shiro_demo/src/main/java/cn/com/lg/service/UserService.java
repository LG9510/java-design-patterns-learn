package cn.com.lg.service;

import cn.com.lg.model.User;

/**
 * @BelongsProject: springboot_shiro_demo
 * @BelongsPackage: cn.com.lg.service
 * @Author: 10122
 * @CreateTime: 2020-05-18 19:47
 * @Description: 用户业务层接口
 */
public interface UserService {
    /**
     * 找到用户的名字
     *
     * @return {@link User}* @throws Exception 异常
     */

    User findUserByName(String username);
}
