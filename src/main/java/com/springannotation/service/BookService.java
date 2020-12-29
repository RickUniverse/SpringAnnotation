package com.springannotation.service;

import com.springannotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author lijichen
 * @date 2020/11/27 - 15:42
 */
@Service
public class BookService {

    @Qualifier("bookDao2")//指定id对应的装配对象
    @Autowired(required = true)
//    @Resource
//    @Inject
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
