package mang.demo.springmvc.common.exception;


import org.apache.commons.lang3.StringUtils;

public class ErrorMessageHandle {
	
	/**
	 * 处理错误信息
	 * */
	public static String processErrorMessage(ExceptionInterface exceptionInterface,String runMesage){
		String baseMessage=exceptionInterface.getMessage();
		String result;
		if(StringUtils.isEmpty(runMesage)){
			result=baseMessage;
		}else{
			result=baseMessage+"("+runMesage+")";
		}
		return result;
	}
}
