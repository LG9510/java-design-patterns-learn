package tk.mybatis.simple.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class SysPrivilege implements Serializable {
    private static final long serialVersionUID = -5095220654091439157L;
    /**
     * 权限ID
     */
    private Long id;
    /**
     * 权限名称
     */
    private String privilegeName;
    /**
     * 权限URL
     */
    private String privilegeUrl;
}
