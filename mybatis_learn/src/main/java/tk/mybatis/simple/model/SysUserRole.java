package tk.mybatis.simple.model;

import lombok.Data;

@Data
public class SysUserRole {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;
}
