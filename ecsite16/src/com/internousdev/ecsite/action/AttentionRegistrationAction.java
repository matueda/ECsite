package com.internousdev.ecsite.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class AttentionRegistrationAction extends ActionSupport {
	//ここではexecuteを無条件でSUCCESSさせる
	private Map<String, Object> session;
	public String execute() {
		return SUCCESS;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}