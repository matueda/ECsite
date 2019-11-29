package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AttentionRegistrationDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AttentionRegistrationCompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;
		AttentionRegistrationDAO attentionRegistrationDAO = new AttentionRegistrationDAO();
		int count = attentionRegistrationDAO.attentionRegistration(session.get("inputFamilyName").toString(), session.get("inputFirstName").toString(), session.get("inputFamilyNameKana").toString(), session.get("inputFirstNameKana").toString(), session.get("inputStreetAddress").toString(), session.get("inputCallNumber").toString(),session.get("attentionloginUserId").toString());

		if (count > 0) {
			result = SUCCESS;
		}
		session.remove("attentionloginUserId");
		session.remove("inputFamilyName");
		session.remove("inputFamilyNameKana");
		session.remove("inputFirstName");
		session.remove("inputFirstNameKana");
		session.remove("inputStreetAddress");
		session.remove("inputCallNumber");

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
