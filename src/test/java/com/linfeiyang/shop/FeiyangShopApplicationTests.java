package com.linfeiyang.shop;

import com.linfeiyang.shop.mybatis.model.Admin;
import com.linfeiyang.shop.service.admin.AdminAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeiyangShopApplicationTests {

	@Autowired
	private AdminAuthService adminAuthService;


	@Test
	public void testAddAdmin() {
		Admin admin = new Admin();
		admin.setUsername("xiaoqiu");
		admin.setPassword("123456");
		admin.setPhone("13733987253");
		Assert.isTrue(adminAuthService.addAdmin(admin), "添加失败!");
	}


	@Test
	public void contextLoads() {
	}



}
