package online.jfree.micro.cloud.server.oauth.service.impl;

import online.jfree.micro.cloud.server.oauth.entity.RcRoleEntity;
import online.jfree.micro.cloud.server.oauth.repository.RoleRepository;
import online.jfree.micro.cloud.server.oauth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:31
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RcRoleEntity> getRoleValuesByUserId(Integer userId) {
        return roleRepository.getRoleValuesByUserId(userId);
    }
}
