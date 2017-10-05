package mang.demo.springmvc.common.resulthandle;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import mang.demo.springmvc.common.resulthandle.JsonResult;
 
@ControllerAdvice(basePackages = "mang.demo.springmvc")
public class GlobalRestfulResponseBodyAdvice implements ResponseBodyAdvice<Object> {
 
	@Override
    public Object beforeBodyWrite( Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> converterType,
        ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Object value=null;
        if (obj instanceof JsonResult) {
            value = (JsonResult) obj;
        }else if(obj instanceof String){
        	value=obj;
        }
        else {
            value = new JsonResult(obj);
        }
        return value;
    }
 
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
 
 
}