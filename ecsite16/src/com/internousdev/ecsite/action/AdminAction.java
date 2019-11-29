package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

//AdminActionにActionSupportを継承
public class AdminAction extends ActionSupport {
	//ここではexecuteを無条件でSUCCESSさせる
	public String execute() {
		return SUCCESS;
	}

}
