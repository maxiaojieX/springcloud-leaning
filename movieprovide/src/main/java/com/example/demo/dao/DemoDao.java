package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by xiaojie.Ma on 2018/2/26.
 */
@Service
public class DemoDao {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;


    public User findId1(Integer id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
    }
    public User findId2(Integer id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate2.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
    }

    public void sava(Date date) {
        String sql = "INSERT INTO user (name,user.create) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[]{"haha",null});
    }

}
