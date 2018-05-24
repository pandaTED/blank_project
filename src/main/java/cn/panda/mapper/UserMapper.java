package cn.panda.mapper;

import cn.panda.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Set;

/**
 * @author ZhuYunpeng
 * woscaizi@gmail.com
 * 2018-05-24
 */
public interface UserMapper extends BaseMapper<User> {

    User findByUsernameIs(String username);

    Set<String> getAllRoleNameByUserName(String username);

    Set<String> getAllPrivilegeByUserName(String username);
}
