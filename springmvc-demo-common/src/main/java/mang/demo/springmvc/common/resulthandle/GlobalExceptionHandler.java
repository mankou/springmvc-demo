package mang.demo.springmvc.common.resulthandle;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import mang.demo.springmvc.common.exception.ServiceException;
 
@ControllerAdvice(basePackages = "mang.demo.springmvc")
public class GlobalExceptionHandler {
 
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult<Object> jsonErrorHandler(HttpServletRequest req, Exception ex) throws Exception {
        JsonResult<Object> value = null;
        if (ex != null) {
            if (ex instanceof ServiceException) {
                value = new JsonResult<Object>(((ServiceException) ex).getCode(), ex.getMessage());
            }
            else {
            	ex.printStackTrace();
                value = new JsonResult<Object>(-1, "runtime error");
            }
        }
        return value;
    }
}