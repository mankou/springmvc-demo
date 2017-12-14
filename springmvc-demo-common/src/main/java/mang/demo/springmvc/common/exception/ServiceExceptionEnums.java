package mang.demo.springmvc.common.exception;

public enum ServiceExceptionEnums implements ExceptionInterface {
	
	//公用的错误码
	common_paramIsEmpty(1000,"参数不能为空"),
	server_test(2,"测试业务异常"),
	
	ok(0,"ok");
	
	public int code; 
	public String message; 
	
	
	private ServiceExceptionEnums(int code, String message){ 
		this.code = code; 
		this.message = message; 
	} 
	

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	/**
	 * 通过code取得枚举类型的message
	 * */
	public static String  code2Message(int code) {
		ServiceExceptionEnums enums=getInstance(code);
		if(enums!=null){
			return enums.getMessage();
		}else{
			return null;
		}
	}
	
	/**
	 * 通过code直接获取枚举类型
	 * */
	public static ServiceExceptionEnums getInstance(int code) {
		// 循环找
		for (ServiceExceptionEnums e : ServiceExceptionEnums.values()) {
			if (e.getCode()==code) {
				return e;
			}
		}
		return null;
		
//		int length = ServiceExceptionEnums.values().length;
//		if (code >= length) {
//			return null;
//		}
//
//		return ServiceExceptionEnums.values()[code];
	}

}
