package mang.demo.springmvc.common.util;


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
	
	
}
