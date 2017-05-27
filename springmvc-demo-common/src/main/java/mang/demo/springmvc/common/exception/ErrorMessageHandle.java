package mang.demo.springmvc.common.exception;

import mang.demo.springmvc.common.util.Constant;

import mang.util.common.NullUtil;

public class ErrorMessageHandle {
	
	/**
	 * 处理错误信息
	 * */
	public static String processErrorMessage(int code,String message){
		String baseMessage=Constant.exceptionCode.errMessageMap.get(code);
		String result;
		if(NullUtil.isNull(message)){
			result=message;
		}else{
			result=baseMessage+"("+message+")";
		}
		return result;
	}
}
