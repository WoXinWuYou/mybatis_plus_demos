package com.lmj.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmj.entity.User;
import com.lmj.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
	
	public IPage<User> selectUserPage(Page<User> page, Integer age) {
	    // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
	    // page.setOptimizeCountSql(false);
	    // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
	    // 要点!! 分页返回的对象与传入的对象是同一个
		//也可以参考下面这种写法
		baseMapper.update(
		    null,
		    Wrappers.<User>lambdaUpdate()
		       .set(User::getAge, 3)
		       .set(User::getName, "mp")
		       .set(User::getEmail, null) //把email设置成null
		       .eq(User::getId, 2)
		);
	    return baseMapper.selectPageVo(page, age);
	}
}
