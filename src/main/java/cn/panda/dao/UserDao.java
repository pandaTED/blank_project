package cn.panda.dao;

import cn.panda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends JpaRepository<User,Long>{

        User findByUsernameIs(String username);

}
