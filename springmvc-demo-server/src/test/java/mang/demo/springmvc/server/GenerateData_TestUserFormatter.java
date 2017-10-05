package mang.demo.springmvc.server;

import java.util.Date;

import mang.demo.springmvc.server.entity.TestUserDateFormatter;
import mang.util.common.JsonUtil;

public class GenerateData_TestUserFormatter {

	public static void main(String[] args) {
		TestUserDateFormatter testUser=new TestUserDateFormatter();
		testUser.setCode("1001");
		testUser.setName("张三");
		testUser.setId(100L);
		testUser.setDate(new Date());
		String jsonStr=JsonUtil.obj2String(testUser);
		System.out.println(jsonStr);
	}

}
