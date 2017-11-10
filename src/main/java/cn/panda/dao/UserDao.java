package cn.panda.dao;

import cn.panda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long>{

    User findByUsernameIs(String username);


    @Query(nativeQuery = true,value = "SELECT r.role FROM sysrole as r\n" +
            "LEFT JOIN sysuserrole as ur on ur.roleId = r.id\n" +
            "LEFT JOIN `user` as u on u.uid = ur.uid\n" +
            "WHERE u.username = ?1")
    List<String> getAllRoleNameByUserName(String username);

    @Query(nativeQuery = true,value = "")
    List<String> getAllPrivilegeByUserName(String username);

}
