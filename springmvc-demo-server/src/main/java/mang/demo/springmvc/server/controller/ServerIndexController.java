package mang.demo.springmvc.server.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mang.demo.springmvc.server.entity.TestUser;
import mang.demo.springmvc.server.entity.TestUserDateFormatter;
import mang.demo.springmvc.server.service.TestService;
import mang.demo.springmvc.common.exception.ServiceException;
import mang.demo.springmvc.common.resulthandle.JsonResult;
import mang.demo.springmvc.common.resulthandle.StringResult;


@Controller
@RequestMapping(value = "/serverIndex")
public class ServerIndexController {
	
	private static Logger logger=Logger.getLogger("log");
	
	@Autowired
	private TestService testService;
	
	
	/**
	 * 演示post请求 主要用于测试程序之间的联通性
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testPost/
	 */
	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	@ResponseBody
	public Object testPost(@RequestBody TestUser testUser) {
		logger.info("[测试]测试post请求");
		return testUser;
	}
	
	
	/**
	 * 演示post请求 主要用于测试程序之间的联通性
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testPostDateFormatter/
	 */
	@RequestMapping(value = "/testPostDateFormatter", method = RequestMethod.POST)
	@ResponseBody
	public Object testPost(@RequestBody TestUserDateFormatter testUser) {
		logger.info("[测试]测试post请求");
		return testUser;
	}
	
	
	/**
	 * 演示一般的get请求(不查数据库)
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/test/
	 * */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Date index() {
		logger.info("[测试]简单测试");
		Date date=new Date();
		return date;
	}
	
	//TODO 目前还没有解决返回String的问题
	/**
	 * 演示一般的get请求(不查数据库)
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testStr/
	 * */
	@RequestMapping(value = "/testStr", method = RequestMethod.GET)
	@ResponseBody
	public String testStr() {
		logger.info("[测试]返回字符串");
		String str="hello world";
		return str;
	}
	
	
	//TODO post请求传入json测试 (json中有中文)
	
	/**
	 * 演示一般的get请求(不查数据库)
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testObject/
	 * */
	@RequestMapping(value = "/testObject", method = RequestMethod.GET)
	@ResponseBody
	public StringResult testObject() {
		logger.info("[测试]返回对象");
		StringResult sr=new StringResult("hello world");
		return sr;
	}
	
	
	/**
	 * 演示查询数据库并返回一个list
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testQueryDbList.query/
	 * */
	@RequestMapping(value = "/testQueryDbList.query", method = RequestMethod.GET)
	@ResponseBody
	public List testQueryDbList(){
		logger.info("[测试]查询数据库返回list");
		List lis=testService.queryDb();
		return lis;
	}
	
	/**
	 * 演示查询数据库返回一个对象
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testQueryDbObject.query/
	 * */
	@RequestMapping(value = "/testQueryDbObject.query", method = RequestMethod.GET)
	@ResponseBody
	public Object testQueryDbObject(){
		logger.info("[测试]查询数据库返回对象");
		List lis=testService.queryDb();
		Object obj=null;
		if(lis.size()>0){
			obj=lis.get(0);
		}
		return obj;
	}
	
	
	/**
	 * 演示查询数据库返回一个对象
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testInsertDb.do
	 * */
	@RequestMapping(value = "/testInsertDb.do", method = RequestMethod.GET)
	@ResponseBody
	public Object testInsertDb(){
		logger.info("[测试]插入数据库测试");
		TestUser testUser=testService.insertDb();
		return testUser;
	}
	
	
	/**
	 * 显示运行中异常
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testRuntimeException/
	 * */
	@RequestMapping(value = "/testRuntimeException", method = RequestMethod.GET)
	@ResponseBody
	public String testRuntimeException(){
		logger.info("[测试]运行时异常测试");
		int i=1/0;
		return "hah";
	}
	
	
	/**
	 * 演示业务异常
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testServiceException/
	 * */
	@RequestMapping(value = "/testServiceException", method = RequestMethod.GET)
	@ResponseBody
	public String testServiceException(){
		logger.info("[测试]业务异常测试");
		throw new ServiceException(2, "业务异常");
	}
	
	
	/**
	 * 演示json处理-空值处理
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testNullValue/
	 * */
	@RequestMapping(value = "/testNullValue", method = RequestMethod.GET)
	@ResponseBody
	public TestUser testNullValue(){
		logger.info("[测试]jackSon空值处理");
		//这些都是统一配置的,所以这里不需要关心
		TestUser user=new TestUser();
		user.setCode("hello");
		user.setDate(new Date());
		return user;
	}
	
	
	/**
	 * 演示返回字符串
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testReturnString/
	 * */
	@RequestMapping(value = "/testReturnString", method = RequestMethod.GET)
	@ResponseBody
	public String testReturnString(){
		//TODO 因做了统一结果处理  如果返回String 类型会报错 目前没有解决 
		return "hello world1";
	}
	
	/**
	 * 演示返回JsonResult类型
	 * http://127.0.0.1:8080/springmvc-demo-web/serverIndex/testReturnJsonResult/
	 * */
	@RequestMapping(value = "/testReturnJsonResult", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult testReturnJsonResult(){
		JsonResult<String> jsonResult=new JsonResult<String>("hello");
		return jsonResult;
	}
	
}
