package com.zygk.web.service.impl;

import com.zygk.web.domain.local.entity.Resource;
import com.zygk.web.domain.local.persistence.ResourceMapper;
import com.zygk.web.service.ResourceService;
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
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}
