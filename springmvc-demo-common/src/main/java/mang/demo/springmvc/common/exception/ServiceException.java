package mang.demo.springmvc.common.exception;

import org.apache.log4j.Logger;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 9213584003139969215L;
    private static Logger logger=Logger.getLogger("log");
    
    private int code;
 
    public ServiceException(int code, String message) {
    	super(ErrorMessageHandle.processErrorMessage(code, message));
        this.code = code;
        logger.error(code+" "+super.getMessage());
    }
 
    public int getCode() {
        return code;
    }
}