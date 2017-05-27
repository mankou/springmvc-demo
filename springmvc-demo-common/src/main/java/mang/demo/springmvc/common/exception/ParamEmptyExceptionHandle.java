package mang.demo.springmvc.common.exception;

import java.util.Iterator;
import java.util.Map;

import mang.demo.springmvc.common.util.Constant;

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
		    	throw new ServiceException(Constant.exceptionCode.paramIsEmpty, key);
		    }
		} 
	}
}
