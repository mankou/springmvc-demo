package mang.demo.springmvc.common.resulthandle;

import mang.util.common.JsonUtil;
import net.sf.json.JSONObject;

public class JsonResultUtil {
	
	/**
	 * 将json字符串转换成JsonResult类.
	 * 
	 * 这里的难点就在于JsonResult中的Data的类型是动态的
	 * */
	public static JsonResult str2Obj(String str,Class clazz){
		
		JSONObject jsonObject = JSONObject.fromObject(str);
		int status=jsonObject.getInt("status");
		String message=jsonObject.getString("message");
		String dataStr=jsonObject.getString("data");
		
		Object data=JsonUtil.string2Obj(dataStr, clazz);
		
		
		JsonResult jsonResult=new JsonResult<Object>();
		jsonResult.setStatus(status);
		jsonResult.setMessage(message);
		jsonResult.setData(data);
		
		return jsonResult;
	}
}
