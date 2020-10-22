package com.lmj;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.lmj.entity.User;
import com.lmj.mapper.UserMapper;
import com.lmj.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(6, userList.size());
		userList.forEach(System.out::println);
	}
	
	@Test
	public void testCommonChain() {
		System.out.println("---testCommonChain----");
		User user = userService.query().eq("id", 1).one();
		System.out.println(user.toString());
	}
	
	@Test
	public void lambdaExcepressTest() {
		System.out.println("---lambdaExcepressTest----");
		List<User> users = userService.lambdaQuery().eq(User::getId, 1).list();
		users.forEach(System.out::println);
	}
	
	@Test
	public void testQueryWrapperSelect() {
		System.out.println("---testQueryWrapperSelect----");
		// QueryWrapper<User> userQw = new QueryWrapper<User>();
		List<User> users = userService.query().select("id","name").eq("id", 1).list();
		users.forEach(System.out::println);
	}
	
	@Test
	public void testLambdaQueryWrapperSelect() {
		System.out.println("---testLambdaQueryWrapperSelect----");
		// QueryWrapper<User> userQw = new QueryWrapper<User>();
		User user = new User();
		user.setId(1L);
		// 注意这里传入的Predicate会被如何调用，我们不能明显的看出来，从运行结果来看：针对不同field对Predicate进行了调用；
		List<User> users = userService.lambdaQuery().setEntity(user).select(wrapper-> { // 注意只有内部有 entity 才能使用该方法； wrapper中entity可以形成and参数
			System.out.println(wrapper.getProperty());
			return wrapper.getProperty().equals("name");
		}).list();
		users.forEach(System.out::println);
	}
}
