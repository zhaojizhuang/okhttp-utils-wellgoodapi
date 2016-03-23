package com.example.ok;

/**
 * ��¼���ص�json
 * @author Administrator
 *
 */
public class LoginResponse {

	//���ص��ֶ�flag
	private boolean success;
	//���ص���Ϣ
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
