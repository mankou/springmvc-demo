package mang.demo.springmvc.common.exception;


import mang.util.common.NullUtil;


public class ErrorMessageHandle {
	
	/**
	 * 处理错误信息
	 * */
	public static String processErrorMessage(ExceptionInterface exceptionInterface,String runMesage){
		String baseMessage=exceptionInterface.getMessage();
		String result;
		if(NullUtil.isNull(runMesage)){
			result=baseMessage;
		}else{
			result=baseMessage+"("+runMesage+")";
		}
		return result;
	}
}
