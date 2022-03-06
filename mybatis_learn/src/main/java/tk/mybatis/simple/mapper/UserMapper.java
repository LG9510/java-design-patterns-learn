package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {
    /**
     * @return all
     */
    List<SysUser> selectAll();

    /**
     * @param id id
     * @return 查询数据
     */
    SysUser selectById(@Param("id") Integer id);
}
