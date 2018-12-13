package mang.demo.springmvc.server.util;

import mang.demo.springmvc.common.util.Constant;
import org.apache.commons.lang3.StringUtils;


public class RunNameUtil {
	
	/**
	 * 处理runName
	 * */
	public static String processRunName(String runame){
		String result=null;
		if(StringUtils.isEmpty(runame)){
			result=Constant.ruid.runame;
		}else{
			result=Constant.ruid.runame+"-"+runame;
		}
		result=StringUtils.substring(result, 0,20);
		return result;
	}
}
