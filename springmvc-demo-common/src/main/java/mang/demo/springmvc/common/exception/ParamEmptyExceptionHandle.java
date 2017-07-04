package mang.demo.springmvc.common.exception;

import java.util.Iterator;
import java.util.Map;


import mang.util.common.NullUtil;

public class ParamEmptyExceptionHandle {
	
	/**
	 * 判断参数是否为空 如果为空则抛出异常.
	 * 常用于接口参数校验
	 * */
	public static void handleException(Map<String,String> paramMap){
		Iterator iter = paramMap.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    String key = (String) entry.getKey(); 
		    String val = (String) entry.getValue();
		    if(NullUtil.isNull(val)){
		    	throw new ServiceException(ServiceExceptionEnums.common_paramIsEmpty, key);
		    }
		} 
	}
	
	
	/**
	 * 判断参数是否为空 如果为空则抛出异常.
	 * 常用于接口参数校验
	 * */
	
	//TODO 返回类型为类 这样可以把哪个属性为空也列出来
	public static int handleExceptionReturnCode(Map<String,String> paramMap){
		Iterator iter = paramMap.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    String key = (String) entry.getKey(); 
		    String val = (String) entry.getValue();
		    if(NullUtil.isNull(val)){
		    	 return ServiceExceptionEnums.common_paramIsEmpty.getCode();
		    }
		} 
		
		 return ServiceExceptionEnums.ok.getCode();
	}
}
