package online.jfree.micro.cloud.server.oauth.repository;

import online.jfree.micro.cloud.server.oauth.entity.RcUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:14:52
 * ProjectName:Mirco-Service-Skeleton
 */
@Repository
public interface UserRepository extends JpaRepository<RcUserEntity, Integer> {
    RcUserEntity findByUsername(String username);
}
