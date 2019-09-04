package com.zygk.web.service.impl;

import com.zygk.web.domain.local.entity.UserResource;
import com.zygk.web.domain.local.persistence.UserResourceMapper;
import com.zygk.web.service.UserResourceService;
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
public class UserResourceServiceImpl extends ServiceImpl<UserResourceMapper, UserResource> implements UserResourceService {

}
