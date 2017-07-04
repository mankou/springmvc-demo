package mang.demo.springmvc.common.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	
	public static class ruid{
		public final static String ruid="ruid";
		public final static String runame="runame";
		
	}
	
	/**
	 * 返回状态
	 * */
	public static class returnCode{
		public static final int ok=0;
		public static final int runtimeError=-1;
	}
	
	
	/**
	 * 运行状态
	 * */
	public static class returnType{
		public static final String returnOk="0";
		public static final String serviceException="1";
		public static final String runtimeError="2";
	}
	
	
	public static class exceptionCode{
		//车辆存在黑名单
		public final static int paramIsEmpty=1;
		
		public static Map<Integer,String> errMessageMap=new HashMap<Integer,String>();
		
		static {
			errMessageMap.put(paramIsEmpty, "参数为空");
		}
		
		
	}
	
}
