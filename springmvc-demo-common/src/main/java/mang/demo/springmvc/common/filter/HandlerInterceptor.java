package mang.demo.springmvc.common.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class HandlerInterceptor extends HandlerInterceptorAdapter {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<String> filterUrl = new ArrayList(Arrays.asList(
            "/login/loginin"
            ));
    
    
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
//    	System.out.println("preHandle");
    	String ip=request.getRemoteAddr();
    	return true;
    }  
  
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
        //Log.info(request);  
//        System.out.println("postHandle");
    }  
  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
//          System.out.println("afterCompletion");
    } 
    

}
