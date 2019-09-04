package com.zygk.web.service;

import java.util.List;
import com.zygk.web.vo.FreshTokenVO;
import com.zygk.web.vo.LoginVO;
import com.zygk.web.vo.WaterLockVO;

public interface ApiService {

	/**
	 *  用户登录
	 * @param username 用户名
	 * @param password 密码
	 */
	LoginVO login(String username,String password);
	
	/**
	 * 	获取水箱锁信息
	 * @param isAdmin 是否是admin，如果是则查询所有
	 * @param status 水箱锁状态
	 * @param name 水箱锁名称（支持模糊查询）
	 * @param devID 设备ID
	 * @param userId 用户id
	 * @return 水箱锁信息
	 */
	List<WaterLockVO> queryAllWaterLock(boolean isAdmin, int status, String name, String devID, int userId);
	
	/**
	 * 
	 * @param devID 设备锁ID
	 * @return 返回是否成功
	 */
	boolean openLock(String devID);
	
	
	/**
	 * 	获取新的token
	 * @param refresh_token refresh_token
	 * @return
	 */
	FreshTokenVO refreshToken(String refresh_token);
	
	
}
