package cn.com.lg.service.impl;

import cn.com.lg.mapper.UserMapper;
import cn.com.lg.model.User;
import cn.com.lg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: springboot_shiro_demo
 * @BelongsPackage: cn.com.lg.service.impl
 * @Author: 10122
 * @CreateTime: 2020-05-18 19:50
 * @Description: 用户业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {
    /**
     * 用户映射器
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName() throws Exception {
        return userMapper.queryUserByName();
    }
}
