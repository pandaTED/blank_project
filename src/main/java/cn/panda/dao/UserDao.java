package cn.panda.dao;

import cn.panda.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public interface UserDao {


        void add(User user);

        User findById(Long id);

        List<User> getAll();


}
