package tk.mybatis.simple.model;

import lombok.Data;
import tk.mybatis.simple.type.Enabled;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -5776948673410691671L;
    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 有效标志
     */
    private Enabled enabled;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户信息
     */
    private SysUser user;
    /**
     * 创建信息
     */
    private CreateInfo createInfo;
}
