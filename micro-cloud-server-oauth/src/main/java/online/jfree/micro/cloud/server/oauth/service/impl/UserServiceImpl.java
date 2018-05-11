package online.jfree.micro.cloud.server.oauth.service.impl;

import online.jfree.micro.cloud.server.oauth.entity.RcUserEntity;
import online.jfree.micro.cloud.server.oauth.repository.UserRepository;
import online.jfree.micro.cloud.server.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:15:13
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public RcUserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
