package com.company.web.live_role.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName LiveRole
 * @company 公司
 * @Description 业主角色表实体类
 * @createTime 2022年06月16日 21:43:43
 */

@Data
@TableName("live_role")
public class LiveRole implements Serializable {

    /**
     * 业主角色id
     */
    @TableId(type= IdType.AUTO)
    private Long liveRoleId;

    /**
     * 角色id
     */
    private Long roleId;


    /**
     * 业主id
     */
    private Long userId;
}
