package com.lmj.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmj.entity.User;
import com.lmj.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
