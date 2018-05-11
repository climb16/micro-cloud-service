package online.jfree.micro.cloud.server.oauth.service.impl;

import online.jfree.micro.cloud.server.oauth.entity.RcMenuEntity;
import online.jfree.micro.cloud.server.oauth.repository.PermissionRepository;
import online.jfree.micro.cloud.server.oauth.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:38
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<RcMenuEntity> getPermissionsByRoleId(Integer roleId) {
        return permissionRepository.getPermissionsByRoleId(roleId);
    }
}
