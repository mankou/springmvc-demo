package mang.demo.springmvc.server;

import java.util.Date;

import mang.demo.springmvc.common.util.JsonUtil;
import mang.demo.springmvc.server.entity.TestUser;

public class GenerateData_TestUser {

	public static void main(String[] args) {
		TestUser testUser=new TestUser();
		testUser.setCode("1001");
		testUser.setName("张三");
		testUser.setId(100L);
		testUser.setDate(new Date());
		String jsonStr=JsonUtil.obj2String(testUser);
		System.out.println(jsonStr);
	}

}
