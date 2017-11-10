package cn.panda.dao;


import cn.panda.config.PasswordHelper;
import cn.panda.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class UserDaoTest {

    Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource
    UserDao userDao;

        @Test
        public  void test1(){
            User user = new User();

            user.setName("系统管理员");
            user.setUsername("admin");
            user.setState(new Byte("0"));

            String password = "123";
            user.setPassword(password);

            PasswordHelper passwordHelper = new PasswordHelper();

            passwordHelper.encryptPassword(user);


            logger.info("-------------------->{}",user.getPassword());
            logger.info("-------------------->{}",user.getCredentialsSalt());
            logger.info("-------------------->{}",user.getUsername());
            logger.info("-------------------->{}",user.getState());

            userDao.save(user);

            logger.info("==============================");
            logger.info("----------->{}",userDao.findByUsernameIs("admin"));
            logger.info("==============================");


        }


}
