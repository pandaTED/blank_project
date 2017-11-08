package cn.panda.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class UserInfoDaoTest {

    Logger logger = LoggerFactory.getLogger(UserInfoDaoTest.class);

    @Resource
    UserInfoDao userInfoDao;

        @Test
        public  void test1(){

            logger.info("==============================");
            logger.info("----------->{}",userInfoDao.findByUserName("admin"));
            logger.info("==============================");

        }


}
