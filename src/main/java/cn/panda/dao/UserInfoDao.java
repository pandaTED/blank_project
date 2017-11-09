package cn.panda.dao;

import cn.panda.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoDao {


    @Select("select * from user_info where username = #{username}")
    UserInfo findByUsername(String username);
}
