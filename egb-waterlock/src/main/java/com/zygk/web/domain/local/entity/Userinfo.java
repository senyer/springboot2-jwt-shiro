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
@TableName("sys_userinfo")
public class Userinfo extends Model<Userinfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("login_name")
    private String loginName;

    @TableField("password")
    private String password;

    @TableField("username")
    private String username;

    @TableField("status")
    private String status;

    @TableField("egb_user_key")
    private String egbUserKey;

    @TableField("iot_user_key")
    private String iotUserKey;

    @TableField("avatar")
    private String avatar;

    @TableField("tele")
    private String tele;

    @TableField("salt")
    private String salt;

    @TableField("del_flag")
    private String delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
