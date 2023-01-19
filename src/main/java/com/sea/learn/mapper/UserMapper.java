package com.sea.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sea.learn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/1/18 10:46
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
