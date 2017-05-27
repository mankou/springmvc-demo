package mang.demo.springmvc.common.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	
	public static class ruid{
		public final static String ruid="ruid";
		public final static String runame="runame";
		
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
