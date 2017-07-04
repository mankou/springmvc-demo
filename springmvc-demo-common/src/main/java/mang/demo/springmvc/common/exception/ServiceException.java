/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package mang.demo.springmvc.common.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 9213584003139969215L;
    private int code;
    private Object data;

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    
    public ServiceException(int code,Object data,String message) {
        super(message);
        this.code = code;
        this.data=data;
    }
    
    public ServiceException(ExceptionInterface ei) {
    	super(ei.getMessage());
        this.code = ei.getCode();
    }
    
    public ServiceException(ExceptionInterface ei,String message) {
    	super(ErrorMessageHandle.processErrorMessage(ei, message));
        this.code = ei.getCode();
    }
    
    public ServiceException(ExceptionInterface ei,Object data,String message) {
    	super(ErrorMessageHandle.processErrorMessage(ei, message));
        this.code = ei.getCode();
        this.data=data;
    }
    
    public ServiceException(ExceptionInterface ei,Object data) {
    	super(ErrorMessageHandle.processErrorMessage(ei,""));
        this.code = ei.getCode();
        this.data=data;
    }
    

    public int getCode() {
        return code;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setCode(int code) {
		this.code = code;
	}
    
}
