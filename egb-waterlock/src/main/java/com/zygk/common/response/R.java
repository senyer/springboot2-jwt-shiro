package com.zygk.common.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zygk.common.enums.MsgEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 *
 * @author: TSY
 * @date: 2018-06-25
 *
 *        通用的json返回数据
 **/
@ApiModel(value="统一返回接口对象")
public class R implements Serializable {

	private static final long serialVersionUID = -3477609529314194539L;

	
	/** 返回的数据 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(value="目标结果",name="data")
	private Object data;
	
	/** 返回的提示信息 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(value="消息",name="msg")
	private String msg;
	
	/**状态码*/
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(value="状态码",name="code")
	private Integer code;
	

	/**
	 * 返回成功提示 返回请求数据
	 * 
	 * @param success
	 * @param data
	 */
	public R(MsgEnum jsonEnum,Object data) {
		this.msg = jsonEnum.getDesc();
		this.code = jsonEnum.getStatusCode();
		this.data = data;
	}


	/**
	 * 返回成功或者错误提示 不返回其他数据
	 * 
	 * @param success
	 */
	public R(MsgEnum jsonEnum) {
		super();
		this.code = jsonEnum.getStatusCode();
		this.msg= jsonEnum.getDesc();
	}
	
	
	
	public R(String desccription, Integer code) {
		super();
		this.code = code;
		this.msg= desccription;
	}

	public R(String msg) {
		super();
		this.msg = MsgEnum.ERROR.getDesc();
		this.code = MsgEnum.ERROR.getStatusCode();
		this.data = msg;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}

	



}
