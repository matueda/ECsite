package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteConfirmAction extends ActionSupport{
	private String loginId;

	//execute、SUCCESS
	public String execute() {
		return SUCCESS;
	}

	//ゲッターセッター
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
