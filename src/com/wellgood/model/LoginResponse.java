package com.wellgood.model;

/**
 * 登录返回的json
 * @author Administrator
 *
 */
public class LoginResponse {

	//返回的字段flag
	private boolean success;
	//返回的消息
	private String message;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoginResponse [success=" + success + ", message=" + message
				+ "]";
	}
	

}
