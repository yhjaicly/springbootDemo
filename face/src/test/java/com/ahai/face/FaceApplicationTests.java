package com.ahai.face;

import com.ahai.face.dao.photoInfoDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ahai.face.utils.SpringUtil;

import javax.annotation.Resource;

@SpringBootTest
//@RunWith如果没有，需要添加Junit依赖，具体解决方法在下面。
@RunWith(SpringJUnit4ClassRunner.class)
class FaceApplicationTests {

    @Resource
    photoInfoDao photoInfoDao;
    @Test
    void contextLoads() {
        photoInfoDao  = (photoInfoDao) SpringUtil.getBean(photoInfoDao.getClass());
        System.out.println(photoInfoDao.count());
    }
}
