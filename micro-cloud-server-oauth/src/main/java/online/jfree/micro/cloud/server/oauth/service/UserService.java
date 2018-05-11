package online.jfree.micro.cloud.server.oauth.service;


import online.jfree.micro.cloud.server.oauth.entity.RcUserEntity;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:15:12
 * ProjectName:Mirco-Service-Skeleton
 */
public interface UserService {
    RcUserEntity findByUsername(String username);
}
