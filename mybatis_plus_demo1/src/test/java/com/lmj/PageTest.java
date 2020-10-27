package com.lmj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmj.entity.User;
import com.lmj.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTest {
	@Autowired
	UserService userService;
	@Test
	public void mapperCustomPageTest() {
		Page<User> page = new Page<User>();
		Integer age = 24;
		IPage<User> ipage = userService.selectUserPage(page, age);
		System.out.println(ipage.getTotal());
	}
}
