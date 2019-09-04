package com.zygk.web.domain.local.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Senyer
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_resource")
public class UserResource extends Model<UserResource> {

    private static final long serialVersionUID = 1L;

    @TableField("resource_id")
    private Integer resourceId;

    @TableField("role_id")
    private Integer roleId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
