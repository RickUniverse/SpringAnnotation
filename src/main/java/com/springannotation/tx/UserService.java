package com.springannotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lijichen
 * @date 2020/11/30 - 14:31
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional//开启事务
    public void insert() {
        userDao.insert();
        System.out.println("插入。。。");
        int i = 10 / 0;
    }
}
