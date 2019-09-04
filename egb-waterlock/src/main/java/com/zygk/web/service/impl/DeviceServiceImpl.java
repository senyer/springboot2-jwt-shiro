package com.zygk.web.service.impl;

import com.zygk.web.domain.local.entity.Device;
import com.zygk.web.domain.local.persistence.DeviceMapper;
import com.zygk.web.service.DeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Senyer
 * @since 2019-09-03
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

}
