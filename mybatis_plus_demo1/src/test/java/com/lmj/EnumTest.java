package com.lmj;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lmj.entity.User;
import com.lmj.enums.SexEnum;
import com.lmj.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumTest {
	@Autowired
	UserService userService;
	@Test
	public void enumQueryConditionTest() {
		System.out.println("--------enum 查询条件------");
		//userService.list(userService.query().eq("sex", SexEnum.MAN));
		List<User> users = userService.query().eq("sex", SexEnum.MAN).list();
		users.forEach(System.out::println);
	}
}
