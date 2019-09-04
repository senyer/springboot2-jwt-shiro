package com.zygk.web.service.impl;

import com.zygk.web.domain.local.entity.Log;
import com.zygk.web.domain.local.persistence.LogMapper;
import com.zygk.web.service.LogService;
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
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
