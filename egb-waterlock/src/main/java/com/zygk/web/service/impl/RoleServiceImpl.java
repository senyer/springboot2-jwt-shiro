package com.zygk.web.service.impl;

import com.zygk.web.domain.local.entity.Role;
import com.zygk.web.domain.local.persistence.RoleMapper;
import com.zygk.web.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
