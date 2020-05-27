package cn.com.lg.mapper;

import cn.com.lg.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * @BelongsProject: springboot_shiro_demo
 * @BelongsPackage: cn.com.lg.mapper
 * @Author: 10122
 * @CreateTime: 2020-05-18 19:51
 * @Description: 用户mapper接口
 */
public interface UserMapper {
    /**
     * 查询用户的名字
     *
     * @return {@link User}* @throws Exception 异常
     */
    @Select("select * form user where name = #{name}")
    User queryUserByName()throws Exception;

}
