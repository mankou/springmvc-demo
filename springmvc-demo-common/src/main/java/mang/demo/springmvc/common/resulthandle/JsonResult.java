package mang.demo.springmvc.common.resulthandle;

public class JsonResult<T> {
    private int status = 0;
    private String message="ok";
    private T data;
  
    public JsonResult(){
    	
    }
 
    public JsonResult(T data) {
        this.data = data;
    }
 
    public JsonResult(int status, String message) {
        this.status = status;
        this.message = message;
    }
 
    public JsonResult(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
 
    public int getStatus() {
        return status;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
 
    public T getData() {
        return data;
    }
 
    public void setData(T data) {
        this.data = data;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonResult [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
   
}