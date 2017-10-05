package mang.demo.springmvc.common.resulthandle;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 自定义的jackson的转换类 用于设置一些通用的jackson的属性
 * */
public class JsonObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public JsonObjectMapper() {
		super();
		
		
		// 空值处理为空串
//		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//			@Override
//			public void serialize(Object value, JsonGenerator jg, SerializerProvider sp)
//					throws IOException, JsonProcessingException {
//				jg.writeString("");
//			}
//		});
		
		
		this.setSerializationInclusion(Include.NON_NULL);
		
	}
}
