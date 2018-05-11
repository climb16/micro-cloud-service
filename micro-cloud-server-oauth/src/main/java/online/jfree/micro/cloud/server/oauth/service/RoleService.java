package online.jfree.micro.cloud.server.oauth.service;


import online.jfree.micro.cloud.server.oauth.entity.RcRoleEntity;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:30
 * ProjectName:Mirco-Service-Skeleton
 */
public interface RoleService {
    List<RcRoleEntity> getRoleValuesByUserId(Integer userId);
}
