package com.internousdev.ecsite.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeChangeAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	//無条件でSUCCESS
	public String execute(){
			return SUCCESS;
	}

	//ゲット&オーバーライド
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
