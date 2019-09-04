package com.zygk.web.domain.local.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
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
@TableName("sys_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("business_type")
    private String businessType;

    @TableField("operator_type")
    private String operatorType;

    @TableField("oper_name")
    private String operName;

    @TableField("dept_name")
    private String deptName;

    @TableField("oper_url")
    private String operUrl;

    @TableField("oper_ip")
    private String operIp;

    @TableField("status")
    private String status;

    @TableField("method")
    private String method;

    @TableField("error_msg")
    private String errorMsg;

    @TableField("oper_time")
    private Date operTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
