package com.csii.lipei.springbootProject.exception;

/**
 * 自定义异常类
 * @author lipei
 *
 */
public class BootException extends RuntimeException {
	
	private String code;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BootException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	
}	
