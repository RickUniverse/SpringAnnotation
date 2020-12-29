package com.springannotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author lijichen
 * @date 2020/11/30 - 14:32
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String username = UUID.randomUUID().toString().substring(0,5);
        jdbcTemplate.update("insert into account(username,balance) value(?,?)",username,1000);
    }
}
