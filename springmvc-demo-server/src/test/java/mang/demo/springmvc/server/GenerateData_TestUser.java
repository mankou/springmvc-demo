package mang.demo.springmvc.server;

import mang.demo.springmvc.server.entity.TestUser;
import mang.util.common.JsonUtil;

public class GenerateData_TestUser {

	public static void main(String[] args) {
		TestUser testUser=new TestUser();
		testUser.setCode("1001");
		testUser.setName("张三");
		testUser.setId(100L);
		String jsonStr=JsonUtil.obj2String(testUser);
		System.out.println(jsonStr);
	}

}
