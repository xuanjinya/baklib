package com.zfkj.baklib.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zfkj.baklib.entity.User;
import com.zfkj.baklib.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    //根据account查询用户
    @Override
    public User selectUserByAccount(String account) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("account", account);
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    //添加一个用户数据
    @Override
    public int insertUser(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }
}
