package tk.mybatis.simple.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class CreateInfo implements Serializable {
    private static final long serialVersionUID = -321661292398180191L;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
}
