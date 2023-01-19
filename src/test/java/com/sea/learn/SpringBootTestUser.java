package com.sea.learn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sea.learn.mapper.UserMapper;
import com.sea.learn.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/1/18 12:00
 */
@SpringBootTest
public class SpringBootTestUser {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserName("wanglianhai");
        user.setAge(18);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);

        Assertions.assertNotEquals(user.getId(), 0);
    }

    @Test
    public void selectById() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, 1);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);

        Assertions.assertNotEquals(user, null);

    }

    @Test
    public void page() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getId, 0);
        Page<User> page = new Page();
        page.setSize(10);
        page.setCurrent(2);
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);
        for (User record : userPage.getRecords()) {
            System.out.println(record);
        }
        System.out.println(userPage.getPages());
    }

    @Test
    public void selectName() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct user_name");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }

    }


}
