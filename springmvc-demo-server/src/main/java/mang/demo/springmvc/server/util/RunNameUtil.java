package mang.demo.springmvc.server.util;

import mang.demo.springmvc.common.util.Constant;

import mang.util.common.NullUtil;
import mang.util.common.StringUtil;

public class RunNameUtil {
	
	/**
	 * 处理runName
	 * */
	public static String processRunName(String runame){
		String result=null;
		if(NullUtil.isNull(runame)){
			result=Constant.ruid.runame;
		}else{
			result=Constant.ruid.runame+"-"+runame;
		}
		result=StringUtil.subString(result, 20);
		return result;
	}
}
